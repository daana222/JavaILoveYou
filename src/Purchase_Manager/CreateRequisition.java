/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Purchase_Manager;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import javax.swing.BorderFactory;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * Object-Oriented Programming Concepts: 
 * 1. **Encapsulation**: Private fields, methods, and modular methods for specific tasks.
 * 2. **Abstraction**: Methods hide file operations, table refreshing, and rendering logic.
 * 3. **Inheritance**: Extending DefaultTableCellRenderer for custom table rendering.
 * 4. **Polymorphism**: Method overriding to change behavior of inherited methods.
 */
public class CreateRequisition extends javax.swing.JFrame {

    // Encapsulation: private access modifier used for LOGGER
    private static final Logger LOGGER = Logger.getLogger(CreateRequisition.class.getName());
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"PR ID", "Item ID", "Item Name", "Quantity Required", "Cost Per Unit", "Total Amount", "Requisition Date", "Supplier ID", "Status"};
    private int row = -1;
    private static final String FILE_PATH = "C:\\Users\\Jiannaa\\Desktop\\PurchaseRequisition.txt";
        private List<String[]> requisitions = new ArrayList<>();
            private int selectedRow = -1;

    // Static block for Logger configuration (Abstraction: hides setup details)
    static {
        try {
         // Abstraction: Logger setup logic is hidden in a static block
            FileHandler fileHandler = new FileHandler("logfile.log", true); // Append to the file
            fileHandler.setFormatter(new SimpleFormatter()); // Simple formatting for logs
            LOGGER.addHandler(fileHandler);
            LOGGER.setUseParentHandlers(false); // Avoid console duplication
        } catch (IOException e) {
            System.err.println("Failed to initialize logger handler: " + e.getMessage());
        }
    }


    public CreateRequisition() {
        initComponents(); // Initializes components
        model.setColumnIdentifiers(columnName);
        jTable1.setModel(model); // Encapsulation: Table model setup
        populateComboBox();
        populateStatusComboBox();
        setupCustomRenderer(); // Polymorphism & Inheritance applied
    }
    
// Abstraction: Encapsulates renderer logic using Inheritance and Polymorphism
private void setupCustomRenderer() {
    jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Apply background color only to the "Status" column (index 8)
            if (column == 8) { 
    String status = (String) table.getValueAt(row, column);

    if ("Approved".equalsIgnoreCase(status)) {
        setText("✅ " + status); // Add green check emoji
        c.setBackground(new Color(144, 238, 144)); // Light Green for Approved
    } else if ("Rejected".equalsIgnoreCase(status)) {
        setText("❌ " + status); // Add red cross emoji
        c.setBackground(new Color(255, 182, 193)); // Light Red for Rejected
    } else {
        setText("⏳ " + status); // Add hourglass emoji
        c.setBackground(new Color(255, 255, 224)); // Light Yellow for Pending
    }

    // Override selection behavior to keep custom background
 
    c.setForeground(Color.BLACK); // Keep text black for all statuses
} else {
    // Reset non-status columns
    if (isSelected) {
        c.setBackground(new Color(173, 216, 230)); // Light Blue for selected rows
        c.setForeground(Color.BLACK);
    } else {
        c.setBackground(Color.WHITE);
        c.setForeground(Color.BLACK);
    }
}

return c;

        }
    });
}



  

// Encapsulation: Model is set up here and is accessed indirectly through this method.
    private void setupTable() {
        model.setColumnIdentifiers(columnName);
        jTable1.setModel(model);
    }

// Encapsulation: File reading and table population logic are encapsulated in this method.
    private void loadRequisitions() {
        requisitions.clear(); // Clear existing data
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                if (rowData.length == columnName.length) {
                    requisitions.add(rowData); // Add valid rows to the list
                }
            }
            refreshTable(); // Encapsulation: Updates the table view
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

// Abstraction: Updates the table with current data stored in `requisitions`
    private void refreshTable() {
        model.setRowCount(0);
        for (String[] rowData : requisitions) {
            model.addRow(rowData);
        }
    }


    // Encapsulation: Handles saving data to the file
    private void saveRequisitions() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write(String.join(",", columnName));
            bw.newLine();
            for (String[] rowData : requisitions) {
                bw.write(String.join(",", rowData));
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this, "Data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    // Abstraction: Populates status dropdown
    private void populateStatusComboBox() {
        cbStatusPR.setModel(new DefaultComboBoxModel<>(new String[]{"Pending", "Approved", "Rejected"}));
        cbStatusPR.setSelectedItem("Pending");
    }

    // Abstraction: Populates PR ID dropdown dynamically
    private void populatePRComboBox() {
        cbPRID.removeAllItems();
        cbPRID.addItem("PR ID");
        for (String[] rowData : requisitions) {
            cbPRID.addItem(rowData[0]); // Add PR IDs
        }
    }

// Abstraction: Updates a row when "Edit" is clicked
    private void updateRow(int row, String prID, String status) {
        requisitions.get(row)[0] = prID;
        requisitions.get(row)[8] = status;
        refreshTable(); // Refresh table with updated data
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        label2 = new java.awt.Label();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        cbStatusPR = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbPRID = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jButton5.setText("LogOut");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)))
                .addGap(35, 35, 35))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(model);
        jTable1.setPreferredSize(new java.awt.Dimension(890, 500));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel2.setText("PR ID:");

        jLabel1.setText("Status:");

        jButton4.setText("View");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Dark Mode");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPRID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbStatusPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButton4)
                        .addGap(43, 43, 43)
                        .addComponent(btnSearch)
                        .addGap(46, 46, 46)
                        .addComponent(btnDel)
                        .addGap(35, 35, 35)
                        .addComponent(btnEdit)
                        .addGap(26, 26, 26)
                        .addComponent(btnSave)
                        .addGap(83, 83, 83)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStatusPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbPRID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnDel)
                    .addComponent(btnEdit)
                    .addComponent(btnSave)
                    .addComponent(jButton4)
                    .addComponent(jToggleButton1))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
   if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
   }
String prID = (String) cbPRID.getSelectedItem();
        String status = (String) cbStatusPR.getSelectedItem();
        updateRow(selectedRow, prID, status); // Encapsulation: Row update logic
        JOptionPane.showMessageDialog(this, "Row updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    

    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PM pm = new PM();
        pm.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Items it = new Items();
        it.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Suppliers sp = new Suppliers();
        sp.setVisible(true);
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
 
  

   private void loadDataFromFile() {
    File file = new File(FILE_PATH);
    if (!file.exists()) {
        System.out.println("Data file not found. Starting with an empty table.");
        return;
    }

   try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
    model.setRowCount(0); // Clear existing data
    String line = br.readLine(); // Read and skip the header line
    while ((line = br.readLine()) != null) { // Start reading data from the second line
        String[] rowData = line.split(",");
        if (rowData.length == columnName.length) { // Correct column name reference
            model.addRow(rowData); // Add only valid rows to the table
        } else {
            LOGGER.log(Level.WARNING, "Skipped a line due to incorrect column count: {0}", line);
        }
    }
} catch (Exception ex) {
    LOGGER.log(Level.SEVERE, "Error loading data from file: {0}", ex.getMessage());
    JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

}

    
    
private void populateComboBox() {
    String filePath = "C:\\Users\\Jiannaa\\Desktop\\PurchaseRequisition.txt"; // Path to PR.txt
    File file = new File(filePath);

    if (!file.exists()) {
        JOptionPane.showMessageDialog(this, "PR.txt file not found: " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        cbPRID.removeAllItems(); // Clear previous items
        cbPRID.addItem(" PR ID"); // Default item

        String line;
        br.readLine(); // Skip header
        while ((line = br.readLine()) != null) {
            String[] rowData = line.split(",");
            if (rowData.length > 0) {
                String prID = rowData[0]; // Assuming PR ID is in the first column
                cbPRID.addItem(prID); // Add PR ID to combo box
            }
        }
    } catch (IOException ex) {
        LOGGER.log(Level.SEVERE, "Error loading PR IDs", ex);
        JOptionPane.showMessageDialog(this, "Error loading PR IDs: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}






    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased

    selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            cbPRID.setSelectedItem(model.getValueAt(selectedRow, 0).toString());
            cbStatusPR.setSelectedItem(model.getValueAt(selectedRow, 8).toString());
        }

    }//GEN-LAST:event_jTable1MouseReleased

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed

               if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
               }
         requisitions.remove(selectedRow);
        selectedRow = -1;
        refreshTable(); // Update UI
        JOptionPane.showMessageDialog(this, "Row deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveRequisitions(); // Abstraction: Save logic encapsulated
    }//GEN-LAST:event_btnSaveActionPerformed

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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
    String selectedPRID = (String) cbPRID.getSelectedItem();
        if (selectedPRID == null || selectedPRID.equals("PR ID")) {
            JOptionPane.showMessageDialog(this, "Please select a valid PR ID!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
}
// Abstraction: Filter logic
        model.setRowCount(0);
        for (String[] rowData : requisitions) {
            if (rowData[0].equalsIgnoreCase(selectedPRID)) {
                model.addRow(rowData);
            }
        }
        
   
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        loadRequisitions(); // Reload data
        populatePRComboBox();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

  // New method to calculate and display the Total Amount







    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CreateRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateRequisition().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbPRID;
    private javax.swing.JComboBox<String> cbStatusPR;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
