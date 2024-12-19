/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManager;

/**
 *
 * @author DIVIII
 */
public class Supplier {
    private String supplierID;
    private String supplierName;
    private String registrationDate;
    private String contact;
    private String email;

    // Constructor
    public Supplier(String supplierID, String supplierName, String registrationDate, String contact, String email) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.registrationDate = registrationDate;
        this.contact = contact;
        this.email = email;
    }

    // Getters
    public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Utility method to display supplier details
    public String displaySupplierDetails() {
        return "Supplier ID: " + supplierID + 
               ", Supplier Name: " + supplierName + 
               ", Registration Date: " + registrationDate + 
               ", Contact: " + contact + 
               ", Email: " + email;
    }

    // Method to validate email format
    public boolean isValidEmail() {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    // Method to check if all essential fields are filled
    public boolean isComplete() {
        return supplierName != null && !supplierName.isEmpty() &&
               registrationDate != null && !registrationDate.isEmpty() &&
               contact != null && !contact.isEmpty() &&
               email != null && !email.isEmpty();
    }
}
