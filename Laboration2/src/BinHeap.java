import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by filip on 2017-11-14.
 */
public class BinHeap<E> implements PrioQueue{

    private ArrayList<E> heap;
    private Comparator<? super E> comp;

    public BinHeap(Comparator<? super E> comp) {
        heap = new ArrayList();
        this.comp = comp;
    }

    public void add(E o) {
        heap.add(o);

        int i = heap.size()-1;
        comp.compare(o, heap.get((i-1)/2));

    }

    @Override
    public E peek() {
        return heap.get(0);
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public void remove(E o) {
        int i = heap.indexOf(E);


    }

    @Override
    public Iterator iterator() {
        return null;
    }


    private void bubbleUp(int i){
        if (comp.compare(heap.get(i), heap.get((i-1)/2)) < 0){
            // byt plats
            E tmp = heap.get(i);
            heap.set(i, heap.get((i-1)/2));
            heap.set((i-1)/2,tmp);
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
