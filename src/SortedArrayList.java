import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * An ArrayList that is always sorted. Each time a
 * number is added, it uses a modified version of
 * insertion sort to sort it.<br>The best case for
 * adding a number to the SortedArrayList instance
 * is O(1) and that is the case when it is larger
 * than the number before it.
 * <br> Average and worst case are both O(n).
 * @param <T> Any type that extends the Number class.
 */
public class SortedArrayList<T extends Number> extends ArrayList<T> {
    SortedArrayList(){
        super();
    }
    @Override
    public boolean add(T number){
        super.add(number);
        insertionSort();
        return true;
    }
    public T getMaxValue(){
        return get(size()- 1);
    }
    public T getMinValue(){
        return get(0);
    }
    private void insertionSort(){
        if(size() == 0)
            return;

        int pivot_index = size() - 1;
        T pivot = get(pivot_index);
        int j;
        for(j = pivot_index-1; j >= 0 && get(j).doubleValue() > pivot.doubleValue(); j--){
            set(j+1, get(j));

        }
        set(j+1, pivot);
    }

    /**
     * Uses binary search to find the passed number in the list.
     * @param number Any class instance that extends the Number class.
     * @return If the number is present in the list, it returns its
     * index. Otherwise, returns -1.
     */
    public int search(T number){
        int start = 0;
        int end = size() - 1;
        int middle;
        while(start <= end){
            middle = start + (end - start) / 2;
            if(get(middle).doubleValue() == number.doubleValue())
                return middle;
            else if(number.doubleValue() > get(middle). doubleValue())
                start = middle + 1;
            else if (number.doubleValue() < get(middle).doubleValue())
                end = middle-1;
        }
        return -1;
    }

}

