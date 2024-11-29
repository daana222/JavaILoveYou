package financemanagerd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Mitsu
 */
public class PurchaseOrder2 extends javax.swing.JFrame {

    /**
     * Creates new form PurchaseOrder2
     */
    public PurchaseOrder2(String no, String poNumber, String date, String supplierId, String approveReject, String totalAmount) {
        initComponents();
        setSize(890, 500);
        setLocationRelativeTo(null); // Center the frame
        loadTableData(poNumber);
        
        poNumberlbl.setText(poNumber);
        poDatelbl.setText(date);
        supplierIDlbl.setText(supplierId);
        totalAmountPolbl.setText(totalAmount);
        statuslbl.setText(approveReject);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        supplierIDlbl = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Po2table = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        totalAmountPolbl = new javax.swing.JLabel();
        poNumberlbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Dashboardbtn = new javax.swing.JButton();
        PObtn = new javax.swing.JButton();
        Stockbtn = new javax.swing.JButton();
        Paymentbtn = new javax.swing.JButton();
        Supplierbtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        poDatelbl = new javax.swing.JLabel();
        backPObtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        statuslbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(890, 500));

        jLabel10.setText("Supplier ID: ");

        supplierIDlbl.setText("001");

        Po2table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item ID", "Item Name", "Description", "Quantity", "Unit Price", "Total Amount"
            }
        ));
        jScrollPane5.setViewportView(Po2table);

        jButton12.setText("Approve");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Reject");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Purchase Order");

        jLabel16.setText("Total Amount:");

        jLabel12.setText("PO Number:");

        totalAmountPolbl.setText("12000");

        poNumberlbl.setText("001");

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

        jLabel14.setText("PO Date:");

        poDatelbl.setText("29/11/2024");

        backPObtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/financemanagerd/Iconss/return.png"))); // NOI18N
        backPObtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backPObtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Current status:");

        statuslbl.setText("Approved");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12)
                        .addGap(48, 48, 48)
                        .addComponent(jButton13)
                        .addGap(117, 117, 117)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(totalAmountPolbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backPObtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(statuslbl)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(poDatelbl)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(poNumberlbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(supplierIDlbl))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(backPObtn))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(poNumberlbl)
                    .addComponent(jLabel10)
                    .addComponent(supplierIDlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(poDatelbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(statuslbl))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(totalAmountPolbl))
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public PurchaseOrder2() {
        initComponents();
        setLocationRelativeTo(null); // Center the frame
        setSize(890, 500);
        
    }
    
    
    
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        updateApprovalStatus("Approved");
        PurchaseOrder po = new PurchaseOrder();
        po.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton12ActionPerformed

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

    private void backPObtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backPObtnActionPerformed
        // TODO add your handling code here:
        PurchaseOrder po = new PurchaseOrder();
        po.setVisible(true);
        dispose();
    }//GEN-LAST:event_backPObtnActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        updateApprovalStatus("Rejected");
        PurchaseOrder po = new PurchaseOrder();
        po.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton13ActionPerformed
    
    
    private void updateApprovalStatus(String newStatus) {
        String filePath = "C:/Users/Mitsu/OneDrive - Asia Pacific University/Documents/NetBeansProjects/FinanceManagerD/file.txt";

        try {
            // Read all lines from the file
            java.util.List<String> lines = new java.util.ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }

            // Find and update the matching row
            for (int i = 0; i < lines.size(); i++) {
                String[] columns = lines.get(i).split(",");
                if (columns.length >= 5 && columns[1].trim().equals(poNumberlbl.getText())) { // Match on P.O Number
                    columns[5] = newStatus; // Update the Approve/Reject column
                    lines.set(i, String.join(",", columns)); // Replace the updated line
                    break;
                }
            }

            // Write back the updated data to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            // Inform the user of success
            javax.swing.JOptionPane.showMessageDialog(this, "Status updated to: " + newStatus);
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error updating file: " + e.getMessage());
        }
    }
    
    
    
    
    private void loadTableData(String poNumber) {
        String itemsFilePath = "C:/Users/Mitsu/OneDrive - Asia Pacific University/Documents/NetBeansProjects/FinanceManagerD/items.txt";
        String filePath = "C:/Users/Mitsu/OneDrive - Asia Pacific University/Documents/NetBeansProjects/FinanceManagerD/file.txt";
        DefaultTableModel model = (DefaultTableModel) Po2table.getModel();
        model.setRowCount(0); // Clear any existing rows

        double totalAmountSum = 0.0; // To calculate the sum of all Total Amounts
        int totalItemsOnPO = 0; // To calculate the sum of "Item on PO"

        try (BufferedReader itemsReader = new BufferedReader(new FileReader(itemsFilePath))) {
            String line;

            while ((line = itemsReader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[8].trim().equals(poNumber)) { // Check if PO ID matches
                    String itemId = columns[0].trim();
                    String itemName = columns[1].trim();
                    String description = columns[2].trim();
                    int itemOnPO = Integer.parseInt(columns[9].trim());
                    double unitPrice = Double.parseDouble(columns[7].trim());

                    // Calculate totals
                    double totalAmount = itemOnPO * unitPrice;
                    totalAmountSum += totalAmount;
                    totalItemsOnPO += itemOnPO;

                    // Add row to the table
                    model.addRow(new Object[] { itemId, itemName, description, itemOnPO, unitPrice, totalAmount });
                }
            }

            // Update UI labels and save updates to the file
            totalAmountPolbl.setText(String.format("%.2f", totalAmountSum));
            updateQuantityInFile(poNumber, totalItemsOnPO, filePath);
            updateTotalAmountInFile(poNumber, totalAmountSum, filePath);

        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }
    
    private void updateQuantityInFile(String poNumber, int quantity, String filePath) {
        updateFile(poNumber, 3, String.valueOf(quantity), filePath);
    }

    private void updateTotalAmountInFile(String poNumber, double totalAmount, String filePath) {
        updateFile(poNumber, 6, String.format("%.2f", totalAmount), filePath);
    }


    private void updateFile(String poNumber, int columnIndex, String newValue, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            java.util.List<String> lines = new java.util.ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[1].trim().equals(poNumber)) { // Check if PO ID matches
                    columns[columnIndex] = newValue; // Update the specified column
                    line = String.join(",", columns);
                }
                lines.add(line); // Add the updated (or unchanged) line to the list
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating file: " + e.getMessage());
        }
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
            java.util.logging.Logger.getLogger(PurchaseOrder2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseOrder2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dashboardbtn;
    private javax.swing.JButton PObtn;
    private javax.swing.JButton Paymentbtn;
    private javax.swing.JTable Po2table;
    private javax.swing.JButton Stockbtn;
    private javax.swing.JButton Supplierbtn;
    private javax.swing.JButton backPObtn;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel poDatelbl;
    private javax.swing.JLabel poNumberlbl;
    private javax.swing.JLabel statuslbl;
    private javax.swing.JLabel supplierIDlbl;
    private javax.swing.JLabel totalAmountPolbl;
    // End of variables declaration//GEN-END:variables
}
