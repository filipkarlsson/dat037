import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by JonathanU on 17/11/30.
 */
public class APrioMap<K, V extends Comparable<? super V>> implements PrioMap{

    private ArrayList<Pair<K,V>> heap;
    private HashMap<K, Integer> map;

    public APrioMap(){
        heap = new ArrayList<>();
        map = new HashMap<>();
    }

    @Override
    public void put(Object o, Comparable comparable) {

    }

    @Override
    public Comparable get(Object o) {
        return null;
    }

    @Override
    public Pair peek() {
        return null;
    }

    @Override
    public Pair poll() {
        return null;
    }
}
