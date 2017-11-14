import java.util.Comparator;

/**
 * Created by JonathanU on 17/11/14.
 */
public class ManTest {
    public static void main(String[] args) {
        Comparator comp = new NaturalOrderComparator();
        BinHeap<Integer> binHeap = new BinHeap(comp);


        binHeap.add(1);
        binHeap.add(2);
        binHeap.add(3);
        binHeap.add(4);
        binHeap.add(5);
        binHeap.add(6);
        binHeap.add(7);
        binHeap.add(8);

        System.out.println(binHeap.toString());
    }
}