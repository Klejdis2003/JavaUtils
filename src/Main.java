

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        SortedArrayList<Integer> arr = new SortedArrayList<>();
        long sortedTimeStart = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arr.add(random.nextInt(100));
        }
        long sortedTimeENd = System.currentTimeMillis();
        TreeSet<Integer> arr2 = new TreeSet<>();
        long unsortedTimeStart = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arr2.add(random.nextInt(100000));
        }
        long unsortedTimeENd = System.currentTimeMillis();
//        System.out.printf("Sorted array performance: %d\n", sortedTimeENd - sortedTimeStart);
//        System.out.printf("Unsorted array performance: %d\n", unsortedTimeENd - unsortedTimeStart);
//
//        System.out.println(arr.size());
//        System.out.println(arr2.size());
        System.out.println(arr);
        for (int i = 0; i < 1000 ; i++) {
            int random_index = random.nextInt(arr.size()-1);
            System.out.println(random_index);
            System.out.printf("%d is found at %d\n", arr.get(random_index), arr.search(arr.get(random_index)));
        }
        }
}