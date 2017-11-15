import javax.lang.model.element.Element;
import java.util.ArrayList;

/**
 * Created by filip on 2017-11-02.
 */
public class BinSearchGenSet<E extends Comparable<? super E>> implements GenSet<E>{

    private ArrayList<E> set;

    public BinSearchGenSet() {
        set = new ArrayList<E>(1);
    }

    @Override
    public void remove(E element) {
        set.remove(element);
    }

    @Override
    public void add(E element) {
        int index = binarySearch(element, set); // binarySearch returns index if element is in set, else -(index+1)
        if(index < 0) {         // If element is not in set then birarySearch has returned -(index+1)...
            index = -(index+1); // ... and we must update index
            if (index == set.size()) {
                set.add(element);
            } else if (index >= 0) {
                set.add(index, element);
            }
        }
    }

    @Override
    public boolean contains(E element) {
        //if (set.size() == 0) return false;
        return binarySearch(element, set) >= 0;
    }


    /*
    * Returns index of element in array if it exists.
    * If the element is not in the array the method returns the negative (index + 1) of where it should be in the sorted array.
    * */
    private int binarySearch(E element, ArrayList<E> array){
        int middle = array.size()/2;
        int max = array.size();
        int min = 0;
        int compare;

        // Find out in witch half of "array" "element" is, or would be in.
        while( min != max ){
            compare = element.compareTo(array.get(middle));
            if (compare == 0) {
                return middle;
            } else if (compare > 0) {
                min = middle + 1;
            } else if(compare < 0){
                max = middle;
            }
            middle = (min+max)/2;
        }

        // If element not in array, return -(index+1) where element would be.
        return -(middle+1);
    }


    @Override
    public String toString(){
        String s = "";

        for (E o : set){
            s +=  o.toString() + " ";
        }
        s += set.size();

        return s;
    }

}
