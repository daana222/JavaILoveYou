
package financemanagerd;

import ThemeManager.ThemeManager;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PurchaseOrder extends javax.swing.JFrame {
    private int row = -1;
    /**
     * Creates new form PurchaseOrder
     */
    public PurchaseOrder() {
        initComponents();
        ThemeManager.applyTheme(this);
        setSize(890, 500);
        setLocationRelativeTo(null); // Center the frame
        
        int[] selectedColumns = {0, 9, 8, 10, 6};
        //int[] selectedColumns = {0, 8, 4, 7, 6};
        
        String filePath = "PO.txt";
        loadDataFromFile(filePath, selectedColumns);
        storeOriginalTableData();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        POmaintable = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Dashboardbtn = new javax.swing.JButton();
        PObtn = new javax.swing.JButton();
        Stockbtn = new javax.swing.JButton();
        Paymentbtn = new javax.swing.JButton();
        Supplierbtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Purchase Order");

        jButton6.setText("Search P.O Number");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        POmaintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "P.O ID", "Date", "Supplier ID", "Approved/Rejected", "Total Amount"
            }
        ));
        POmaintable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                POmaintableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(POmaintable);

        jButton11.setText("View");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        Dashboardbtn.setBackground(new java.awt.Color(255, 255, 204));
        Dashboardbtn.setText("Dashboard");
        Dashboardbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardbtnActionPerformed(evt);
            }
        });

        PObtn.setBackground(new java.awt.Color(204, 204, 255));
        PObtn.setText("Purchase Order");
        PObtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PObtnActionPerformed(evt);
            }
        });

        Stockbtn.setBackground(new java.awt.Color(204, 204, 255));
        Stockbtn.setText("Stock Status");
        Stockbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockbtnActionPerformed(evt);
            }
        });

        Paymentbtn.setBackground(new java.awt.Color(204, 204, 255));
        Paymentbtn.setText("Payment");
        Paymentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentbtnActionPerformed(evt);
            }
        });

        Supplierbtn.setBackground(new java.awt.Color(204, 204, 255));
        Supplierbtn.setText("Supplier Payment Status");
        Supplierbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierbtnActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Finance Manager");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/financemanagerd/Iconss/affiliate-marketing_3052007.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PObtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Supplierbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(Stockbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Paymentbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Dashboardbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(94, 94, 94)
                .addComponent(PObtn)
                .addGap(18, 18, 18)
                .addComponent(Stockbtn)
                .addGap(18, 18, 18)
                .addComponent(Supplierbtn)
                .addGap(18, 18, 18)
                .addComponent(Paymentbtn)
                .addGap(46, 46, 46)
                .addComponent(Dashboardbtn)
                .addGap(28, 28, 28))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Approved", "Rejected", "Pending", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(551, 551, 551))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void loadDataFromFile(String filePath, int[] selectedColumns) {
    DefaultTableModel model = (DefaultTableModel) POmaintable.getModel();
    model.setRowCount(0);  // Clear the existing rows

    Map<String, PurchaseOrderClass> poDataMap = new HashMap<>();  // Map to store P.O ID and POMaintenance object

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        br.readLine();  // Skip the first line (header or unnecessary row)

        while ((line = br.readLine()) != null) {
            String[] allColumns = line.split(",");
            if (allColumns.length >= selectedColumns.length) {
                String poID = allColumns[selectedColumns[0]].trim();  // P.O ID
                String date = allColumns[selectedColumns[1]].trim();  // Date
                String supplierId = allColumns[selectedColumns[2]].trim();  // Supplier ID
                String approveReject = allColumns[selectedColumns[3]].trim();  // Approved/Rejected
                double totalAmount = Double.parseDouble(allColumns[selectedColumns[4]].trim());  // Total Amount

                // If P.O ID already exists, add the new amount to the existing total
                if (poDataMap.containsKey(poID)) {
                    PurchaseOrderClass existingPO = poDataMap.get(poID);
                    existingPO.addToTotalAmount(totalAmount);  // Sum the total amount
                } else {
                    // Add new P.O ID entry
                    PurchaseOrderClass newPO = new PurchaseOrderClass(poID, date, supplierId, approveReject, totalAmount);
                    poDataMap.put(poID, newPO);
                }
            }
        }
    } catch (IOException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error reading the file: " + e.getMessage());
        return;
    }

    // Add the combined rows to the table
    for (PurchaseOrderClass po : poDataMap.values()) {
        model.addRow(new Object[]{po.getPoID(), po.getDate(), po.getSupplierID(), po.getApproveReject(), po.getTotalAmount()});
    }
}

    
    private void DashboardbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardbtnActionPerformed
        // TODO add your handling code here:
        FManager dashboard = new FManager();
        dashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_DashboardbtnActionPerformed

    private void PObtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PObtnActionPerformed
        // TODO add your handling code here:
        PurchaseOrder po = new PurchaseOrder();
        po.setVisible(true);
        dispose();

    }//GEN-LAST:event_PObtnActionPerformed

    private void StockbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockbtnActionPerformed
        // TODO add your handling code here:
        StockStatus stock = new StockStatus();
        stock.setVisible(true);
        dispose();
    }//GEN-LAST:event_StockbtnActionPerformed

    private void PaymentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentbtnActionPerformed
        // TODO add your handling code here:
        Payment payment = new Payment();
        payment.setVisible(true);
        dispose();
    }//GEN-LAST:event_PaymentbtnActionPerformed

    private void SupplierbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierbtnActionPerformed
        // TODO add your handling code here:
        SupplierPaymentStatus supplier = new SupplierPaymentStatus();
        supplier.setVisible(true);
        dispose();
    }//GEN-LAST:event_SupplierbtnActionPerformed

    private void POmaintableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POmaintableMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_POmaintableMouseReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int selectedRow = POmaintable.getSelectedRow();

        if (selectedRow != -1) { // Ensure a row is selected
            DefaultTableModel model = (DefaultTableModel) POmaintable.getModel();

            // Get selected row data
            String poNumber = model.getValueAt(selectedRow, 0).toString();
            String date = model.getValueAt(selectedRow, 1).toString();
            String supplierId = model.getValueAt(selectedRow, 2).toString();
            String approveReject = model.getValueAt(selectedRow, 3).toString();
            String totalAmount = model.getValueAt(selectedRow, 4).toString();

            // Pass data to the second form
            PurchaseOrder2 detailsForm = new PurchaseOrder2(poNumber, date, supplierId, approveReject,totalAmount);
            detailsForm.setVisible(true);
            this.dispose(); // Close the first form
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a row to make approval.");
        }
    }//GEN-LAST:event_jButton11ActionPerformed
    
    
    private DefaultTableModel originalModel; // To store the original unfiltered data

// Call this after loading the data into the table
    private void storeOriginalTableData() {
        originalModel = (DefaultTableModel) POmaintable.getModel(); // Keep a copy of the original model
    }

    private void filterTableByApproval() {
        String selectedFilter = jComboBox1.getSelectedItem().toString(); // Get selected item

        // Create a new model for the filtered data
        DefaultTableModel filteredModel = new DefaultTableModel(new Object[]{ "P.O Number", "Date", "Supplier ID", "Approved/Rejected", "Total Amount"}, 0);

        // Loop through the original table data
        for (int i = 0; i < originalModel.getRowCount(); i++) {
            String status = originalModel.getValueAt(i, 3).toString(); // Get Approve/Reject column value

            if (selectedFilter.equals("All") || status.equalsIgnoreCase(selectedFilter)) {
                // Add matching rows to the filtered model
                Object[] rowData = {
                    originalModel.getValueAt(i, 0), // "P.O Number"
                    originalModel.getValueAt(i, 1), // "Date"
                    originalModel.getValueAt(i, 2), // "Supplier ID"
                    originalModel.getValueAt(i, 3),  // "Approve/Reject"
                    originalModel.getValueAt(i, 4)  // "Approve/Reject"    
                };
                filteredModel.addRow(rowData);
            }
        }

        // Set the filtered model to the table
        POmaintable.setModel(filteredModel);
    }


    
    
    
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String searchText = jTextField1.getText().trim(); // Get text from search field
        DefaultTableModel model = (DefaultTableModel) POmaintable.getModel(); // Get table model

        if (searchText.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter a P.O Number to search.");
            return;
        }

        // Create a new model to hold search results
        DefaultTableModel searchModel = new DefaultTableModel(new Object[]{ "P.O Number", "Date", "Supplier ID", "Approved/Rejected", "Total Amount"}, 0);

        // Iterate through the table to find matching rows
        for (int i = 0; i < model.getRowCount(); i++) {
            String poNumber = model.getValueAt(i, 0).toString(); // Get P.O Number column value

            if (poNumber.equalsIgnoreCase(searchText)) { // Check if it matches the search text
                Object[] rowData = {
                    model.getValueAt(i, 0), // "P.O Number"
                    model.getValueAt(i, 1), // "Date"
                    model.getValueAt(i, 2), // "Supplier ID"
                    model.getValueAt(i, 3),  // "Approve/Reject"
                    model.getValueAt(i, 4)  // "Total amount"
                };
                searchModel.addRow(rowData); // Add matching row to search model
                clearTextField();
            }
        }

        if (searchModel.getRowCount() > 0) {
            POmaintable.setModel(searchModel); // Update table with search results
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No matching P.O Number found.");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        filterTableByApproval();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    
    public void clearTextField(){
        jTextField1.setText("");
        
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
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dashboardbtn;
    private javax.swing.JButton PObtn;
    private javax.swing.JTable POmaintable;
    private javax.swing.JButton Paymentbtn;
    private javax.swing.JButton Stockbtn;
    private javax.swing.JButton Supplierbtn;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
