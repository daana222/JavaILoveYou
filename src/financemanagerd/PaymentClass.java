/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financemanagerd;

import java.text.SimpleDateFormat;
import java.util.Date;


public class PaymentClass {
    
    private String paymentId;
    private String poId;
    private String supplierId;
    private String totalItems;
    private String totalAmount;
    private String paymentStatus;
    private String dueDate;
    private String paymentDate;

    public PaymentClass (String paymentId, String poId, String supplierId, String totalItems, String totalAmount, String paymentStatus, String dueDate, String paymentDate) {
        this.paymentId = paymentId;
        this.poId = poId;
        this.supplierId = supplierId;
        this.totalItems = totalItems;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isPaymentLate() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date due = dateFormat.parse(this.dueDate);
            Date now = new Date();
            return now.after(due);
        } catch (Exception e) {
            return false;
        }
    }

    public void updatePaymentStatus() {
        if (isPaymentLate()) {
            this.paymentStatus = "Late";
        } else {
            this.paymentStatus = "Paid";
        }
        this.paymentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    @Override
    
    public String toString() {
        return String.join(",",
            this.paymentId,
            this.poId,
            this.paymentStatus,
            this.paymentDate,
            this.dueDate,
            this.supplierId,
            this.totalItems,
            this.totalAmount
        );
}


    
}



