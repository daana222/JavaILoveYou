/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import ThemeManager.ThemeManager;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Login extends javax.swing.JFrame {

        private Object Admin;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents(); 
        ThemeManager.applyTheme(this);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setText("LOGIN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("     LOGIN PAGE ");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("  USERNAME :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("  PASSWORD :");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("     WELCOME TO NEXUS SDN BHD (NSB)");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("SHOW PASSWORD");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("DARK MODE :");

        jToggleButton1.setText("DARK MODE");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                .addComponent(jTextField1)))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(362, 362, 362))))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(14, 14, 14)
                .addComponent(jCheckBox1)
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jToggleButton1))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String username = jTextField1.getText().trim();
        String password = new String(jPasswordField1.getPassword()).trim();
        
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and Password text box cannot be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean loginSuccessful = false;
    String role = "";
    String ID = "";

try (BufferedReader reader = new BufferedReader(new FileReader("User.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println("File Line: " + line); // this is for Debugging: Print each line
        
        String[] userDetails = line.split(",");
        if (userDetails.length >= 7) {
            String fileUsername = userDetails[4].trim();
            String filePassword = userDetails[5].trim();

            System.out.println("Username: " + fileUsername + ", Password: " + filePassword); // Debugging

            if (username.equals(fileUsername) && password.equals(filePassword)) {
                loginSuccessful = true;
                role = userDetails[6].trim().toUpperCase();
                ID = userDetails[0].trim();
                break;
            }
        } else {
            System.out.println("Invalid Line Format: " + line); // Debugging: Invalid line
        }
    }
} catch (IOException e) {
    JOptionPane.showMessageDialog(this, "Error in reading user data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    return;
}
         if (loginSuccessful) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
             if (role.equalsIgnoreCase("ADMIN")) {
            new RoleSelection().setVisible(true); 
        } else {
            redirectToMainMenu(role, ID); 
        }
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void redirectToMainMenu(String role, String ID) {
    switch (role.toUpperCase()) {
        case "ADMIN":
            new Admin.Main_Menu(ID).setVisible(true);
            break;
        case "SALES MANAGER":
          //  new Sales_Manager.Main_Dashboard(ID).setVisible(true);
            break;
        case "PURCHASE MANAGER":
            new Purchase_Manager.PM(ID).setVisible(true);
            break;
        case "FINANCE MANAGER":
         //   new financemanagerd.FManager(ID).setVisible(true);
            break;
        default:
            JOptionPane.showMessageDialog(this, "Unknown role selected: " + role, "Error", JOptionPane.ERROR_MESSAGE);
            break;
    }
    this.dispose(); // Close the Login window
}

    
    public class RoleSelection extends JFrame {

    public RoleSelection() {
        setTitle("Select a Role");
        setSize(400, 300);
        setLayout(new GridLayout(5, 1, 10, 10));

        // Buttons for roles
        JButton btnSalesManager = new JButton("SALES MANAGER");
        JButton btnInventoryManager = new JButton("INVENTORY MANAGER");
        JButton btnPurchaseManager = new JButton("PURCHASE MANAGER");
        JButton btnFinanceManager = new JButton("FINANCE MANAGER");
        JButton btnAdmin = new JButton("ADMIN");

        // Add buttons to the frame
        add(btnSalesManager);
        add(btnInventoryManager);
        add(btnPurchaseManager);
        add(btnFinanceManager);
        add(btnAdmin);

       
        
        btnSalesManager.addActionListener(e -> {
            //new Sales_Manager.Main_Dashboard("S004").setVisible(true);
            this.dispose(); // Close RoleSelection window
        });

        btnInventoryManager.addActionListener(e -> {
            //JOptionPane.showMessageDialog(this, "Inventory Manager not implemented!", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose(); // Close RoleSelection window even if not implemented
        });

        btnPurchaseManager.addActionListener(e -> {
           // new Purchase_Manager.PM("P002").setVisible(true);
            this.dispose(); // Close RoleSelection window
        });

        btnFinanceManager.addActionListener(e -> {
          //  new financemanagerd.FManager("F002").setVisible(true);
            this.dispose(); // Close RoleSelection window
        });

        btnAdmin.addActionListener(e -> {
            new Admin.Main_Menu("U001").setVisible(true);
            this.dispose(); // Close RoleSelection window
        });

     


        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
 
    


    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
                jTextField1.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        
         String password = new String(jPasswordField1.getPassword());
         
         if (password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Password cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
          if (password.length() < 10) {
        JOptionPane.showMessageDialog(this, "Password must be at least 6 characters long to proceed ", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
            String username = jTextField1.getText();
            
            
     if (username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
         if (username.length() < 5) {
        JOptionPane.showMessageDialog(this, "Username must be at least 5 characters", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
        jPasswordField1.setEchoChar((char) 0); // Show password
    } else {
        jPasswordField1.setEchoChar('*'); // Hide password
    }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
                jPasswordField1.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
       
    ThemeManager.toggleDarkMode(); // Toggle the theme state
    ThemeManager.applyTheme(this); // Apply the updated theme to the current frame
    
    //if (jToggleButton1.isSelected()) {
        // Enable Dark Mode
      //  jToggleButton1.setText("LIGHT MODE"); // Change button text
      //  getContentPane().setBackground(java.awt.Color.DARK_GRAY); // Background for the frame
      //  jLabel2.setForeground(java.awt.Color.WHITE);
       // jLabel3.setForeground(java.awt.Color.WHITE);
       // jTextField1.setBackground(java.awt.Color.LIGHT_GRAY);
       // jTextField1.setForeground(java.awt.Color.BLACK);
       // jPasswordField1.setBackground(java.awt.Color.LIGHT_GRAY);
       // jPasswordField1.setForeground(java.awt.Color.BLACK);
       // jButton3.setBackground(java.awt.Color.BLACK);
     //   jButton3.setForeground(java.awt.Color.WHITE);
    //} else {
        // Enable Light Mode
     //   jToggleButton1.setText("DARK MODE"); // Change button text
      //  getContentPane().setBackground(java.awt.Color.WHITE);
      //  jLabel1.setForeground(java.awt.Color.BLACK);
      //  jLabel2.setForeground(java.awt.Color.BLACK);
     //   jLabel3.setForeground(java.awt.Color.BLACK);
      //  jTextField1.setForeground(java.awt.Color.BLACK);
      //  jPasswordField1.setBackground(java.awt.Color.WHITE);
      //  jPasswordField1.setForeground(java.awt.Color.BLACK);
       // jButton3.setBackground(java.awt.Color.WHITE);
       // jButton3.setForeground(java.awt.Color.BLACK);
   // }
 
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
