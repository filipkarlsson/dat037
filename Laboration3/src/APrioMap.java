import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by JonathanU on 17/11/30.
 */
public class APrioMap<K, V extends Comparable<? super V>> implements PrioMap<K,V>{

    private ArrayList<Pair<K,V>> heap;
    private HashMap<K, Integer> map;

    public APrioMap(){
        heap = new ArrayList<>();
        map = new HashMap<>();
    }

    @Override
    public void put(K k, V v) {

    }

    @Override
    public V get(K k) {
        return heap.get(map.get(k)).b;
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
