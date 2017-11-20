import java.util.Comparator;

/**
 * Created by JonathanU on 17/11/20.
 */
public class BuyComparator implements Comparator<Bid> {

    public BuyComparator() {
    }

    @Override
    public int compare(Bid o1, Bid o2) {
        return o2.price - o1.price;     // returns positive integer if o1 > o2 (prioritize higher o1)
    }
}
