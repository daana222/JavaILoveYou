/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Purchase_Manager;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Jiannaa
 */
public class ViewPurchaseOrder extends javax.swing.JFrame {
private DefaultTableModel model= new DefaultTableModel();//to create model object to be placed in jtable
    private String[]columnName={"PO ID", "PR ID", "Item ID", "Item Name", "Quantity Required",
            "Cost Per Unit", "Total Amount", "Requisition Date", "Supplier ID", "OrderDate", "Status"};
    private int row=-1;
    private static final Logger LOGGER = Logger.getLogger(ViewRequisition.class.getName()); 
    /**
     * Creates new form ViewPurchaseOrder
     */
    public ViewPurchaseOrder() {
        initComponents();
        model.setColumnIdentifiers(columnName);
         jTable1.setModel(model);
        populateComboBox();
        loadDataFromFile();
    }
    
    
    

private void showStatusChart() {
    // Count statuses
    int approvedCount = 0, rejectedCount = 0, pendingCount = 0;
    for (int i = 0; i < model.getRowCount(); i++) {
        String status = ((String) model.getValueAt(i, 10)).trim(); // Index 7: Status
        if ("Approved".equalsIgnoreCase(status)) approvedCount++;
        else if ("Rejected".equalsIgnoreCase(status)) rejectedCount++;
        else if ("Pending".equalsIgnoreCase(status)) pendingCount++;
    }

    // Debug to confirm counts
    System.out.println("Approved: " + approvedCount + ", Rejected: " + rejectedCount + ", Pending: " + pendingCount);

    // Create dataset
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.addValue(approvedCount, "Approved", "Approved");
    dataset.addValue(rejectedCount, "Rejected", "Rejected");
    dataset.addValue(pendingCount, "Pending", "Pending");

    // Create chart
    JFreeChart chart = ChartFactory.createBarChart(
            "Purchase Order Status Distribution", // Chart Title
            "Status",                             // X-Axis Label
            "Count",                              // Y-Axis Label
            dataset                               // Dataset
    );

    // Customize bar colors
    CategoryPlot plot = chart.getCategoryPlot();
    BarRenderer renderer = (BarRenderer) plot.getRenderer();

    // Set colors for each series
    renderer.setSeriesPaint(0, new Color(144, 238, 144)); // Green for Approved
    renderer.setSeriesPaint(1, new Color(255, 102, 102)); // Red for Rejected
    renderer.setSeriesPaint(2, new Color(255, 255, 102)); // Yellow for Pending

    // Display the chart
    JPanel chartPanel = new ChartPanel(chart);
    JOptionPane.showMessageDialog(this, chartPanel, "Status Distribution", JOptionPane.PLAIN_MESSAGE);
}

    
    // load data from the PO file 
private void loadDataFromFile() {
   String filePath = "C:\\Users\\Jiannaa\\Desktop\\PO.txt";
   File file = new File(filePath);
   if (!file.exists()) {
       System.out.println("Data file not found. Starting with an empty table.");
       return; // Exit if the file does not exist
   }
   try {
       FileReader fr = new FileReader(file);
       BufferedReader br = new BufferedReader(fr);
       // Clear existing data from the model
       model.setRowCount(0);
       // Skip the column headers line
       String line = br.readLine();
       // Read and add rows to the table
       while ((line = br.readLine()) != null) {
           String[] rowData = line.split(",");
           model.addRow(rowData);
       }
       br.close();
       fr.close();
       System.out.println("Data loaded successfully from: " + filePath);
   } catch (Exception ex) {
       LOGGER.log(Level.SEVERE, "Error loading data from file", ex);
       JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
   }
    }

private void populateComboBox() {
    String filePath = "C:\\Users\\Jiannaa\\Desktop\\PO.txt"; // Path to your file
    File file = new File(filePath);
    if (!file.exists()) {
        System.out.println("Data file not found.");
        return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line = br.readLine(); // Skip the header line
        jComboBox1.removeAllItems(); // Clear the combo box
        jComboBox1.addItem("POID"); // Add a default option to show all items
        while ((line = br.readLine()) != null) {
            String[] rowData = line.split(",");
            if (rowData.length > 0) {
                String POID = rowData[0]; // Assuming Item ID is in the first column
                jComboBox1.addItem(POID); // Add Item ID to combo box
            }
        }
    } catch (Exception ex) {
        LOGGER.log(Level.SEVERE, "Error loading Item IDs", ex);
        JOptionPane.showMessageDialog(this, "Error loading Item IDs: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        label2 = new java.awt.Label();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        label1 = new java.awt.Label();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(model);
        jTable1.setPreferredSize(new java.awt.Dimension(890, 500));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(65, 65, 65))
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
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        label1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N
        label1.setText("List Of Purchase Orders");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PO ID" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Create");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 538, Short.MAX_VALUE)
                                        .addComponent(jButton4)))
                                .addGap(76, 76, 76))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(115, 115, 115))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    
    // search button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        String selectedPOID = (String) jComboBox1.getSelectedItem(); // Get selected Item ID

    // If "All" is selected, reload all data
    if ("POID".equals(selectedPOID)) {
        loadDataFromFile(); // Reload all data
        return;
    }

    // Clear the table
    model.setRowCount(0);

    String filePath = "C:\\Users\\Jiannaa\\Desktop\\PO.txt"; // Path to your file
    File file = new File(filePath);
    if (!file.exists()) {
        System.out.println("Data file not found.");
        return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line = br.readLine(); // Skip the header line
        while ((line = br.readLine()) != null) {
            String[] rowData = line.split(",");
            if (rowData.length > 0 && rowData[0].equals(selectedPOID)) {
                model.addRow(rowData); // Add row if Item ID matches
            }
        }
    } catch (Exception ex) {
        LOGGER.log(Level.SEVERE, "Error filtering data", ex);
        JOptionPane.showMessageDialog(this, "Error filtering data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
         row= jTable1.getSelectedRow();
    String POID= String.valueOf(model.getValueAt(row,0));
    String PRID= String.valueOf(model.getValueAt(row,1));
    String ItemID= String.valueOf(model.getValueAt(row,2));
    String Quantity= String.valueOf(model.getValueAt(row,3));
    String Unitperprice= String.valueOf(model.getValueAt(row,4));
    String TotalAmount= String.valueOf(model.getValueAt(row,5));
    String Status= String.valueOf(model.getValueAt(row,6));
    String Orderdate= String.valueOf (model.getValueAt(row,7));

   
    }//GEN-LAST:event_jTable1MouseReleased

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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        showStatusChart();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPurchaseOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
