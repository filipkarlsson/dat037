import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by filip on 2017-11-01.
 */
public class BinSearchIntSet implements IntSet {
    private int[] set;
    private int nrOfElements;

    public BinSearchIntSet(){
        nrOfElements = 0;
        set = new int[0];
    }

    public void add(int element){
        if (!this.contains(element)){
            int[] oldSet = new int[set.length]; //set;
            for (int i = 0; i<set.length; i++){
                oldSet[i]=set[i];
            }

            // increase the size of set
            if (nrOfElements == set.length) {
                set = new int[set.length + 1];
            }

            int i = 0;

            // add old set to new set until it is time to add "element"
            while ( (i < nrOfElements) && (oldSet[i] < element) ){
                set[i] = oldSet[i];
                i++;
            }

            // add "element"
            set[i] = element;
            nrOfElements++;
            i++;

            // add the rest of old set to new set
            for (; i<nrOfElements;i++){
                set[i] = oldSet[i-1];
            }
        }
    }

    public boolean contains(int element){
       return binarySearch(element,set) != -1;
    }

    public void remove(int element){
        int index = binarySearch(element, set);
        if (index != -1){
            for (int i = index+1; i < set.length; i++){
                set[i-1] = set[i];
            }
            nrOfElements--;
        }
    }


    private int binarySearch(int element, int[] array){
        int middle = nrOfElements/2;
        int max = nrOfElements;
        int min = 0;

        // Find out in witch half of "array" "element" is, or would be in.
        while( min != max ){
            if (element == array[middle]) {
                return middle;
            } else if (element > array[middle]) {
                min = middle + 1;
            } else {
                max = middle;
            }

            middle = (min+max)/2;
        }
        return -1;
    }

    @Override
    public String toString(){
        String returner = "";
        for (int i : set){
            returner += i + " ";
        }
        returner += "Number of elements: " + nrOfElements;
     return returner;
    }
}