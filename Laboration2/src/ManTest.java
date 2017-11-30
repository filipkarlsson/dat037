import java.util.Comparator;

/**
 * Created by JonathanU on 17/11/14.
 */
public class ManTest {
    public static void main(String[] args) {
        StockTrade stocken = new StockTrade();

        StockTrade st = new StockTrade();
        st.placeBuyBid(new Bid("B0", 5));  // result: null
        st.placeBuyBid(new Bid("B1", 12));  // result: null
        st.placeBuyBid(new Bid("B2", 14));  // result: null
        stocken.placeBuyBid(new Bid("Johan", 0));
        stocken.placeBuyBid(new Bid("Niklas", 2));
        stocken.placeBuyBid(new Bid("Sten", 200));
        stocken.placeBuyBid(new Bid("Arnold", 5));
        stocken.placeBuyBid(new Bid("Sten", 10));
        System.out.println(stocken.toString());

        st.placeSellBid(new Bid("S2", 14));  // result: new Transaction("S2", "B1", 0)



        System.out.println(st);
        stocken.placeSellBid(new Bid("JonathanAB",12));
        System.out.println(stocken.toString());
        stocken.placeSellBid(new Bid("JonathanAB",8));
        System.out.println(stocken);
    }
}
// troll