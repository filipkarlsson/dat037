import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by filip on 2017-11-14.
 */
public class BinHeap<E> implements PrioQueue<E>{

    private ArrayList<E> heap;
    private Comparator<? super E> comp;

    public BinHeap(Comparator<? super E> comp) {
        heap = new ArrayList();
        this.comp = comp;
    }


    @Override
    public void add(E e) {
        heap.add(e);
        bubbleUp(heap.size() - 1);
    }

    @Override
    public E peek() {
        return heap.get(0);
    }

    @Override
    public E poll() {
        E root = heap.get(0);
        heap.remove(root);
        return root;
    }

    @Override
    public void remove(E e) {
        int i = heap.indexOf(e);
        swap(i, heap.size() - 1);
        heap.remove(heap.size() - 1);
        bubbleDown(i);
    }

    @Override
    public Iterator iterator() {
        return heap.iterator();
    }



    private void bubbleUp(int i){
        if (comp.compare(heap.get(i), heap.get((i-1)/2)) < 0){
            // byt plats
            swap(i,(i-2)/2);
            bubbleUp((i-1)/2);
        }
        else {
            return;
        }
    }

    private void bubbleDown(int i){
        if (comp.compare(heap.get(i), heap.get(2*i + 1)) > 0){
            // byt plats
            swap(i, 2*i+1);
            bubbleDown(2*i+1);
        }
        else {
            return;
        }
    }

    private void swap(int i, int j){
        E tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j,tmp);
    }
}
