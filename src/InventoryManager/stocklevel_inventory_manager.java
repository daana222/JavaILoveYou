
package InventoryManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Logger;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Paint;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;



public class stocklevel_inventory_manager extends javax.swing.JFrame {  
  private DefaultTableModel model= new DefaultTableModel();
    private String[]columnName={"itemID"," item Name","Current Stock Level","Reorder Level","Last Updated  Date"};
    private int row=-1;
    private static final Logger LOGGER = Logger.getLogger(stocklevel_inventory_manager.class.getName()); 
    private HashMap<String, String> itemData = new HashMap<>();
    private HashMap<String, String> itemIdToNameMap = new HashMap<>();
    
    public stocklevel_inventory_manager() {
     model.setColumnIdentifiers(columnName);
     initComponents();
     boolean isBelowReorderLevel;
     populateComboBox();
     model.setColumnIdentifiers(columnName);
     jTable1.setModel(model);
     setupCustomRenderers();
     loadDataFromFile();
     setupFunStockRenderer();
     
     
     
     // OOP Principle: Abstraction - Event handling logic is encapsulated in ActionListener
     jComboBox1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String selectedItemID = (String) jComboBox1.getSelectedItem();
            if (selectedItemID != null && itemIdToNameMap.containsKey(selectedItemID)) {
                String itemName = itemIdToNameMap.get(selectedItemID);
                jTextField2.setText(itemName);
            } else {
                jTextField2.setText("");
            }
        }
    });
    }

     class CustomBarRenderer extends BarRenderer {
       public Paint getItemPaint(int row, int column) {
        switch (column) {
            case 0: return new Color(255, 102, 102);  
            case 1: return new Color(255, 178, 102);  
            case 2: return new Color(102, 178, 255);  
            case 3: return new Color(102, 255, 102);  
            default: return super.getItemPaint(row, column);
        }
    }
}
     
     
     // OOP Principle: Abstraction - Simplifies the creation of a stock char
   private void generateStockChartPopup() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    int belowReorderCount = 0;
    int nearReorderCount = 0;
    int sufficientStockCount = 0;
    int fullStockCount = 0;

    // Loop through table rows to count stock levels
    for (int i = 0; i < model.getRowCount(); i++) {
        try {
            // Extract numeric stock and reorder level safely
            String currentStockStr = model.getValueAt(i, 2).toString().replaceAll("[^0-9]", "").trim();
            String reorderLevelStr = model.getValueAt(i, 3).toString().replaceAll("[^0-9]", "").trim();

            if (currentStockStr.isEmpty() || reorderLevelStr.isEmpty()) continue; // Skip invalid rows

            int currentStock = Integer.parseInt(currentStockStr);
            int reorderLevel = Integer.parseInt(reorderLevelStr);

            if (currentStock < reorderLevel) {
                belowReorderCount++;
            } else if (currentStock < reorderLevel * 1.2) {
                nearReorderCount++;
            } else if (currentStock >= reorderLevel * 2) {
                fullStockCount++;
            } else {
                sufficientStockCount++;
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing stock data at row " + i + ": " + e.getMessage());
        }
    }

    // Add values to dataset
    dataset.addValue(belowReorderCount, "Stock Levels", "Below Reorder 😤");
    dataset.addValue(nearReorderCount, "Stock Levels", "Near Reorder 😐");
    dataset.addValue(sufficientStockCount, "Stock Levels", "Sufficient Stock 😎");
    dataset.addValue(fullStockCount, "Stock Levels", "Full Stock 🎉");

    // Check if dataset is empty
    if (belowReorderCount == 0 && nearReorderCount == 0 && sufficientStockCount == 0 && fullStockCount == 0) {
        JOptionPane.showMessageDialog(this, "No valid data to display in the chart!", "Chart Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Create bar chart
    JFreeChart barChart = ChartFactory.createBarChart(
            "Stock Level Chart", 
            "Stock Status",         
            "Number of Items",      
            dataset,
            PlotOrientation.VERTICAL,
            false,  
            true,  
            false   
    );

    // Customize the chart appearance
    CategoryPlot plot = barChart.getCategoryPlot();
    CustomBarRenderer renderer = new CustomBarRenderer();
    renderer.setDrawBarOutline(false);
    renderer.setBarPainter(new StandardBarPainter());
    renderer.setSeriesPaint(0, new Color(255, 102, 102)); // Light Red
    renderer.setSeriesPaint(1, new Color(255, 178, 102)); // Light Orange
    renderer.setSeriesPaint(2, new Color(102, 178, 255)); // Light Blue
    renderer.setSeriesPaint(3, new Color(102, 255, 102)); // Light Green
    plot.setRenderer(renderer);

    // Improve chart grid and axis appearance
    plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
    plot.setRangeGridlinePaint(Color.GRAY);

    CategoryAxis domainAxis = plot.getDomainAxis();
    domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
    domainAxis.setTickLabelFont(new Font("SansSerif", Font.BOLD, 12));
    domainAxis.setLabelFont(new Font("SansSerif", Font.BOLD, 14));

    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    rangeAxis.setTickLabelFont(new Font("SansSerif", Font.BOLD, 12));
    rangeAxis.setLabelFont(new Font("SansSerif", Font.BOLD, 14));

    barChart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 16));

    // Display chart in a popup
    ChartPanel chartPanel = new ChartPanel(barChart);
    chartPanel.setPreferredSize(new java.awt.Dimension(600, 400));
    JOptionPane.showMessageDialog(this, chartPanel, "Stock Level Chart", JOptionPane.PLAIN_MESSAGE);
}
    
    // OOP Principle: Abstraction - Simplifies file loading logic into a single method
  private void loadDataFromFile() {
        String filePath = "items.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "File not found: " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            model.setRowCount(0); 
            String header = br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",", -1); 
                if (rowData.length >= 8) {
                    
                    model.addRow(new Object[]{
                        rowData[0].trim(), 
                        rowData[1].trim(), 
                        rowData[3].trim(), 
                        rowData[4].trim(), 
                        rowData[7].trim()  
                    });
                }
            }
        } catch (IOException ex) {
            LOGGER.log(java.util.logging.Level.SEVERE, "Error loading file", ex);
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
 // OOP Principle: Polymorphism - Custom table cell renderer for highlighting stock levels
  private void setupCustomRenderers() {
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                try {
                    int currentStock = Integer.parseInt(table.getValueAt(row, 2).toString().trim());
                    int reorderLevel = Integer.parseInt(table.getValueAt(row, 3).toString().trim());
                    if (currentStock < reorderLevel) {
                        c.setForeground(Color.RED);
                    } else {
                        c.setForeground(Color.BLACK);
                    }
                } catch (NumberFormatException e) {
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        });
    }

    
  
  
   
 

    

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        stocklevel_deletebutton = new javax.swing.JButton();
        stocklevel_searchbutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        stocklevel_edit_button = new javax.swing.JButton();
        stock_level_generateChart = new javax.swing.JButton();
        stocklevel_savebutton = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Reorder Level");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Last Updated Date");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        stocklevel_deletebutton.setText("Delete");
        stocklevel_deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocklevel_deletebuttonActionPerformed(evt);
            }
        });

        stocklevel_searchbutton.setText("Search");
        stocklevel_searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocklevel_searchbuttonActionPerformed(evt);
            }
        });

        jTable1.setModel(model);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        stocklevel_edit_button.setText("Edit");
        stocklevel_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocklevel_edit_buttonActionPerformed(evt);
            }
        });

        stock_level_generateChart.setText("Generate Chart");
        stock_level_generateChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_level_generateChartActionPerformed(evt);
            }
        });

        stocklevel_savebutton.setText("Save");
        stocklevel_savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocklevel_savebuttonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel6.setText("Inventory Manager");

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
                        .addComponent(jLabel6)
                        .addGap(29, 29, 29))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addGap(26, 26, 26)
                .addComponent(jButton5)
                .addGap(28, 28, 28)
                .addComponent(jButton7)
                .addGap(34, 34, 34)
                .addComponent(jButton9)
                .addGap(24, 24, 24))
        );

        jLabel1.setText("Item ID");

        jLabel2.setText("Item Name");

        jLabel3.setText("Current Stock Level");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(stocklevel_savebutton)
                        .addGap(38, 38, 38)
                        .addComponent(stocklevel_searchbutton)
                        .addGap(33, 33, 33)
                        .addComponent(stocklevel_deletebutton)
                        .addGap(37, 37, 37)
                        .addComponent(stocklevel_edit_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stock_level_generateChart)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stocklevel_deletebutton)
                    .addComponent(stocklevel_savebutton)
                    .addComponent(stocklevel_edit_button)
                    .addComponent(stocklevel_searchbutton)
                    .addComponent(stock_level_generateChart))
                .addGap(6, 6, 6))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed

    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void stocklevel_deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocklevel_deletebuttonActionPerformed
        if(row==-1){
            JOptionPane.showMessageDialog(this,"Please selesct a row to delete");
        }
        else{
            model.removeRow(row);
            ClearTextField();
            row=-1;
        }
    }//GEN-LAST:event_stocklevel_deletebuttonActionPerformed

    private void stocklevel_searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocklevel_searchbuttonActionPerformed
     String searchID = jComboBox1.getSelectedItem().toString().trim(); // Selected Item ID
    String searchName = jTextField2.getText().trim().toLowerCase();  // Item Name input

    DefaultTableModel filteredModel = new DefaultTableModel();
    filteredModel.setColumnIdentifiers(columnName); // Set column headers

    boolean found = false;

    for (int i = 0; i < model.getRowCount(); i++) {
        String itemID = model.getValueAt(i, 0).toString().trim();
        String itemName = model.getValueAt(i, 1).toString().trim().toLowerCase();
        boolean matchesID = searchID.equalsIgnoreCase("All") || itemID.equalsIgnoreCase(searchID);
        boolean matchesName = searchName.isEmpty() || itemName.contains(searchName);

        if (matchesID && matchesName) {
            filteredModel.addRow(model.getDataVector().elementAt(i)); // Add filtered row
            found = true;
        }
    }

    // Display results
    if (found) {
        jTable1.setModel(filteredModel);
        applyStockRendererToNewModel(); // Apply renderer for emojis
    } else {
        JOptionPane.showMessageDialog(this, "No matching records found!", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        jTable1.setModel(model); // Reset to original table
        applyStockRendererToNewModel();
    }


    }//GEN-LAST:event_stocklevel_searchbuttonActionPerformed

    
    
    private void applyStockRendererToNewModel() {
    jTable1.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setOpaque(true);
            try {
                // Extract numeric stock and reorder level safely
                int currentStock = Integer.parseInt(value.toString().replaceAll("[^0-9]", "").trim());
                int reorderLevel = Integer.parseInt(table.getValueAt(row, 3).toString().trim());

                // Determine emoji and background color
                String emoji;
                Color bgColor;
                if (currentStock < reorderLevel) {
                    emoji = "😤";
                    bgColor = new Color(255, 220, 220); // Light Red
                } else if (currentStock < reorderLevel * 1.2) {
                    emoji = "😐";
                    bgColor = new Color(255, 245, 204); // Light Yellow
                } else if (currentStock >= reorderLevel * 2) {
                    emoji = "🎉";
                    bgColor = new Color(204, 255, 204); // Light Green
                } else {
                    emoji = "😎";
                    bgColor = new Color(204, 229, 255); // Light Blue
                }

                // Apply emoji and color
                label.setText(emoji + " " + currentStock);
                label.setBackground(bgColor);
                label.setForeground(Color.BLACK);
            } catch (Exception e) {
                label.setBackground(Color.LIGHT_GRAY); // Default background
                label.setText(value.toString()); // Display the value directly
            }

            if (isSelected) {
                label.setBackground(table.getSelectionBackground());
                label.setForeground(table.getSelectionForeground());
            }
            return label;
        }
    });
    jTable1.repaint();
}
    
    
    
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        row = jTable1.getSelectedRow(); 
    if (row == -1) return; 

    try {
      
        String itemID = (model.getValueAt(row, 0) != null) ? model.getValueAt(row, 0).toString().trim() : "";
        String itemName = (model.getValueAt(row, 1) != null) ? model.getValueAt(row, 1).toString().trim() : "";
        String currentStock = (model.getValueAt(row, 2) != null) ? model.getValueAt(row, 2).toString().trim() : "";
        String reorderLevel = (model.getValueAt(row, 3) != null) ? model.getValueAt(row, 3).toString().trim() : "";
        String lastUpdated = (model.getValueAt(row, 4) != null) ? model.getValueAt(row, 4).toString().trim() : "";

        
        if (isValueInComboBox(itemID)) { 
            jComboBox1.setSelectedItem(itemID);
        } else {
            jComboBox1.setSelectedIndex(0); 
        }
        jTextField2.setText(itemName);
        jTextField3.setText(currentStock);
        jTextField4.setText(reorderLevel);

        
        if (!lastUpdated.isEmpty()) { 
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(lastUpdated);
            jDateChooser1.setDate(date);
        } else {
            jDateChooser1.setDate(null);
        }

    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Invalid date format in table: " + e.getMessage(),
                "Date Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error loading row data: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }


          
    }//GEN-LAST:event_jTable1MouseReleased

  

private boolean isValueInComboBox(String value) {
    for (int i = 0; i < jComboBox1.getItemCount(); i++) {
        if (jComboBox1.getItemAt(i).toString().equals(value)) {
            return true;
        }
    }
    return false;


    }   


    private void stocklevel_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocklevel_edit_buttonActionPerformed
        try {
       
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       
        if (jTextField2.getText().isEmpty() || 
            jTextField3.getText().isEmpty() || 
            jTextField4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       
        if (!jTextField2.getText().matches("^[a-zA-Z ]{3,30}$")) {
            JOptionPane.showMessageDialog(this, "Item Name must be alphabetic and 3-30 characters long!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       
        int currentStockLevel;
        try {
            currentStockLevel = Integer.parseInt(jTextField3.getText().trim());
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
            reorderLevel = Integer.parseInt(jTextField4.getText().trim());
            if (reorderLevel < 0) {
                JOptionPane.showMessageDialog(this, "Reorder Level cannot be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Reorder Level must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please select a date!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastUpdated = sdf.format(jDateChooser1.getDate());

        
        model.setValueAt(jComboBox1.getSelectedItem().toString(), row, 0); 
        model.setValueAt(jTextField2.getText().trim(), row, 1); 
        model.setValueAt(jTextField3.getText().trim(), row, 2); 
        model.setValueAt(jTextField4.getText().trim(), row, 3); 
        model.setValueAt(lastUpdated, row, 4); 

       

       
        JOptionPane.showMessageDialog(this, "Item updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        ClearTextField();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
  
    }//GEN-LAST:event_stocklevel_edit_buttonActionPerformed


private void setupFunStockRenderer() {
    jTable1.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setOpaque(true);

            try {
                // Extract numeric value by removing emojis or non-numeric characters
                int currentStock = Integer.parseInt(value.toString().replaceAll("[^0-9]", "").trim());
                int reorderLevel = Integer.parseInt(table.getValueAt(row, 3).toString().trim());

                // Set emoji and color logic
                String emoji = "";
                Color bgColor;

                if (currentStock < reorderLevel) {
                    emoji = "😤"; // Below Reorder Level
                    bgColor = new Color(255, 220, 220); // Light Red
                } else if (currentStock < reorderLevel * 1.2) {
                    emoji = "😐"; // Near Reorder Level
                    bgColor = new Color(255, 245, 204); // Light Yellow
                } else if (currentStock >= reorderLevel * 2) {
                    emoji = "🎉"; // Full Stock
                    bgColor = new Color(204, 255, 204); // Light Green
                } else {
                    emoji = "😎"; // Sufficient Stock
                    bgColor = new Color(204, 229, 255); // Light Blue
                }

                label.setText(emoji + " " + currentStock);
                label.setBackground(bgColor);
                label.setForeground(Color.BLACK);
            } catch (Exception e) {
                label.setBackground(new Color(240, 240, 240)); // Default gray
                label.setForeground(Color.BLACK);
            }

            // Highlight selection
            if (isSelected) {
                label.setBackground(table.getSelectionBackground());
                label.setForeground(table.getSelectionForeground());
            }
            return label;
        }
    });

    jTable1.repaint(); // Ensure the table updates with the new renderer
}

    private void stock_level_generateChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_level_generateChartActionPerformed
        generateStockChartPopup();
    }//GEN-LAST:event_stock_level_generateChartActionPerformed

    private void stocklevel_savebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocklevel_savebuttonActionPerformed

      

    }//GEN-LAST:event_stocklevel_savebuttonActionPerformed

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

    private void populateComboBox() {
    String filePath = "items.txt";
    File file = new File(filePath);
    if (!file.exists()) {
        System.out.println("File not found: " + filePath);
        return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        jComboBox1.removeAllItems();
        jComboBox1.addItem("All"); 
        String line;
        
        String header = br.readLine(); 
        System.out.println("Header: " + header);
        
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue; 
            String[] rowData = line.split(",", -1); 
            
            if (rowData.length > 0 && !rowData[0].trim().isEmpty()) {
                String itemID = rowData[0].trim();
                jComboBox1.addItem(itemID);
            }
        }
        System.out.println("ComboBox loaded with " + jComboBox1.getItemCount() + " items.");
    } catch (Exception ex) {
        ex.printStackTrace();
        LOGGER.log(java.util.logging.Level.SEVERE, "Error loading Item IDs", ex);
        JOptionPane.showMessageDialog(this, "Error loading Item IDs: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stocklevel_inventory_manager().setVisible(true);
            }
        });
    }
    
    
   // OOP Principle: Encapsulation - Helper method to clear fields
    public void ClearTextField(){
   jComboBox1.setSelectedItem("itemID");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
   jDateChooser1.setDate(null);
    
    }
    
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton stock_level_generateChart;
    private javax.swing.JButton stocklevel_deletebutton;
    private javax.swing.JButton stocklevel_edit_button;
    private javax.swing.JButton stocklevel_savebutton;
    private javax.swing.JButton stocklevel_searchbutton;
    // End of variables declaration//GEN-END:variables
}
