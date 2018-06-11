package ShoppingBasket;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    // Add an item to the stock
    public int addStock (StockItem item) {
        //Checking if there is already an item like this, if true adjust the quantity of it
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(),item);
            if(inStock != item) {
                item.adjustStock((inStock.quantityInStock()));
            }

            list.put(item.getName(), item);
            return item.quantityInStock();

        }
        return 0;
    }

    // This method sells an item, if there is enough of it in stock
    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);

        if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity >0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    // Returns an item
    public StockItem get(String key) {
        return list.get(key);
    }

    // Returns list of items
    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            s = s + itemValue + "\n";
            totalCost += itemValue;

        }
        return s + "Total stock value " + totalCost;

    }
}
