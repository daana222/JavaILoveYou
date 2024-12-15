/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package financemanagerd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mitsu
 */
public class SupplierPaymentStatus extends javax.swing.JFrame {

    /**
     * Creates new form SupplierPaymentStatus
     */
    public SupplierPaymentStatus() {
        initComponents();
        setSize(890, 500);
        setLocationRelativeTo(null); // Center the frame
        populateSupplierComboBox(); // Populate combo box first
        loadSupplierPaymentStatus(); // Load all supplier payment data
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        supplierPaymentTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Dashboardbtn = new javax.swing.JButton();
        PObtn = new javax.swing.JButton();
        Stockbtn = new javax.swing.JButton();
        Paymentbtn = new javax.swing.JButton();
        Supplierbtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        viewBtn = new javax.swing.JButton();
        supplierComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Supplier Payment Status");

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        supplierPaymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Status", "Total Amount Paid", "Total Due"
            }
        ));
        jScrollPane3.setViewportView(supplierPaymentTable);

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

        viewBtn.setText("View");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        supplierComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        supplierComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Supplier ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(viewBtn)
                                    .addGap(41, 41, 41))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(53, 53, 53)))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void supplierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboBoxActionPerformed
        Object selectedItem = supplierComboBox.getSelectedItem();
        if (selectedItem == null) {
            return; // Exit if no item is selected
        }

        String selectedSupplierId = selectedItem.toString();
        filterTableBySupplier(selectedSupplierId); // Filter based on selected supplier ID
    }//GEN-LAST:event_supplierComboBoxActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        int selectedRow = supplierPaymentTable.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a row to view.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) supplierPaymentTable.getModel();
        String supplierId = model.getValueAt(selectedRow, 0).toString(); // Supplier ID
        double balancePayment = Double.parseDouble(model.getValueAt(selectedRow, 3).toString()); // Total Due

        // Open the Supplier_2 form and pass the data
        Supplier_2 supplier2Form = new Supplier_2(supplierId, balancePayment);
        supplier2Form.setVisible(true);
        dispose(); // Close the current form
    }//GEN-LAST:event_viewBtnActionPerformed

    
    private void loadSupplierPaymentStatus() {
    supplierComboBox.setSelectedItem("All"); // Set the combo box to "All"
    filterTableBySupplier("All"); // Filter the table for all suppliers
}

    
    private void populateSupplierComboBox() {
        String filePath = "C:\\Users\\Mitsu\\OneDrive - Asia Pacific University\\Documents\\NetBeansProjects\\FinanceManagerD\\Payment.txt";

        Set<String> supplierIds = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header row
                    continue;
                }
                String[] columns = line.split(",");
                supplierIds.add(columns[5].trim()); // Supplier ID
            }
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error reading Payment.txt: " + e.getMessage());
        }

        // Temporarily remove action listeners
        for (java.awt.event.ActionListener listener : supplierComboBox.getActionListeners()) {
            supplierComboBox.removeActionListener(listener);
        }

        supplierComboBox.removeAllItems();
        supplierComboBox.addItem("All"); // Default option to show all suppliers
        for (String supplierId : supplierIds) {
            supplierComboBox.addItem(supplierId);
        }

        // Re-add action listeners
        supplierComboBox.addActionListener(this::supplierComboBoxActionPerformed);
    }




    private void filterTableBySupplier(String selectedSupplierId) {
        if (selectedSupplierId == null || selectedSupplierId.isEmpty()) {
            selectedSupplierId = "All"; // Default to "All" if no supplier is selected
        }

        String filePath = "C:\\Users\\Mitsu\\OneDrive - Asia Pacific University\\Documents\\NetBeansProjects\\FinanceManagerD\\Payment.txt";

        DefaultTableModel model = (DefaultTableModel) supplierPaymentTable.getModel();
        model.setRowCount(0); // Clear existing rows

        Map<String, Double> totalPaid = new HashMap<>();
        Map<String, Double> totalDue = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header row
                    continue;
                }

                String[] columns = line.split(",");
                String supplierId = columns[5].trim();
                String status = columns[2].trim(); // Payment Status (Paid/Late)
                double amount = Double.parseDouble(columns[7].trim()); // Amount

                if (selectedSupplierId.equals("All") || supplierId.equals(selectedSupplierId)) {
                    totalDue.put(supplierId, totalDue.getOrDefault(supplierId, 0.0) + amount);

                    // Count "Paid" and "Late" payments as paid
                    if (status.equalsIgnoreCase("Paid") || status.equalsIgnoreCase("Late")) {
                        totalPaid.put(supplierId, totalPaid.getOrDefault(supplierId, 0.0) + amount);
                    }
                }
            }

            for (String supplierId : totalDue.keySet()) {
                double paid = totalPaid.getOrDefault(supplierId, 0.0);
                double due = totalDue.getOrDefault(supplierId, 0.0);
                String status;

                if (paid < due) {
                    status = "Pending";
                } else if (paid == due && totalPaid.containsKey(supplierId)) {
                    status = "Paid";
                } else {
                    status = "Late";
                }

                model.addRow(new Object[]{supplierId, status, paid, due});
            }
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error filtering Payment.txt: " + e.getMessage());
        }
    }





    
    




    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(SupplierPaymentStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierPaymentStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierPaymentStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierPaymentStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierPaymentStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dashboardbtn;
    private javax.swing.JButton PObtn;
    private javax.swing.JButton Paymentbtn;
    private javax.swing.JButton Stockbtn;
    private javax.swing.JButton Supplierbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> supplierComboBox;
    private javax.swing.JTable supplierPaymentTable;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}
