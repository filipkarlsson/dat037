import java.util.Comparator;

/**
 * Created by JonathanU on 17/11/14.
 */
public class ManTest {
    public static void main(String[] args) {
        StockTrade stocken = new StockTrade();

        stocken.placeBuyBid(new Bid("Johan", 0));
        stocken.placeBuyBid(new Bid("Niklas", 2));
        stocken.placeBuyBid(new Bid("Sten", 200));
        stocken.placeBuyBid(new Bid("Arnold", 5));
        stocken.placeBuyBid(new Bid("Sten", 10));
        System.out.println(stocken.toString());

        stocken.placeSellBid(new Bid("JonathanAB",12));
        System.out.println(stocken.toString());
        stocken.placeSellBid(new Bid("JonathanAB",8));
        System.out.println(stocken);
    }
}
// troll