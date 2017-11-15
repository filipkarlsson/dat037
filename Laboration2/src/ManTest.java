import java.util.Comparator;

/**
 * Created by JonathanU on 17/11/14.
 */
public class ManTest {
    public static void main(String[] args) {
        Comparator comp = new NaturalOrderComparator();
        BinHeap<Integer> pq = new BinHeap(comp);

        pq.peek();  // result: null
        System.out.println(pq.toString());
        pq.add(2);
        System.out.println(pq.toString());
        pq.remove(6);
        System.out.println(pq.toString());
        pq.add(3);
        System.out.println(pq.toString());
        pq.iterator();
        System.out.println(pq.toString());
        pq.iterator();
        System.out.println(pq.toString());
        pq.add(6);
        System.out.println(pq.toString());
        pq.remove(6);
        System.out.println(pq.toString());




    }
}
