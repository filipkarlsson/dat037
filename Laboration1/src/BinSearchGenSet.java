import java.util.ArrayList;

/**
 * Created by filip on 2017-11-02.
 */
public class BinSearchGenSet<E extends Comparable<? super E>> implements GenSet<E>{

    private ArrayList<E> set;

    public BinSearchGenSet() {
        set = new ArrayList<E>();
    }

    @Override
    public void remove(E element) {
        set.remove(element);
    }

    @Override
    public void add(E element) {

    }

    @Override
    public boolean contains(E element) {

    }


    /*
    * Returns index of element,
    *
    * */
    private int binarySearch(E element, ArrayList<E> array){
        int middle = array.size()/2;
        int max = array.size();
        int min = 0;
        int compare = 0;
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
        return -middle;
    }

}