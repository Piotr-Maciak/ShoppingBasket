package ShoppingBasket;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {


        // Adding new items to the stock
        StockItem temp = new StockItem("milk", 1.26, 50);
        stockList.addStock(temp);

        temp = new StockItem("bread", 0.75, 150);
        stockList.addStock(temp);

        temp = new StockItem("egg", 0.12, 500);
        stockList.addStock(temp);

        temp = new StockItem("flour", 0.95, 200);
        stockList.addStock(temp);

        temp = new StockItem("water", 0.50, 400);
        stockList.addStock(temp);

        temp = new StockItem("chocolate", 2.95, 2);
        stockList.addStock(temp);

        temp = new StockItem("juice", 1.75, 100);
        stockList.addStock(temp);

        System.out.println(stockList);


        // Adding items to a new basket
        Basket pBasket = new Basket("Peter");
        sellItem(pBasket, "chocolate", 1);
        sellItem(pBasket, "bread", 2);
        sellItem(pBasket, "fish", 3);
        sellItem(pBasket, "water", 2);
        sellItem(pBasket, "bread", 2);
        System.out.println(pBasket);
        System.out.println(stockList);


    }

    // Method for selling items, if an item is not in stock it returns 0
    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
