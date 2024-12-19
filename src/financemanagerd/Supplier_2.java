
package financemanagerd;

import ThemeManager.ThemeManager;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;


public class Supplier_2 extends javax.swing.JFrame {
private String ID;
    
    public Supplier_2(String supplierId, double balancePayment) {
        initComponents();
        jPanel1.setName("sidePanel");
        ThemeManager.applyTheme(this);
        ThemeManager.updateTableTheme(supplierPayment2table);
        setSize(890, 500);
        setLocationRelativeTo(null); // Center the frame

        supplierIdLabel.setText(supplierId); // Set Supplier ID

        // Load purchase orders related to the supplier
        double calculatedBalance = loadPurchaseOrders(supplierId);
        balancePaymentLabel.setText(String.valueOf(calculatedBalance)); // Display the calculated balance

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Dashboardbtn = new javax.swing.JButton();
        PObtn = new javax.swing.JButton();
        Stockbtn = new javax.swing.JButton();
        Paymentbtn = new javax.swing.JButton();
        Supplierbtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        balancePaymentLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierPayment2table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        supplierIdLabel = new javax.swing.JLabel();
        supplierPaymentbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(890, 500));

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

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Supplier Payment Status");

        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel2.setText("Balance Payment:");

        balancePaymentLabel.setText("4000");

        supplierPayment2table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PO ID", "Amount payable", "Total amount paid", "Due date"
            }
        ));
        jScrollPane1.setViewportView(supplierPayment2table);

        jLabel4.setText("Supplier ID:");

        supplierIdLabel.setText("001");

        supplierPaymentbtn.setText("Payment");
        supplierPaymentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierPaymentbtnActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/financemanagerd/Iconss/return.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(supplierPaymentbtn)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(balancePaymentLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(supplierIdLabel))
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(supplierIdLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(balancePaymentLabel)
                    .addComponent(jButton8)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supplierPaymentbtn))
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

    private void supplierPaymentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierPaymentbtnActionPerformed
        int selectedRow = supplierPayment2table.getSelectedRow();

        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a row.");
            return;
        }

        String poId = supplierPayment2table.getValueAt(selectedRow, 0).toString(); // PO ID column
        Payment paymentForm = new Payment(poId); // Pass the PO ID
        paymentForm.setVisible(true);
        this.dispose(); // Optionally close the current form
    }//GEN-LAST:event_supplierPaymentbtnActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        searchSupplierTable();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SupplierPaymentStatus supplier = new SupplierPaymentStatus();
        supplier.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    private double loadPurchaseOrders(String supplierId) {
        String filePath = "Payment.txt";

        DefaultTableModel model = (DefaultTableModel) supplierPayment2table.getModel();
        model.setRowCount(0); // Clear existing rows in the table

        double totalPaidOverall = 0.0; // Track total paid for the supplier
        double totalDueOverall = 0.0; // Track total amount payable for the supplier

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header row
                    continue;
                }

                String[] columns = line.split(",");

                String poSupplierId = columns[5].trim(); // Supplier ID
                String poId = columns[1].trim(); // PO ID
                String status = columns[2].trim(); // Payment Status
                String dueDate = columns[4].trim(); // Due Date
                double totalAmount = Double.parseDouble(columns[7].trim()); // Total Amount Payable

                // Treat "Paid" and "Late" statuses as amounts that have been paid
                double amountPaid = (status.equalsIgnoreCase("Paid") || status.equalsIgnoreCase("Late")) ? totalAmount : 0.0;

                if (poSupplierId.equals(supplierId)) {
                    totalDueOverall += totalAmount; // Add to total due
                    totalPaidOverall += amountPaid; // Add to total paid if "Paid" or "Late"

                    // Add row to the table
                    model.addRow(new Object[]{poId, totalAmount, amountPaid, dueDate});
                }
            }
        } catch (IOException | NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error reading Payment.txt: " + e.getMessage());
        }

        return totalDueOverall - totalPaidOverall; // Return the calculated balance
    }




    
    
    private void searchSupplierTable() {
        String searchText = jTextField3.getText().trim().toLowerCase(); // Get the search text

        if (searchText.isEmpty()) {
            loadPurchaseOrders(supplierIdLabel.getText()); // Reload all rows
            return;
        }

        DefaultTableModel model = (DefaultTableModel) supplierPayment2table.getModel();
        DefaultTableModel filteredModel = new DefaultTableModel(new String[]{"PO ID", "Amount payable", "Total amount paid", "Due date"}, 0);

        for (int i = 0; i < model.getRowCount(); i++) {
            boolean match = false;
            for (int j = 0; j < model.getColumnCount(); j++) {
                Object value = model.getValueAt(i, j);
                if (value != null && value.toString().toLowerCase().contains(searchText)) {
                    match = true;
                    break;
                }
            }
            if (match) {
                Object[] row = new Object[model.getColumnCount()];
                for (int j = 0; j < model.getColumnCount(); j++) {
                    row[j] = model.getValueAt(i, j);
                }
                filteredModel.addRow(row);
            }
        }

        if (filteredModel.getRowCount() == 0) {
            // Show message if no matching data is found
            javax.swing.JOptionPane.showMessageDialog(this, "No matching data found!", "Search Results", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadPurchaseOrders(supplierIdLabel.getText()); // Reload original data if no match is found
        } else {
            supplierPayment2table.setModel(filteredModel); // Set the filtered data to the table
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
            java.util.logging.Logger.getLogger(Supplier_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier_2("SupplierID", 4000).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dashboardbtn;
    private javax.swing.JButton PObtn;
    private javax.swing.JButton Paymentbtn;
    private javax.swing.JButton Stockbtn;
    private javax.swing.JButton Supplierbtn;
    private javax.swing.JLabel balancePaymentLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel supplierIdLabel;
    private javax.swing.JTable supplierPayment2table;
    private javax.swing.JButton supplierPaymentbtn;
    // End of variables declaration//GEN-END:variables
}
