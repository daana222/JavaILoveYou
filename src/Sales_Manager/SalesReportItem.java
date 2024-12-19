/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sales_Manager;

/**
 *
 * @author Kaushaliya
 */
public class SalesReportItem {
    private String date;
    private String itemId;
    private String itemName;
    private int quantitySold;
    private double sellingPricePerUnit;
    private double totalSales;

    // Constructor
    public SalesReportItem(String date, String itemId, String itemName, int quantitySold, double sellingPricePerUnit, double totalSales) {
        this.date = date;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantitySold = quantitySold;
        this.sellingPricePerUnit = sellingPricePerUnit;
        this.totalSales = totalSales;
    }

    // Getters
    public String getDate() {
        return date;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public double getSellingPricePerUnit() {
        return sellingPricePerUnit;
    }

    public double getTotalSales() {
        return totalSales;
    }
}
