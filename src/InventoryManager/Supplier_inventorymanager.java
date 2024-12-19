package InventoryManager;


import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

    
    
   
public class Supplier_inventorymanager extends javax.swing.JFrame {
private DefaultTableModel model= new DefaultTableModel();
    private String[]columnName={"Supplier ID","Supplier Name","Supplier Registration Date","Supplier Contact","Supplier Email"};
    private int row=-1;
         

   
    public Supplier_inventorymanager() {
        model.setColumnIdentifiers(columnName);
        initComponents();
        loadDataFromFile();
    }
    
 private void setupCustomRenderers() {
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setForeground(Color.BLACK);
                return c;
            }
        });
    }

    private void loadDataFromFile() {
        String filePath = "supplier.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "Data file not found: " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            model.setRowCount(0);
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",", -1);
                if (rowData.length == 5) {
                    model.addRow(rowData);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

     // OOP Principle: Abstraction - Generates Supplier IDs while hiding internal logic from the main program.
    private String generateSupplierID() {
    int maxID = 0; 
    
    for (int i = 0; i < model.getRowCount(); i++) {
        String currentID = model.getValueAt(i, 0).toString(); 
        if (currentID.startsWith("SP")) {
            try {
                int numericID = Integer.parseInt(currentID.substring(2));
                if (numericID > maxID) {
                    maxID = numericID; 
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid Supplier ID format: " + currentID);
            }
        }
    }
    
    maxID++; 
    return String.format("SP%03d", maxID); 
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Supplier_add_button = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Supplier_delete_button = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        Supplier_edit_button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        Supplier_search_button = new javax.swing.JButton();
        Supplier_save_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Supplier Name");

        Supplier_add_button.setText("Add");
        Supplier_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Supplier_add_buttonActionPerformed(evt);
            }
        });

        jLabel8.setText("Supplier Email");

        jLabel5.setText("Supplier Registration Date");

        jLabel6.setText("Supplier Contact");

        Supplier_delete_button.setText("Delete");
        Supplier_delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Supplier_delete_buttonActionPerformed(evt);
            }
        });

        Supplier_edit_button.setText("Edit");
        Supplier_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Supplier_edit_buttonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel10.setText("Inventory Manager");

        jButton7.setText("Main Menu");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton5.setText("Supplier");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Item Inventory");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton9.setText("Stock Level");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(29, 29, 29))
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addGap(31, 31, 31)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(30, 30, 30)
                .addComponent(jButton9)
                .addGap(33, 33, 33))
        );

        Supplier_search_button.setText("Search");
        Supplier_search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Supplier_search_buttonActionPerformed(evt);
            }
        });

        Supplier_save_button.setText("Save");
        Supplier_save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Supplier_save_buttonActionPerformed(evt);
            }
        });

        jTable1.setModel(model);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Supplier_save_button)
                        .addGap(41, 41, 41)
                        .addComponent(Supplier_search_button)
                        .addGap(48, 48, 48)
                        .addComponent(Supplier_delete_button)
                        .addGap(28, 28, 28)
                        .addComponent(Supplier_edit_button)
                        .addGap(28, 28, 28)
                        .addComponent(Supplier_add_button)
                        .addGap(106, 106, 106))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel8)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Supplier_delete_button)
                    .addComponent(Supplier_add_button)
                    .addComponent(Supplier_save_button)
                    .addComponent(Supplier_edit_button)
                    .addComponent(Supplier_search_button))
                .addGap(6, 6, 6))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Supplier_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Supplier_add_buttonActionPerformed
          try {
        // Generate Supplier ID
        String supplierID = generateSupplierID();
        
        // Extract data from input fields
        String supplierName = jTextField2.getText().trim();
        String contact = jTextField6.getText().trim();
        String email = jTextField8.getText().trim();
        Date date = jDateChooser1.getDate();
        
        if (date == null) {
            JOptionPane.showMessageDialog(this, "Please select a date!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Format the date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String registrationDate = sdf.format(date);
        
        // Create a Supplier object
        Supplier supplier = new Supplier(supplierID, supplierName, registrationDate, contact, email);
        
        // Validate supplier fields
        if (!supplier.isComplete()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!supplier.isValidEmail()) {
            JOptionPane.showMessageDialog(this, "Invalid email format!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Add the supplier data to the table
        model.addRow(new Object[]{supplier.getSupplierID(), supplier.getSupplierName(), supplier.getRegistrationDate(), supplier.getContact(), supplier.getEmail()});
        
        JOptionPane.showMessageDialog(this, "Supplier added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        ClearTextField();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_Supplier_add_buttonActionPerformed

    private void Supplier_delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Supplier_delete_buttonActionPerformed
        if(row==-1){
            JOptionPane.showMessageDialog(this,"Please selesct a row to delete");
        }
        else{
            model.removeRow(row);
            ClearTextField();
            row=-1;
        }
    }//GEN-LAST:event_Supplier_delete_buttonActionPerformed

    private void Supplier_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Supplier_edit_buttonActionPerformed

        try {

            if (
                jTextField2.getText().isEmpty() ||
                jTextField8.getText().isEmpty() ||
                jTextField6.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop further execution
            }

            if (jDateChooser1.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Please select a date!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String suppliedDate = sdf.format(jDateChooser1.getDate());

            if (!jTextField8.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            model.setValueAt(jTextField2.getText(), row, 1);
            model.setValueAt(suppliedDate, row, 2);
            model.setValueAt(jTextField6.getText(), row, 3);
            model.setValueAt(jTextField8.getText(), row, 4);

            JOptionPane.showMessageDialog(this, "Supplier updated successfully!");
            ClearTextField();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Supplier_edit_buttonActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       inventory_manager_mainmenu mainmenu = new inventory_manager_mainmenu();
        mainmenu.setVisible(true);
        this.dispose();         
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       Supplier_inventorymanager Supplier = new Supplier_inventorymanager();
        Supplier.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        item_inventory item = new item_inventory();
        item.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        stocklevel_inventory_manager stock = new stocklevel_inventory_manager();
        stock.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void Supplier_search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Supplier_search_buttonActionPerformed
        String searchQuery = jTextField2.getText().trim();

        if (searchQuery.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Supplier Name to search!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel filteredModel = new DefaultTableModel();
        filteredModel.setColumnIdentifiers(columnName);

        if (searchQuery.equalsIgnoreCase("all")) {

            for (int i = 0; i < model.getRowCount(); i++) {
                Object[] rowData = {
                    model.getValueAt(i, 0),
                    model.getValueAt(i, 1),
                    model.getValueAt(i, 2),
                    model.getValueAt(i, 3),
                    model.getValueAt(i, 4)
                };
                filteredModel.addRow(rowData);
            }
        } else {

            for (int i = 0; i < model.getRowCount(); i++) {
                String supplierName = model.getValueAt(i, 1).toString().toLowerCase();
                if (supplierName.contains(searchQuery.toLowerCase())) {
                    Object[] rowData = {
                        model.getValueAt(i, 0),
                        model.getValueAt(i, 1),
                        model.getValueAt(i, 2),
                        model.getValueAt(i, 3),
                        model.getValueAt(i, 4)
                    };
                    filteredModel.addRow(rowData);
                }
            }
        }

        if (filteredModel.getRowCount() > 0) {
            jTable1.setModel(filteredModel);
        } else {
            JOptionPane.showMessageDialog(this, "No matching supplier found.", "No Results", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_Supplier_search_buttonActionPerformed

    private void Supplier_save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Supplier_save_buttonActionPerformed
         String filePath = "supplier.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < model.getColumnCount(); i++) {
                bw.write(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) bw.write(",");
            }
            bw.newLine();
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    bw.write(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) bw.write(",");
                }
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this, "Data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Supplier_save_buttonActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
       row = jTable1.getSelectedRow();
    
    // Safely extract values from the table
    String supplierID = String.valueOf(model.getValueAt(row, 0));
    String supplierName = String.valueOf(model.getValueAt(row, 1));
    String suppliedDate = String.valueOf(model.getValueAt(row, 2));
    String supplierContact = String.valueOf(model.getValueAt(row, 3));
    String supplierEmail = String.valueOf(model.getValueAt(row, 4));
    
    // Set the values into the fields
    jTextField2.setText(supplierName);
    jTextField6.setText(supplierContact);
    jTextField8.setText(supplierEmail);
    
    // Safely parse and set the date
    try {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(suppliedDate);
        jDateChooser1.setDate(date);
    } catch (Exception ex) {
        // Log the error and show a message, but continue execution
        System.err.println("Error parsing date: " + ex.getMessage());
        jDateChooser1.setDate(null); // Clear the date chooser if parsing fails
    }


    }//GEN-LAST:event_jTable1MouseReleased

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier_inventorymanager().setVisible(true);
            }
        });
    }



 public void ClearTextField(){
   
    jTextField2.setText("");
    jDateChooser1.setDate(null);
    jTextField8.setText("");
    jTextField6.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Supplier_add_button;
    private javax.swing.JButton Supplier_delete_button;
    private javax.swing.JButton Supplier_edit_button;
    private javax.swing.JButton Supplier_save_button;
    private javax.swing.JButton Supplier_search_button;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
