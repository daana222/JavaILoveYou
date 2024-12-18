/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author HP
 */
public class AdminTopPanel extends JPanel {
     private JLabel welcomeLabel;
    private JLabel idLabel;

    // Constructor to set up the panel
    public AdminTopPanel(String ID) {
        // Panel configuration
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Welcome Label
        welcomeLabel = new JLabel("Welcome ", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.BLACK);

        // ID Label
        idLabel = new JLabel("User ID: " + ID, SwingConstants.CENTER);
        idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        idLabel.setForeground(Color.BLACK);

        // Add components to the panel
        add(welcomeLabel);
        add(idLabel);
    }

    // Method to update the User ID dynamically
    public void setUserID(String ID) {
        idLabel.setText("User ID: " + ID);
    }
}
    

