
package InventoryManager;


public class StockLevelChecker {
    private int currentStockLevel;
    private int reorderLevel;

    // Constructor
    public StockLevelChecker(int currentStockLevel, int reorderLevel) {
        this.currentStockLevel = currentStockLevel;
        this.reorderLevel = reorderLevel;
    }

    // Getter for current stock level
    public int getCurrentStockLevel() {
        return currentStockLevel;
    }

    // Getter for reorder level
    public int getReorderLevel() {
        return reorderLevel;
    }

    // Setter for current stock level
    public void setCurrentStockLevel(int currentStockLevel) {
        this.currentStockLevel = currentStockLevel;
    }

    // Setter for reorder level
    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    // Method to check if stock is below reorder level
    public boolean isStockBelowReorderLevel() {
        return currentStockLevel < reorderLevel;
    }

    // Utility method to display stock status
    public String displayStockStatus() {
        if (isStockBelowReorderLevel()) {
            return "Stock is below reorder level. Current stock: " + currentStockLevel + ", Reorder level: " + reorderLevel;
        } else {
            return "Stock is sufficient. Current stock: " + currentStockLevel + ", Reorder level: " + reorderLevel;
        }
    }
}
