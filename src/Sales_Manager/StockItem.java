/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sales_Manager;

/**
 *
 * @author Kaushaliya
 */
public class StockItem {
    private String itemId;
    private String itemName;
    private int currentStockLevel;
    private int reorderLevel;
    private String lastUpdatedDate;

    public StockItem(String itemId, String itemName, int currentStockLevel, int reorderLevel, String lastUpdatedDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.currentStockLevel = currentStockLevel;
        this.reorderLevel = reorderLevel;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getCurrentStockLevel() {
        return currentStockLevel;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }
}
