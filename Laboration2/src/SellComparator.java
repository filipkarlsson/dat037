import java.util.Comparator;

/**
 * Created by JonathanU on 17/11/20.
 */
public class SellComparator implements Comparator<Bid> {

    public SellComparator() {
    }

    @Override
    public int compare(Bid o1, Bid o2) {
        return o1.price - o2.price;     // returns positive integer if o2 > o1 (prioritize lower o1)
    }
}
