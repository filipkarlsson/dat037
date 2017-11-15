import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Lab 2
 * Created by filip on 2017-11-14.
 */
public class BinHeap<E> implements PrioQueue<E>{

    private ArrayList<E> heap;
    private Comparator<? super E> comp;

    public BinHeap(Comparator<? super E> comp) {
        heap = new ArrayList<>();
        this.comp = comp;
    }


    @Override
    public void add(E e) {
        heap.add(e);
        bubbleUp(heap.size() - 1);
    }

    @Override
    public E peek() {
        if (heap.size() > 0) {
            return heap.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public E poll() {
        if (heap.size() > 0){
            E root = heap.get(0);
            remove(root);
            return root;
        } else {
            return null;
        }
    }

    @Override
    public void remove(E e) {
        int i = heap.indexOf(e);
        if ( (i >= 0) && (heap.size() > 0) ){
            swap(i, heap.size() - 1);
            heap.remove(heap.size() - 1);
            if (heap.size() != i) {
                // Sometimes required to bubbleUp and sometimes to bubbleDown. (Booth not required at any time)
                bubbleDown(i);
                bubbleUp(i);
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return heap.iterator();
    }



    private void bubbleUp(int i){
        if (comp.compare(heap.get(i), heap.get((i-1)/2)) < 0){
            // byt plats
            swap(i,(i-1)/2);
            bubbleUp((i-1)/2);
        }
    }

    private void bubbleDown(int i){
        E leftChild;
        E rightChild;
        if (heap.size() >= 2*i + 3){ // There exists 2 children to the current node
            leftChild = heap.get(2*i + 1);
            rightChild = heap.get(2*i + 2);
            if (comp.compare(rightChild, leftChild) < 0){ // The smallest is two the right
                if (comp.compare(heap.get(i), rightChild) > 0){ // The node is greater than it's right child
                    swap(i, 2*i + 2);
                    bubbleDown(2*i + 2); // Bubble to the right
                }
            } else{
                if (comp.compare(heap.get(i), leftChild) > 0){ // The node is greater than it's left child
                    swap(i, 2*i + 1);
                    bubbleDown(2*i + 1); // Bubble to the left
                }
            }

        } else if (heap.size() >= 2*i + 2) { // There exists one child.
            leftChild = heap.get(2*i + 1);
            if (comp.compare(heap.get(i), leftChild) > 0){ // The node is greater than it's left child
                swap(i, 2*i + 1);
                bubbleDown(2*i + 1); // Bubble to the left
            }
        }


    }

    private void swap(int i, int j){
        E tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j,tmp);
    }

    public String toString(){
        String s = "";
        for (E e : heap){
            s += e.toString();
            s += " ";
        }
        return s;
    }

}
