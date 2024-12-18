/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import ThemeManager.ThemeManager;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author HP
 */
public class Generate_Reports extends javax.swing.JFrame {

    /**
     * Creates new form Generate_Reports
     */
    public Generate_Reports() {
        initComponents();
        jPanel1.setName("sidePanel");
        ThemeManager.applyTheme(this);
        
        // Dynamically create chart panels
    salesChartPanel = new javax.swing.JPanel();
    userChartPanel = new javax.swing.JPanel();
    paymentChartPanel = new javax.swing.JPanel();
    poChartPanel = new javax.swing.JPanel();
      
    
    addPanelsToLayout();

    displaySalesChart();
    displayUserChart();
    displayPaymentChart();
    displayPOChart();
    
    
    
    }
    
private javax.swing.JPanel salesChartPanel;
private javax.swing.JPanel userChartPanel;
private javax.swing.JPanel paymentChartPanel;
private javax.swing.JPanel poChartPanel;


private void addPanelsToLayout() {
    javax.swing.GroupLayout layout = (javax.swing.GroupLayout) getContentPane().getLayout();

    layout.setHorizontalGroup(
        layout.createSequentialGroup()
            .addGap(220) // Space for jPanel1
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(salesChartPanel, 350, 350, 350)
                .addComponent(paymentChartPanel, 350, 350, 350))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(userChartPanel, 350, 350, 350)
                .addComponent(poChartPanel, 350, 350, 350))
    );

    layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addGap(80) // Space for title
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(salesChartPanel, 300, 300, 300)
                .addComponent(userChartPanel, 300, 300, 300))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(paymentChartPanel, 300, 300, 300)
                .addComponent(poChartPanel, 300, 300, 300))
    );
}

    private void displaySalesChart() {
    DefaultPieDataset dataset = new DefaultPieDataset();
    try (BufferedReader br = new BufferedReader(new FileReader("sales.txt"))) {
        String line;
        boolean isFirstLine = true;
        while ((line = br.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            String[] data = line.split(",");
            if (data.length >= 6) {
                String itemName = data[2];
                double totalSales = Double.parseDouble(data[5].replace("RM", ""));
                dataset.setValue(itemName, totalSales);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    JFreeChart chart = ChartFactory.createPieChart("Sales Distribution", dataset, true, true, false);
    ChartPanel panel = new ChartPanel(chart);
    panel.setPreferredSize(new java.awt.Dimension(350, 300));
    salesChartPanel.removeAll();
    salesChartPanel.add(panel);
    salesChartPanel.revalidate();
    salesChartPanel.repaint();
}
    
    private void displayUserChart() {
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    try (BufferedReader br = new BufferedReader(new FileReader("user.txt"))) {
        String line;
        boolean isFirstLine = true;
        while ((line = br.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            String[] data = line.split(",");
            if (data.length >= 7) {
                String role = data[6]; // Job Role
                dataset.addValue(1, "Count", role);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    JFreeChart chart = ChartFactory.createBarChart("User Roles Count", "Roles", "Count", dataset);
    ChartPanel panel = new ChartPanel(chart);
    panel.setPreferredSize(new java.awt.Dimension(350, 300));
    userChartPanel.removeAll();
    userChartPanel.add(panel);
    userChartPanel.revalidate();
    userChartPanel.repaint();
}

private void displayPaymentChart() {
    DefaultPieDataset dataset = new DefaultPieDataset();
    try (BufferedReader br = new BufferedReader(new FileReader("payment.txt"))) {
        String line;
        boolean isFirstLine = true;
        while ((line = br.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            String[] data = line.split(",");
            if (data.length >= 4) {
                String status = data[2]; // Payment Status
                dataset.setValue(status, dataset.getValue(status) == null ? 1 : dataset.getValue(status).doubleValue() + 1);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    JFreeChart chart = ChartFactory.createPieChart("Payment Status", dataset, true, true, false);
    ChartPanel panel = new ChartPanel(chart);
    panel.setPreferredSize(new java.awt.Dimension(350, 300));
    paymentChartPanel.removeAll();
    paymentChartPanel.add(panel);
    paymentChartPanel.revalidate();
    paymentChartPanel.repaint();
}

private void displayPOChart() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    try (BufferedReader br = new BufferedReader(new FileReader("PO.txt"))) {
        String line;
        boolean isFirstLine = true;
        while ((line = br.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            String[] data = line.split(",");
            if (data.length >= 11) {
                String status = data[10];
                dataset.addValue(1, "Count", status);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    JFreeChart chart = ChartFactory.createBarChart("PO Status Count", "Status", "Count", dataset);
    ChartPanel panel = new ChartPanel(chart);
    panel.setPreferredSize(new java.awt.Dimension(350, 300));
    poChartPanel.removeAll();
    poChartPanel.add(panel);
    poChartPanel.revalidate();
    poChartPanel.repaint();
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("    REPORTS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(890, 500));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("REGISTER USER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("VIEW USER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setText("LOG OUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VIEW ITEM ", "VIEW PAYMENT", "VIEW SUPPLIERS", "VIEW SALES REPORTS" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton11.setText("GENERATE REPORTS");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton10.setText("MAIN MENU");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jComboBox1, 0, 0, Short.MAX_VALUE))
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(470, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //
        Register registerFrame = new Register();

        registerFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        View_user viewUserFrame = new View_user();

        viewUserFrame.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Login loginPage = new Login();
        loginPage.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
              String selectedItem = ((String) jComboBox1.getSelectedItem()).trim();
        
        

    if ("VIEW ITEM".equalsIgnoreCase(selectedItem)) {
        //if (!(this instanceof View_Items)) { // Avoid reopening the same frame
            View_Items viewItemFrame = new View_Items();
            viewItemFrame.setVisible(true);
            this.dispose();
        
    } 
    else if ("VIEW PAYMENT".equalsIgnoreCase(selectedItem)) {
        View_Payment viewPaymentFrame = new View_Payment();
        viewPaymentFrame.setVisible(true);
        this.dispose();
    } 
    else if ("VIEW SUPPLIERS".equalsIgnoreCase(selectedItem)) {
        View_Suppliers viewSuppliersFrame = new View_Suppliers();
        viewSuppliersFrame.setVisible(true);
        this.dispose();
    } 
    else if ("VIEW SALES REPORTS".equalsIgnoreCase(selectedItem)) {
        View_sales_report viewSalesReportFrame = new View_sales_report();
        viewSalesReportFrame.setVisible(true);
        this.dispose();
    } 
    else {
        JOptionPane.showMessageDialog(this, "Invalid selection!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Generate_Reports generateReportsFrame = new Generate_Reports();

        generateReportsFrame.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Main_Menu mainMenuFrame = new Main_Menu();

        mainMenuFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
          java.awt.EventQueue.invokeLater(() -> new Generate_Reports().setVisible(true));
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
            java.util.logging.Logger.getLogger(Generate_Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Generate_Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Generate_Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Generate_Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Generate_Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
