
package financemanagerd;


public class PurchaseOrderClass {
    private String poID;
    private String date;
    private String supplierID;
    private String approveReject;
    private double totalAmount;
    
    public PurchaseOrderClass (String poID, String date, String supplierID, String approveReject, double totalAmount) {
        this.poID = poID;
        this.date = date;
        this.supplierID = supplierID;
        this.approveReject = approveReject;
        this.totalAmount = totalAmount;
    }
    
    public String getPoID() {
        return poID;
    }

    public String getDate() {
        return date;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getApproveReject() {
        return approveReject;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addToTotalAmount(double amount) {
        this.totalAmount += amount;
    }

    // You can override toString for easier debugging or printing
    @Override
    public String toString() {
        return "POMaintenance{" +
                "poID='" + poID + '\'' +
                ", date='" + date + '\'' +
                ", supplierID='" + supplierID + '\'' +
                ", approveReject='" + approveReject + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
