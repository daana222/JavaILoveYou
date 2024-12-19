
package InventoryManager;




import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

   
public class item_inventory extends javax.swing.JFrame {
   private static final Logger LOGGER = Logger.getLogger(item_inventory.class.getName());
    private DefaultTableModel model= new DefaultTableModel();
    private String[]columnName={"itemID"," item Name","Supplier ID","Current Stock Level","Reorder Level","Cost perunit","Selling Price Unit","Last Updated Date"};
    private int row=-1;
    private int lastItemID = 10000; 


    
    public item_inventory() {
        initComponents();
        model.setColumnIdentifiers(columnName);
        jTable1.setModel(model);
        populateComboBox();
        loadDataFromFile();
        setupCustomStockRenderer();
    }

    
    
  private void setupCustomStockRenderer() {
    jTable1.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            try {
                // Extract stock levels from the table
                int currentStock = Integer.parseInt(table.getValueAt(row, 3).toString());
                int reorderLevel = Integer.parseInt(table.getValueAt(row, 4).toString());

                // Create StockLevelChecker object
                StockLevelChecker stockChecker = new StockLevelChecker(currentStock, reorderLevel);
                
                // Check stock level and set color accordingly
                if (stockChecker.isStockBelowReorderLevel()) {
                    c.setForeground(Color.RED);
                } else {
                    c.setForeground(Color.BLACK);
                }
            } catch (NumberFormatException | NullPointerException e) {
                c.setForeground(Color.BLACK);
            }
            return c;
        }
    });
}
    
    
    private String generatedItemID() {
    int maxID = 0; 
   
    for (int i = 0; i < model.getRowCount(); i++) {
        String id = String.valueOf(model.getValueAt(i, 0));
        if (id.startsWith("IT")) {
            try {
                int numericID = Integer.parseInt(id.substring(2)); 
                if (numericID > maxID) {
                    maxID = numericID;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid ID format: " + id);
            }
        }
    }
    
    int newID = maxID + 1;
   
    return "IT" + String.format("%03d", newID);
}
  
   
  
   private void loadDataFromFile() {
        String filePath = "items.txt";
        File file = new File(filePath);

        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "File not found: " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            model.setRowCount(0); // Clear the table
            br.readLine(); // Skip the header

            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",", -1);
                if (rowData.length == columnName.length) {
                    model.addRow(new Object[]{
                        rowData[0].trim(), rowData[1].trim(), rowData[2].trim(), rowData[3].trim(),
                        rowData[4].trim(), rowData[5].trim(), rowData[6].trim(), rowData[7].trim()
                    });
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
  


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        iteminventory_deletebutton = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        iteminventory_searchbutton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        iteminventory_editbutton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        iteminventory_addbutton = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        iteminventory_save_button = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Selling Price Unit");

        jLabel2.setText("Item Name");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        iteminventory_deletebutton.setText("Delete");
        iteminventory_deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iteminventory_deletebuttonActionPerformed(evt);
            }
        });

        iteminventory_searchbutton.setText("Search");
        iteminventory_searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iteminventory_searchbuttonActionPerformed(evt);
            }
        });

        jLabel4.setText("Supplier ID");

        jLabel6.setText("Reorder Level");

        iteminventory_editbutton.setText("Edit");
        iteminventory_editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iteminventory_editbuttonActionPerformed(evt);
            }
        });

        jLabel7.setText("Cost perunit");

        iteminventory_addbutton.setText("Add");
        iteminventory_addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iteminventory_addbuttonActionPerformed(evt);
            }
        });

        jLabel5.setText("Current Stock Level");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel9.setText("Inventory Manager");

        jButton6.setText("Main Menu");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText("Supplier");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("Item Inventory");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Stock Level");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(29, 29, 29))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addGap(29, 29, 29)
                .addComponent(jButton5)
                .addGap(30, 30, 30)
                .addComponent(jButton7)
                .addGap(33, 33, 33)
                .addComponent(jButton9)
                .addGap(20, 20, 20))
        );

        iteminventory_save_button.setText("Save");
        iteminventory_save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iteminventory_save_buttonActionPerformed(evt);
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
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel7)
                                .addGap(32, 32, 32)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jTextField7))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6)
                            .addComponent(jTextField3))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(iteminventory_save_button)
                                .addGap(35, 35, 35)
                                .addComponent(iteminventory_searchbutton)
                                .addGap(31, 31, 31)
                                .addComponent(iteminventory_deletebutton)
                                .addGap(61, 61, 61)
                                .addComponent(iteminventory_editbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(53, 53, 53)
                                .addComponent(iteminventory_addbutton))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iteminventory_deletebutton)
                    .addComponent(iteminventory_addbutton)
                    .addComponent(iteminventory_save_button)
                    .addComponent(iteminventory_editbutton)
                    .addComponent(iteminventory_searchbutton))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void iteminventory_deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iteminventory_deletebuttonActionPerformed
        if(row==-1){
            JOptionPane.showMessageDialog(this,"Please selesct a row to delete");
        }
        else{
            model.removeRow(row);
            ClearTextField();
            row=-1;
        }
    }//GEN-LAST:event_iteminventory_deletebuttonActionPerformed

    private void iteminventory_searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iteminventory_searchbuttonActionPerformed
String searchItemName = jTextField2.getText().trim();

    // Check for empty input
    if (searchItemName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter an Item Name or type 'All' to display all records.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    DefaultTableModel filteredModel = new DefaultTableModel();
    filteredModel.setColumnIdentifiers(columnName);

    String filePath = "items.txt"; // Path to the items file
    File file = new File(filePath);
    if (!file.exists()) {
        JOptionPane.showMessageDialog(this, "File not found at: " + filePath, "File Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean found = false;
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        br.readLine(); // Skip the header
        String line;
        while ((line = br.readLine()) != null) {
            String[] rowData = line.split(",", -1);
            if (rowData.length >= 8) {
                String itemName = rowData[1].trim();

                // Check if 'All' is typed or if item name matches search
                if (searchItemName.equalsIgnoreCase("all") || itemName.toLowerCase().contains(searchItemName.toLowerCase())) {
                    filteredModel.addRow(new Object[]{
                        rowData[0].trim(), // itemID
                        itemName,          // itemName
                        rowData[2].trim(), // currentStockLevel
                        rowData[3].trim(), // reorderLevel
                        rowData[4].trim(), // lastUpdatedDate
                        rowData[5].trim(), // Additional fields if needed
                        rowData[6].trim(),
                        rowData[7].trim()
                    });
                    found = true;
                }
            }
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Display results
    if (found) {
        jTable1.setModel(filteredModel);
    } else {
        JOptionPane.showMessageDialog(this, "No records found for Item Name containing: " + searchItemName, "No Results", JOptionPane.INFORMATION_MESSAGE);
        jTable1.setModel(model); // Reset table to original model
    }

    }//GEN-LAST:event_iteminventory_searchbuttonActionPerformed

    private void iteminventory_editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iteminventory_editbuttonActionPerformed

        try {
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       
        if (jTextField2.getText().isEmpty() || 
            jTextField3.getText().isEmpty() ||  
            jTextField5.getText().isEmpty() || 
            jTextField6.getText().isEmpty() || 
            jTextField7.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       
        int currentStockLevel;
        try {
            currentStockLevel = Integer.parseInt(jTextField5.getText());
            if (currentStockLevel < 0) {
                JOptionPane.showMessageDialog(this, "Current Stock Level cannot be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Current Stock Level must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       
        int reorderLevel;
        try {
            reorderLevel = Integer.parseInt(jTextField6.getText());
            if (reorderLevel < 0) {
                JOptionPane.showMessageDialog(this, "Reorder Level cannot be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Reorder Level must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       
        double costPerUnit;
        try {
            costPerUnit = Double.parseDouble(jTextField7.getText());
            if (costPerUnit < 0) {
                JOptionPane.showMessageDialog(this, "Cost Per Unit cannot be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cost Per Unit must be a valid decimal number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        double sellingPrice;
        try {
            sellingPrice = Double.parseDouble(jTextField3.getText());
            if (sellingPrice < 0) {
                JOptionPane.showMessageDialog(this, "Selling Price per Unit cannot be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Selling Price per Unit must be a valid decimal number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        String selectedSupplierID = (String) jComboBox1.getSelectedItem();
        if (selectedSupplierID == null || selectedSupplierID.equals("Select Supplier")) {
            JOptionPane.showMessageDialog(this, "Please select a Supplier ID!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
         String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        model.setValueAt(currentDate, row, 7); 

        model.setValueAt(jTextField2.getText(), row, 1);  
        model.setValueAt(selectedSupplierID, row, 2);    
        model.setValueAt(currentStockLevel, row, 3);     
        model.setValueAt(reorderLevel, row, 4);          
        model.setValueAt(costPerUnit, row, 5);           
        model.setValueAt(sellingPrice, row, 6);          

      
        if (currentStockLevel < reorderLevel) {
            jTable1.setValueAt("<html><font color='red'>" + currentStockLevel + "</font></html>", row, 3);
        }

        JOptionPane.showMessageDialog(this, "Row updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    ClearTextField();
          
            

    }//GEN-LAST:event_iteminventory_editbuttonActionPerformed

    private void iteminventory_addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iteminventory_addbuttonActionPerformed
        try {

            String itemID = generatedItemID();

            if (jTextField2.getText().isEmpty() ||
                jTextField3.getText().isEmpty() ||
                jTextField5.getText().isEmpty() ||
                jTextField6.getText().isEmpty() ||
                jTextField7.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String selectedSupplierID = (String) jComboBox1.getSelectedItem();
            if (selectedSupplierID == null || selectedSupplierID.equals("Select Supplier")) {
                JOptionPane.showMessageDialog(this, "Please select a Supplier ID!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int currentStockLevel;
            try {
                currentStockLevel = Integer.parseInt(jTextField5.getText());
                if (currentStockLevel < 0) {
                    JOptionPane.showMessageDialog(this, "Current Stock Level cannot be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Current Stock Level must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int reorderLevel;
            try {
                reorderLevel = Integer.parseInt(jTextField6.getText());
                if (reorderLevel < 0) {
                    JOptionPane.showMessageDialog(this, "Reorder Level cannot be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Reorder Level must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double costPerUnit;
            try {
                costPerUnit = Double.parseDouble(jTextField7.getText());
                if (costPerUnit < 0) {
                    JOptionPane.showMessageDialog(this, "Cost Per Unit cannot be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Cost Per Unit must be a valid decimal number!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double sellingPrice;
            try {
                sellingPrice = Double.parseDouble(jTextField3.getText());
                if (sellingPrice < 0) {
                    JOptionPane.showMessageDialog(this, "Selling Price per Unit cannot be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Selling Price per Unit must be a valid decimal number!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            String itemName = jTextField2.getText();
            String currentStock = String.valueOf(currentStockLevel);
            String reorder = String.valueOf(reorderLevel);
            String costPerUnitStr = String.valueOf(costPerUnit);
            String sellingPriceStr = String.valueOf(sellingPrice);

            String newRow[] = {itemID, itemName, selectedSupplierID, currentStock, reorder, costPerUnitStr, sellingPriceStr,currentDate};
            model.addRow(newRow);

            JOptionPane.showMessageDialog(this, "Item inventory entry successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        ClearTextField();
    }//GEN-LAST:event_iteminventory_addbuttonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        inventory_manager_mainmenu mainmenu = new inventory_manager_mainmenu();
        mainmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Supplier_inventorymanager Supplier = new Supplier_inventorymanager();
        Supplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        item_inventory item = new item_inventory();
        item.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        stocklevel_inventory_manager stock = new stocklevel_inventory_manager();
        stock.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void iteminventory_save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iteminventory_save_buttonActionPerformed
        String filePath = "items.txt";
        File file = new File(filePath);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            bw.write("itemID,item Name,Supplier ID,Current Stock Level,Reorder Level,Cost perunit,Selling Price Unit,Last Updated Date\n");

            // Loop through the table and save each row
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Object cellValue = model.getValueAt(i, j);
                    line.append(cellValue != null ? cellValue.toString().trim() : ""); // Ensure null safety
                    if (j < model.getColumnCount() - 1) {
                        line.append(",");
                    }
                }
                bw.write(line.toString());
                bw.newLine();
            }

            JOptionPane.showMessageDialog(this, "Data saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_iteminventory_save_buttonActionPerformed

    
    private void populateComboBox() {
    String filePath = "supplier.txt"; 
    File file = new File(filePath);

    if (!file.exists()) {
        System.out.println("Supplier file not found.");
        return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line = br.readLine(); 
        jComboBox1.removeAllItems(); 
        jComboBox1.addItem("Select Supplier"); 

        Set<String> uniqueSupplierIDs = new HashSet<>(); 

        while ((line = br.readLine()) != null) {
            String[] rowData = line.split(","); 
            if (rowData.length > 0) {
                String supplierID = rowData[0].trim(); 
                if (!uniqueSupplierIDs.contains(supplierID)) {
                    uniqueSupplierIDs.add(supplierID); 
                    jComboBox1.addItem(supplierID); 
                }
            }
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error loading Supplier IDs: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
      
   
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
       row = jTable1.getSelectedRow();

    // Extract and clean data
    String itemID = cleanHTMLTags(String.valueOf(model.getValueAt(row, 0)));    
    String itemName = cleanHTMLTags(String.valueOf(model.getValueAt(row, 1)));
    String supplierID = cleanHTMLTags(String.valueOf(model.getValueAt(row, 2)));
    String currentStockLevel = cleanHTMLTags(String.valueOf(model.getValueAt(row, 3)));
    String reorderLevel = cleanHTMLTags(String.valueOf(model.getValueAt(row, 4)));
    String costPerUnit = cleanHTMLTags(String.valueOf(model.getValueAt(row, 5)));
    String sellingPriceUnit = cleanHTMLTags(String.valueOf(model.getValueAt(row, 6)));

    
    if (currentStockLevel.startsWith("<html>")) {
    currentStockLevel = currentStockLevel.replaceAll("<[^>]*>", "");
}
if (reorderLevel.startsWith("<html>")) {
    reorderLevel = reorderLevel.replaceAll("<[^>]*>", "");
}
    
    // Set values to the fields
    jTextField2.setText(itemName);
    jTextField3.setText(sellingPriceUnit);
    jComboBox1.setSelectedItem(supplierID); 
    jTextField5.setText(currentStockLevel);
    jTextField6.setText(reorderLevel);
    jTextField7.setText(costPerUnit);
}

// Helper method to strip all HTML tags
private String cleanHTMLTags(String text) {
    return text.replaceAll("<[^>]*>", "").trim();

    }//GEN-LAST:event_jTable1MouseReleased

    
    public void ClearTextField(){
    jTextField2.setText("");
    jTextField3.setText("");
    jComboBox1.setSelectedItem("SupplierID");
    jTextField5.setText("");
    jTextField6.setText("");
    jTextField7.setText("");
    
    }
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
            java.util.logging.Logger.getLogger(item_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(item_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(item_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(item_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new item_inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iteminventory_addbutton;
    private javax.swing.JButton iteminventory_deletebutton;
    private javax.swing.JButton iteminventory_editbutton;
    private javax.swing.JButton iteminventory_save_button;
    private javax.swing.JButton iteminventory_searchbutton;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
