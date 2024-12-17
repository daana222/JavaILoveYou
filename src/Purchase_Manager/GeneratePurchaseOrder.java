/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Purchase_Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jiannaa
 */



public class GeneratePurchaseOrder extends javax.swing.JFrame {
   
// Encapsulation: Variables are private and accessible only through methods
    private DefaultTableModel model;
    private final String[] columnNames = {"PO ID", "PR ID", "Item ID", "Item Name", "Quantity Required",
            "Cost Per Unit", "Total Amount", "Requisition Date", "Supplier ID", "OrderDate", "Status"};
    private int row = -1;
    private static final Logger LOGGER = Logger.getLogger(GeneratePurchaseOrder.class.getName());

    // File paths as constants
    private static final String PR_FILE_PATH = "C:\\Users\\Jiannaa\\Desktop\\PR.txt";
    private static final String PO_FILE_PATH = "C:\\Users\\Jiannaa\\Desktop\\PO.txt";

    // Constructor
    public GeneratePurchaseOrder() {
        // Initialize the model first
    model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column != 8; // Make Status column read-only
        }
    };
    model.setColumnIdentifiers(columnNames);

    initComponents();
    jTable2.setModel(model); // Set table model
    populateComboBox();      // Populate PR ID ComboBox

btnAdd.addActionListener(evt -> btnAddActionPerformed(evt));


    }

    // Abstraction: Initializes table model with column names and read-only rules
    private void initializeTableModel() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 8; // Status column is read-only
            }
        };
        model.setColumnIdentifiers(columnNames);
        jTable2.setModel(model);
    }

    // Abstraction: Sets up ComboBox listener to load PR details
    private void setupComboBoxListener() {
        cbPRID.addActionListener(evt -> {
            String selectedPRID = (String) cbPRID.getSelectedItem();
            if (selectedPRID != null && !selectedPRID.equals("Select PR ID")) {
                loadPRDetails(selectedPRID);
            }
        });
    }

    // Abstraction: Populates ComboBox with Approved PR IDs
    private void populateComboBox() {
    String filePath = "C:\\Users\\Jiannaa\\Desktop\\PR.txt"; // Path to PR.txt
    File file = new File(filePath);

    if (!file.exists()) {
        JOptionPane.showMessageDialog(this, "File not found: " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        cbPRID.removeAllItems(); // Clear ComboBox
        cbPRID.addItem("Select PR ID"); // Default option

        br.readLine(); // Skip header
        String line;

        while ((line = br.readLine()) != null) {
            String[] rowData = line.split(",");
            if (rowData.length >= 9 && "Approved".equalsIgnoreCase(rowData[8].trim())) {
                cbPRID.addItem(rowData[0]); // Add PR ID to ComboBox if status is Approved
            }
        }
    } catch (IOException ex) {
        LOGGER.log(Level.SEVERE, "Error loading Approved PR IDs", ex);
        JOptionPane.showMessageDialog(this, "Error loading Approved PR IDs: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    // Abstraction: Loads requisition details for selected PR ID
    private void loadPRDetails(String selectedPRID) {
        try (BufferedReader br = new BufferedReader(new FileReader(PR_FILE_PATH))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                if (rowData[0].equalsIgnoreCase(selectedPRID)) {
                    model.addRow(new Object[]{"-", rowData[0], rowData[1], rowData[2], rowData[3],
                            rowData[4], rowData[5], rowData[6], rowData[7], LocalDate.now(), "Pending"});
                    return;
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error loading PR details", ex);
        }
    }

    // Abstraction: Loads PO and PR data into the table
    private void loadDataFromFile() {
    String poFilePath = "C:\\Users\\Jiannaa\\Desktop\\PO.txt";
    File poFile = new File(poFilePath);

    if (!poFile.exists()) {
        JOptionPane.showMessageDialog(this, "PO.txt file not found!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(poFile))) {
        model.setRowCount(0); // Clear table first
        String line = br.readLine(); // Skip header
        while ((line = br.readLine()) != null) {
            String[] rowData = line.split(",");
            // Only add rows with valid PO IDs (not "-")
            if (rowData.length >= 11 && !rowData[0].trim().equals("-")) {
                model.addRow(rowData); // Add to table only if PO ID is not "-"
            }
        }
    } catch (IOException ex) {
        LOGGER.log(Level.SEVERE, "Error loading PO.txt", ex);
        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    // Encapsulation: Saves data to the PO file
    private void saveDataToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PO_FILE_PATH))) {
            bw.write(String.join(",", columnNames));
            bw.newLine();
            for (int row = 0; row < model.getRowCount(); row++) {
                StringBuilder rowData = new StringBuilder();
                for (int col = 0; col < model.getColumnCount(); col++) {
                    rowData.append(model.getValueAt(row, col).toString());
                    if (col < model.getColumnCount() - 1) rowData.append(",");
                }
                bw.write(rowData.toString());
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this, "Data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error saving data to PO file", ex);
        }
    }

  



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        label2 = new java.awt.Label();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbPRID = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jButton1.setText("Main Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("List of Items");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("List of Suppliers");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N
        label2.setText("Purchase Manager");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "View Requisition", "Create Requisition" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "View Purchase Order", "Generate Purchase Order" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addGap(32, 32, 32)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jTable2.setModel(model);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setText("PR ID:");

        cbPRID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPRIDActionPerformed(evt);
            }
        });

        jLabel1.setText("PO ID:");

        jButton4.setText("View");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbPRID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 531, Short.MAX_VALUE)))
                        .addContainerGap(139, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jButton4)
                                .addGap(31, 31, 31)
                                .addComponent(btnSearch)
                                .addGap(64, 64, 64)
                                .addComponent(btnSave)
                                .addGap(55, 55, 55)
                                .addComponent(btnDel)
                                .addGap(39, 39, 39)
                                .addComponent(btnEdit)
                                .addGap(43, 43, 43)
                                .addComponent(btnAdd))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cbPRID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnDel)
                    .addComponent(btnEdit)
                    .addComponent(btnSave)
                    .addComponent(jButton4)
                    .addComponent(btnAdd))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PM pm = new PM();
        pm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Items it = new Items();
        it.setVisible(true);
         this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Suppliers sp = new Suppliers();
        sp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        String selectedOption = (String) jComboBox2.getSelectedItem();

        if ("View Requisition".equals(selectedOption)) {
            // Open View Requisition page
            new ViewRequisition().setVisible(true); // Replace with actual page class
        } else if ("Create Requisition".equals(selectedOption)) {
            // Open Create Requisition page
            new CreateRequisition().setVisible(true); // Replace with actual page class
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to edit", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String poID = jTextField1.getText().trim(); // User manually enters PO ID
    if (poID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a valid PO ID!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Set PO ID and update table manually
    model.setValueAt(poID, row, 0); // Update PO ID column
    JOptionPane.showMessageDialog(this, "PO ID updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);



    }//GEN-LAST:event_btnEditActionPerformed

 

    
    public void ClearTextField(){
   cbPRID.setSelectedItem("PR ID");

}
    
    
    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
                row = jTable2.getSelectedRow();

    }//GEN-LAST:event_jTable2MouseReleased

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
      if (row != -1) {
            model.removeRow(row);
        }
         
        
    
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
           saveDataToFile();



    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
    String selectedPRID = (String) cbPRID.getSelectedItem();
        model.setRowCount(0);
        loadPRDetails(selectedPRID);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
         String selectedOption = (String) jComboBox3.getSelectedItem();

        if ("View Purchase Order".equals(selectedOption)) {
            // Open View Requisition page
            new ViewPurchaseOrder().setVisible(true); // Replace with actual page class
        } else if ("Generate Purchase Order".equals(selectedOption)) {
            // Open Create Requisition page
            new GeneratePurchaseOrder().setVisible(true); // Replace with actual page class
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void cbPRIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPRIDActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbPRIDActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       loadDataFromFile(); 
       populateComboBox();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    String enteredPOID = jTextField1.getText().trim(); // PO ID from text field
    String selectedPRID = (String) cbPRID.getSelectedItem(); // PR ID from ComboBox

    // Validation checks
    if (enteredPOID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a valid PO ID!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (selectedPRID == null || selectedPRID.equals("Select PR ID")) {
        JOptionPane.showMessageDialog(this, "Please select a valid PR ID!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Read PR details from PR.txt
    String filePath = "C:\\Users\\Jiannaa\\Desktop\\PR.txt";
    File file = new File(filePath);

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line = br.readLine(); // Skip header
        while ((line = br.readLine()) != null) {
            String[] rowData = line.split(",");
            if (rowData[0].equalsIgnoreCase(selectedPRID)) {
                // Add row to table with manually entered PO ID
                model.addRow(new Object[]{
                    enteredPOID, rowData[0], rowData[1], rowData[2], rowData[3],
                    rowData[4], rowData[5], rowData[6], rowData[7], LocalDate.now(), "Pending"
                });

                JOptionPane.showMessageDialog(this, "Row added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "No details found for the selected PR ID!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
        LOGGER.log(Level.SEVERE, "Error loading PR details", ex);
        JOptionPane.showMessageDialog(this, "Error loading PR details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_btnAddActionPerformed

     
   
   
    
    
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GeneratePurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneratePurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneratePurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneratePurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneratePurchaseOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbPRID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables

}
