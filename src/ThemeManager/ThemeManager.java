/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThemeManager;

import java.awt.Color;
import javax.swing.*;

public class ThemeManager {
    private static boolean isDarkMode = false;

    public static void applyTheme(JFrame frame) {
        // Define colours for Dark and Light modes
        Color backgroundColor = isDarkMode ? Color.DARK_GRAY : Color.LIGHT_GRAY; // Light Gray for Light Mode
        Color inputFieldBg = isDarkMode ? Color.LIGHT_GRAY : Color.WHITE;       // Input field colour
        Color textColor = isDarkMode ? Color.WHITE : Color.BLACK;               // Text colour
        Color inputTextColor = Color.BLACK;                                     // Input text remains black

        // Apply to the main content pane
        frame.getContentPane().setBackground(backgroundColor);
        frame.getRootPane().setBackground(backgroundColor);

        // Update all components recursively
        updateComponents(frame.getContentPane(), backgroundColor, inputFieldBg, textColor, inputTextColor, "sidePanel");
    }

    private static void updateComponents(java.awt.Container container, Color bg, Color inputBg, Color fg, Color inputFg, String excludePanelName) {
        for (java.awt.Component comp : container.getComponents()) {
            if (comp.getName() != null && comp.getName().equals(excludePanelName)) {
                continue; // Skip the side panel
            }

            if (comp instanceof JPanel || comp instanceof JComponent) {
                comp.setBackground(bg);
                if (comp instanceof java.awt.Container) {
                    updateComponents((java.awt.Container) comp, bg, inputBg, fg, inputFg, excludePanelName);
                }
            }

            if (comp instanceof JLabel || comp instanceof JButton || comp instanceof JCheckBox) {
                comp.setForeground(fg);
            }

            if (comp instanceof JTextField || comp instanceof JPasswordField) {
                comp.setBackground(inputBg);
                comp.setForeground(inputFg);
            }
        }
    }
    
    public static void updateTableTheme(JTable table) {
        if (table == null) return;

        // Colours for Dark Mode
        Color darkModeForeground = Color.WHITE;
        Color darkModeBackground = Color.DARK_GRAY;

        // Colours for Light Mode
        Color lightModeForeground = Color.BLACK;
        Color lightModeBackground = Color.LIGHT_GRAY; // Light Gray for Table Background

        // Check mode and apply colours
        if (isDarkMode) {
            table.setForeground(darkModeForeground);
            table.setBackground(darkModeBackground);
            table.getTableHeader().setForeground(darkModeForeground);
            table.getTableHeader().setBackground(Color.GRAY); // Optional: Darken header
        } else {
            table.setForeground(lightModeForeground);
            table.setBackground(lightModeBackground);
            table.getTableHeader().setForeground(lightModeForeground);
            table.getTableHeader().setBackground(Color.WHITE);
        }

        // Refresh the table
        table.repaint();
    }

    public static void toggleDarkMode() {
        isDarkMode = !isDarkMode;
    }

    public static boolean isDarkMode() {
        return isDarkMode;
    }
}