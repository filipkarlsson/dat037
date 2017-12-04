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
        if (map.containsKey(k)){
            heap.get(map.get(k)).b = v;
            bubbleDown(map.get(k));
            bubbleUp(map.get(k));
        }

        heap.add(new Pair<K, V>(k,v));
        bubbleUp(heap.size() - 1);
    }

    @Override
    public V get(K k) {
        return heap.get(map.get(k)).b;
    }

    @Override
    public Pair<K,V> peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public Pair<K,V> poll() {
        if (heap.isEmpty()) return null;
        Pair<K,V> root = heap.get(0);

        swap(0, heap.size()-1);
        heap.remove(heap.size()-1);
        if (heap.size() != 0){
            bubbleDown(0);
        }
        map.remove(root.a);

        return root;

    }

    private void bubbleUp(int i){
        if (heap.get(i).b.compareTo(heap.get((i-1)/2).b) < 0){
            // byt plats
            swap(i,(i-1)/2);
            bubbleUp((i-1)/2);
        }
    }

    private void bubbleDown(int i){
        V leftChild;
        V rightChild;
        if (heap.size()-1 >= 2*i + 2){ // There exists 2 children to the current node
            leftChild = heap.get(2*i + 1).b;
            rightChild = heap.get(2*i + 2).b;
            if (rightChild.compareTo(leftChild) < 0){ // The smallest is two the right
                if (heap.get(i).b.compareTo(rightChild) > 0){ // The node is greater than it's right child
                    swap(i, 2*i + 2);
                    bubbleDown(2*i + 2); // Bubble to the right
                }
            } else{
                if (heap.get(i).b.compareTo(leftChild) > 0){ // The node is greater or equal to it's left child
                    swap(i, 2*i + 1);
                    bubbleDown(2*i + 1); // Bubble to the left
                }
            }

        } else if (heap.size()-1 >= 2*i + 1) { // There exists one child.
            leftChild = heap.get(2*i + 1).b;
            if (heap.get(i).b.compareTo(leftChild) > 0){ // The node is greater than it's left child
                swap(i, 2*i + 1);
                bubbleDown(2*i + 1); // Bubble to the left
            }
        }
    }

    private void swap(int i, int j){
        Pair<K, V> tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j,tmp);
    }

}
