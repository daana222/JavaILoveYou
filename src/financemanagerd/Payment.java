package financemanagerd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Payment extends javax.swing.JFrame {

    private java.util.List<Object[]> originalTableData;
    
    public Payment() {
        initComponents();
        setSize(890, 500);
        setLocationRelativeTo(null); // Center the frame
        
        String filePath = "C:\\Users\\Mitsu\\OneDrive - Asia Pacific University\\Documents\\NetBeansProjects\\FinanceManagerD\\Payment.txt";

        // Load data and store the original table for future filtering
        loadDataFromFile(filePath);
        storeOriginalTableData();
        storeOriginalTableData2();
        addDueDateRenderer();
        // Select the row with the specific PO ID
        
        
    }
    
    public Payment(String poId) {
        initComponents();
        setSize(890, 500);
        setLocationRelativeTo(null);
        
        String filePath = "C:\\Users\\Mitsu\\OneDrive - Asia Pacific University\\Documents\\NetBeansProjects\\FinanceManagerD\\Payment.txt";

        loadDataFromFile(filePath); // Load data into the table
        storeOriginalTableData();
        addDueDateRenderer();
        //updateItemsFromPO(poId);

        // Select the row with the specific PO ID
        preselectRowByPOID(poId);
    }


    private static int paymentCounter = 1; // Counter for generating Payment IDs

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        Searchbtn = new javax.swing.JButton();
        searchtxtfield = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        makePaymentbtn = new javax.swing.JButton();
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Payment");

        Searchbtn.setText("Search");
        Searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchbtnActionPerformed(evt);
            }
        });

        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "P.O ID", "Supplier ID", "Total Items", "Total Amount", "Payment Status", "Due Date", "Payment Date", "Payment ID"
            }
        ));
        paymentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(paymentTable);

        makePaymentbtn.setText("Make Payment");
        makePaymentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePaymentbtnActionPerformed(evt);
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Paid", "Pending", "Late" }));
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(578, 578, 578)
                        .addComponent(makePaymentbtn)
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addContainerGap(639, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(Searchbtn)
                                .addGap(18, 18, 18)
                                .addComponent(searchtxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Searchbtn)
                    .addComponent(searchtxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(makePaymentbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paymentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentTableMouseClicked

    }//GEN-LAST:event_paymentTableMouseClicked

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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selectedStatus = jComboBox1.getSelectedItem().toString();
        filterTableByStatus(selectedStatus);
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    
    private void filterTableByStatus(String status) {
        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
        model.setRowCount(0); // Clear the table

        // Reload data based on the filter
        for (Object[] row : originalTableData) {
            String rowStatus = row[4].toString(); // Assuming "Status" is in column 5

            if (status.equalsIgnoreCase("All") || rowStatus.equalsIgnoreCase(status)) {
                model.addRow(row); // Add the matching row
            }
        }
    }
    
    
    private void storeOriginalTableData() {
        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
        originalTableData = new java.util.ArrayList<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            Object[] row = new Object[model.getColumnCount()];
            for (int j = 0; j < model.getColumnCount(); j++) {
                row[j] = model.getValueAt(i, j);
            }
            originalTableData.add(row);
        }
    }

    
    
    
    private void loadDataFromFile(String filePath) {
        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
        model.setRowCount(0); // Clear existing data in the table

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true; // Skip the header row

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }

                String[] allColumns = line.split(",");
                if (allColumns.length >= 8) { // Ensure there are enough columns in the row
                    String paymentId = allColumns[0].trim();
                    String poId = allColumns[1].trim();
                    String paymentStatus = allColumns[2].trim();
                    String paymentDate = allColumns[3].trim();
                    String dueDate = allColumns[4].trim();
                    String supplierId = allColumns[5].trim();
                    String totalItems = allColumns[6].trim();
                    String totalAmount = allColumns[7].trim();

                    // Add row to the table
                    model.addRow(new Object[]{poId, supplierId, totalItems, totalAmount, paymentStatus, dueDate, paymentDate, paymentId});
                }
            }
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading Payment.txt: " + e.getMessage());
        }
    }






        
    

    private void storeOriginalTableData2() {
        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
        originalTableData = new java.util.ArrayList<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            Object[] row = new Object[model.getColumnCount()];
            for (int j = 0; j < model.getColumnCount(); j++) {
                row[j] = model.getValueAt(i, j);
            }
            originalTableData.add(row);
        }
    }


    
    
    
    
    private void makePaymentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makePaymentbtnActionPerformed
        int selectedRow = paymentTable.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a row to make a payment.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
        String status = model.getValueAt(selectedRow, 4).toString(); // Assuming "Payment Status" is in column 4

        if (status.equalsIgnoreCase("Paid") || status.equalsIgnoreCase("Late")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Payment is already made.");
            return;
        }

        // Retrieve row details
        String poNumber = model.getValueAt(selectedRow, 0).toString(); // PO ID
        String supplierId = model.getValueAt(selectedRow, 1).toString(); // Supplier ID
        String totalAmount = model.getValueAt(selectedRow, 3).toString(); // Total Amount
        String dueDateStr = model.getValueAt(selectedRow, 5).toString(); // Due Date

        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String paymentDate = dateFormat.format(new java.util.Date());
        String paymentId = generatePaymentId(model);

        try {
            java.util.Date dueDate = dateFormat.parse(dueDateStr);
            java.util.Date currentDate = new java.util.Date();

            if (currentDate.after(dueDate)) {
                model.setValueAt("Late", selectedRow, 4); // Set status to "Late"
            } else {
                model.setValueAt("Paid", selectedRow, 4); // Set status to "Paid"
            }

            // Update the table and file
            updatePaymentDetails(poNumber, model.getValueAt(selectedRow, 4).toString(), paymentDate, paymentId);

            // Call updateItemsFromPO here to update stock and reorder levels
            updateItemsFromPO(poNumber);

            // Refresh table data
            loadDataFromFile("C:\\Users\\Mitsu\\OneDrive - Asia Pacific University\\Documents\\NetBeansProjects\\FinanceManagerD\\Payment.txt");

            // Generate Receipt
            generateTextReceipt(supplierId, poNumber, totalAmount, dueDateStr, paymentDate, paymentId);

        } catch (java.text.ParseException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error parsing due date: " + e.getMessage());
        }
    }//GEN-LAST:event_makePaymentbtnActionPerformed

    
    public void clearTextField(){
        searchtxtfield.setText("");
        
    }
    
    
    private String generatePaymentId(DefaultTableModel model) {
        int highestId = 0;

        // Scan the table to find the highest Payment ID
        for (int row = 0; row < model.getRowCount(); row++) {
            Object paymentIdObj = model.getValueAt(row, 7); // Assuming "Payment ID" is column 7
            if (paymentIdObj != null) {
                String paymentId = paymentIdObj.toString();
                if (paymentId.startsWith("PAY")) {
                    try {
                        int id = Integer.parseInt(paymentId.substring(3)); // Extract numeric part of "PAYXXX"
                        highestId = Math.max(highestId, id); // Keep track of the highest ID
                    } catch (NumberFormatException e) {
                        // Ignore invalid Payment IDs
                    }
                }
            }
        }

        // Generate the next unique Payment ID
        String newPaymentId = "PAY" + String.format("%03d", highestId + 1);
        return newPaymentId;
    }


    
    private void SearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbtnActionPerformed
        // TODO add your handling code here:
        String query = searchtxtfield.getText().trim().toLowerCase();

        if (query.isEmpty()) {
            // If query is empty, reset the table to show all rows
            DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
            model.setRowCount(0);
            for (Object[] row : originalTableData) {
                model.addRow(row);
            }
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
        model.setRowCount(0); // Clear the table
        clearTextField();
        // Iterate through originalTableData and filter rows
        for (Object[] row : originalTableData) {
            for (Object cell : row) {
                if (cell != null && cell.toString().toLowerCase().contains(query)) {
                    model.addRow(row); // Add the matching row
                    break; // Move to the next row once a match is found
                }
            }
        }

        if (model.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "No results found for: " + query);
        }
    }//GEN-LAST:event_SearchbtnActionPerformed
    
    
    private void updatePaymentDetails(String poNumber, String newStatus, String paymentDate, String paymentId) {
        String filePath = "C:\\Users\\Mitsu\\OneDrive - Asia Pacific University\\Documents\\NetBeansProjects\\FinanceManagerD\\Payment.txt";

        try {
            java.util.List<String> lines = new java.util.ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] columns = line.split(",");
                    if (columns.length >= 8 && columns[1].trim().equals(poNumber)) {
                        // Match the PO ID and update columns
                        columns[2] = newStatus; // Payment Status
                        columns[3] = paymentDate; // Payment Date
                        columns[0] = paymentId; // Payment ID
                    }
                    lines.add(String.join(",", columns)); // Add the updated or unchanged line
                }
            }

            // Write back updated lines to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
            javax.swing.JOptionPane.showMessageDialog(this, "Payment details successfully updated in Payment.txt!");
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error updating Payment.txt: " + e.getMessage());
        }
    }




    
    
    
    private void generateTextReceipt(String supplierId, String poNumber, String totalAmount, String dueDate, String paymentDate, String paymentId) {
        String receiptFilePath = "C:/Users/Mitsu/OneDrive - Asia Pacific University/Documents/NetBeansProjects/FinanceManagerD/receipts/Receipt_" + paymentId + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFilePath))) {
            writer.write("Payment Receipt");
            writer.newLine();
            writer.write("------------------------");
            writer.newLine();
            writer.write("Supplier ID: " + supplierId);
            writer.newLine();
            writer.write("P.O Number: " + poNumber);
            writer.newLine();
            writer.write("Total Amount: $" + totalAmount);
            writer.newLine();
            writer.write("Due Date: " + dueDate);
            writer.newLine();
            writer.write("Payment Status: Paid");
            writer.newLine();
            writer.write("Payment Date: " + paymentDate);
            writer.newLine();

            
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving receipt: " + e.getMessage());
        }
    }

    
    private void addDueDateRenderer() {
        paymentTable.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
            private final java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd"); // Updated format

            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                java.awt.Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                try {
                    java.util.Date dueDate = dateFormat.parse(value.toString());
                    java.util.Date currentDate = new java.util.Date();

                    if (currentDate.after(dueDate)) {
                        cell.setForeground(java.awt.Color.RED);
                    } else {
                        cell.setForeground(java.awt.Color.BLACK);
                    }
                } catch (Exception e) {
                    cell.setForeground(java.awt.Color.BLACK); // Default color in case of error
                }

                return cell;
            }
        });
    }
    
    private void updateItemsFromPO(String poId) {
        String poFilePath = "C:\\Users\\Mitsu\\OneDrive - Asia Pacific University\\Documents\\NetBeansProjects\\FinanceManagerD\\PO.txt";
        String itemsFilePath = "C:\\Users\\Mitsu\\OneDrive - Asia Pacific University\\Documents\\NetBeansProjects\\FinanceManagerD\\items.txt";

        try {
            // Step 1: Read PO.txt to find matching PO ID and item details
            java.util.Map<String, Integer> itemsToUpdate = new java.util.HashMap<>(); // Map of Item ID -> Quantity

            try (BufferedReader poReader = new BufferedReader(new FileReader(poFilePath))) {
                String line;
                boolean isFirstLine = true;
                while ((line = poReader.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false; // Skip the header row
                        continue;
                    }
                    String[] columns = line.split(",");
                    if (columns.length >= 5 && columns[0].trim().equals(poId)) { // Match PO ID
                        String itemId = columns[2].trim(); // Item ID (column 3 in PO.txt)
                        int quantity = Integer.parseInt(columns[4].trim()); // Quantity (column 4 in PO.txt)
                        itemsToUpdate.put(itemId, itemsToUpdate.getOrDefault(itemId, 0) + quantity); // Add quantity
                        System.out.println("PO ID: " + poId + " | Item ID: " + itemId + " | Quantity to Add: " + quantity);
                    }
                }
            }

            if (itemsToUpdate.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "No matching items found in PO.txt for PO ID: " + poId);
                return;
            }

            // Step 2: Read and update items.txt
            java.util.List<String> updatedLines = new java.util.ArrayList<>();
            try (BufferedReader itemsReader = new BufferedReader(new FileReader(itemsFilePath))) {
                String line;
                boolean isFirstLine = true;
                while ((line = itemsReader.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false; // Keep the header row unchanged
                        updatedLines.add(line);
                        continue;
                    }

                    String[] columns = line.split(",");
                    if (columns.length >= 7) { // Ensure correct structure
                        String itemId = columns[0].trim(); // Item ID
                        if (itemsToUpdate.containsKey(itemId)) { // Check if this item needs to be updated
                            int currentStock = Integer.parseInt(columns[2].trim()); // Stock level
                            int reorderLevel = Integer.parseInt(columns[4].trim()); // Reorder level
                            int quantityToAdd = itemsToUpdate.get(itemId);

                            // Update stock level and reorder level
                            int newStockLevel = currentStock + quantityToAdd; // Increase stock level
                            int newReorderLevel = reorderLevel - quantityToAdd; // Decrease reorder level
                            if (newReorderLevel < 0) newReorderLevel = 0; // Avoid negative reorder level

                            // Apply updates
                            columns[2] = String.valueOf(newStockLevel); // Update stock level
                            columns[4] = String.valueOf(newReorderLevel); // Update reorder level

                            // Debugging: Log updates
                            System.out.println("Updated Item ID: " + itemId + " | New Stock: " + newStockLevel + " | New Reorder Level: " + newReorderLevel);
                        }
                    }
                    updatedLines.add(String.join(",", columns)); // Add updated or unchanged line
                }
            }

            // Step 3: Write back updated lines to items.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(itemsFilePath))) {
                for (String updatedLine : updatedLines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }

            javax.swing.JOptionPane.showMessageDialog(this, "Items successfully updated in items.txt!");
        } catch (IOException | NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error updating items.txt: " + e.getMessage());
            e.printStackTrace(); // Log the error for debugging
        }
    }





    private void preselectRowByPOID(String poId) {
        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String tablePoId = model.getValueAt(i, 0).toString(); // Assuming PO ID is in column 0
            if (tablePoId.equals(poId)) {
                paymentTable.setRowSelectionInterval(i, i); // Select the matching row
                paymentTable.scrollRectToVisible(paymentTable.getCellRect(i, 0, true)); // Scroll to the row
                break;
            }
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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dashboardbtn;
    private javax.swing.JButton PObtn;
    private javax.swing.JButton Paymentbtn;
    private javax.swing.JButton Searchbtn;
    private javax.swing.JButton Stockbtn;
    private javax.swing.JButton Supplierbtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton makePaymentbtn;
    private javax.swing.JTable paymentTable;
    private javax.swing.JTextField searchtxtfield;
    // End of variables declaration//GEN-END:variables
}
