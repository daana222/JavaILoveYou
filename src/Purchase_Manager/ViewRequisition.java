package Purchase_Manager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;


/**
 *
 * @author Jiannaa
 */
public class ViewRequisition extends javax.swing.JFrame {
    private DefaultTableModel model= new DefaultTableModel();//to create model object to be placed in jtable
    private String[]columnName={"PR ID", "Item ID", "Item Name", "Quantity Required", "Cost Per Unit", "Total Amount", "Requisition Date", "Supplier ID", "Status"};
    private int row=-1;
    private static final Logger LOGGER = Logger.getLogger(ViewRequisition.class.getName()); 
    private javax.swing.JButton jButtonShowChart;


    /**
     * Creates new form ViewRequisition
     */
    public ViewRequisition() {
        initComponents();
        model.setColumnIdentifiers(columnName);
        loadDataFromFile();
        populateComboBox();

        
    }
    
   

private void showStatusChart() {
    // Count statuses
    int approvedCount = 0, rejectedCount = 0, pendingCount = 0;
    for (int i = 0; i < model.getRowCount(); i++) {
        String status = (String) model.getValueAt(i, 8); // Index 8 for 'Status' column
        if ("Approved".equalsIgnoreCase(status)) {
            approvedCount++;
        } else if ("Rejected".equalsIgnoreCase(status)) {
            rejectedCount++;
        } else if ("Pending".equalsIgnoreCase(status)) {
            pendingCount++;
        }
    }

    // Create dataset for the bar chart (add each status as its own series)
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.addValue(approvedCount, "Approved", "Approved");
    dataset.addValue(rejectedCount, "Rejected", "Rejected");
    dataset.addValue(pendingCount, "Pending", "Pending");

    // Create the bar chart
    JFreeChart chart = ChartFactory.createBarChart(
            "Requisition Status Distribution", // Chart Title
            "Status",                         // X-Axis Label
            "Count",                          // Y-Axis Label
            dataset                           // Dataset
    );

    // Customize the bar colors
    CategoryPlot plot = chart.getCategoryPlot(); // Get the plot from the chart
    BarRenderer renderer = (BarRenderer) plot.getRenderer(); // Get the bar renderer

    // Set colors for each status
    renderer.setSeriesPaint(0, new Color(144, 238, 144)); // Approved = Light Green
    renderer.setSeriesPaint(1, new Color(255, 102, 102)); // Rejected = Light Red
    renderer.setSeriesPaint(2, new Color(255, 255, 102)); // Pending = Light Yellow

    // Show the chart in a JPanel inside a JOptionPane
    JPanel chartPanel = new ChartPanel(chart);
    JOptionPane.showMessageDialog(this, chartPanel, "Status Distribution", JOptionPane.PLAIN_MESSAGE);
}

    private void loadDataFromFile() {
   String filePath = "C:\\Users\\Jiannaa\\Desktop\\PurchaseRequisition.txt";
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
    String filePath = "C:\\Users\\Jiannaa\\Desktop\\PurchaseRequisition.txt"; // Path to your file
    File file = new File(filePath);
    if (!file.exists()) {
        System.out.println("Data file not found.");
        return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line = br.readLine(); // Skip the header line
        jComboBox1.removeAllItems(); // Clear the combo box
        jComboBox1.addItem("PRID"); // Add a default option to show all items
        while ((line = br.readLine()) != null) {
            String[] rowData = line.split(",");
            if (rowData.length > 0) {
                String PRID = rowData[0]; // Assuming Item ID is in the first column
                jComboBox1.addItem(PRID); // Add Item ID to combo box
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
        jComboBox1 = new javax.swing.JComboBox<>();
        label1 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        label2 = new java.awt.Label();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(model);
        jTable1.setPreferredSize(new java.awt.Dimension(890, 500));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PR ID" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N
        label1.setText("List Of Requisition");

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

        jButton6.setText("LogOut");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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
                        .addGap(73, 73, 73)
                        .addComponent(jButton6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addGap(32, 32, 32)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(25, 25, 25))
        );

        jButton4.setText("Create");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton4)
                            .addGap(38, 38, 38)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(122, 122, 122))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
String selectedOption = (String) jComboBox2.getSelectedItem();

        if ("View Requisition".equals(selectedOption)) {
            // Open View Requisition page
            new ViewRequisition().setVisible(true); // Replace with actual page class
        } else if ("Create Requisition".equals(selectedOption)) {
            // Open Create Requisition page
            new CreateRequisition().setVisible(true); // Replace with actual page class
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String selectedPRID = (String) jComboBox1.getSelectedItem(); // Get selected Item ID

    // If "All" is selected, reload all data
    if ("PRID".equals(selectedPRID)) {
        loadDataFromFile(); // Reload all data
        return;
    }

    // Clear the table
    model.setRowCount(0);

    String filePath = "C:\\Users\\Jiannaa\\Desktop\\PurchaseRequisition.txt"; // Path to your file
    File file = new File(filePath);
    if (!file.exists()) {
        System.out.println("Data file not found.");
        return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line = br.readLine(); // Skip the header line
        while ((line = br.readLine()) != null) {
            String[] rowData = line.split(",");
            if (rowData.length > 0 && rowData[0].equals(selectedPRID)) {
                model.addRow(rowData); // Add row if Item ID matches
            }
        }
    } catch (Exception ex) {
        LOGGER.log(Level.SEVERE, "Error filtering data", ex);
        JOptionPane.showMessageDialog(this, "Error filtering data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        row= jTable1.getSelectedRow();

    String PRID= String.valueOf(model.getValueAt(row,0));
    String ItemID= String.valueOf(model.getValueAt(row,1));
    String Quantity= String.valueOf(model.getValueAt(row,2));
    String SupplierID= String.valueOf(model.getValueAt(row,3));
    String UnitPerPrice= String.valueOf(model.getValueAt(row,4));
   String TotalAmount= String.valueOf(model.getValueAt(row,5));
   
    
    }//GEN-LAST:event_jTable1MouseReleased

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
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
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        showStatusChart();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRequisition().setVisible(true);
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
