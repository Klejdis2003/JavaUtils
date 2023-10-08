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

    /**
     * Modified implementation of the insertionSort algorithm to work with sorted lists with only
     * one element out of order.
     * <br> <b>Worst Case:</b> O(n), the number is smaller than everything on the list.
     * <br> <b>Average:</b> O(n), has to go through half the list on average.
     * <br> <b>Best:</b> O(1), the added number is larger than the previous one.
     */
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
     * Adds the number at the correct position for the list to remain sorted form smallest to largest.
     * @param number Should match the instance's data type.
     * @return true.
     */
    @Override
    public boolean add(T number){
        super.add(number);
        insertionSort();
        return true;
    }

    /**
     *@return The largest value in the list.
     */
    public T getMaxValue(){
        return get(size()- 1);
    }

    /**
     * @return The smallest value in the list.
     */
    public T getMinValue(){
        return get(0);
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

