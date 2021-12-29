package sorting.algorithms;

import java.util.ArrayList;
import java.util.ArrayDeque;

public class MergeSorter<E extends Comparable<E>> extends Sorter<E> {

    @Override
    protected void sortAlgorithm(ArrayList<E> array) {
        mergeSortHelper(array, 0, array.size());
    }

    private void mergeSortHelper(ArrayList<E> array, int start, int end){
        if(end - start > 1){
            int midPoint = (end + start) / 2;
            mergeSortHelper(array, start, midPoint);
            mergeSortHelper(array, midPoint, end);
            merge(array, start, end);
        }
    }

    private void merge(ArrayList<E> array, int start, int end){
        ArrayDeque<E> d1 = new ArrayDeque<>();
        ArrayDeque<E> d2 = new ArrayDeque<>();
        int midPoint = (end + start) / 2;

        for(int i = start; i < midPoint; i++){
            d1.add(array.get(i));
        }
        for(int i = midPoint; i < end; i++){
            d2.add(array.get(i));
        }
        for (int i = start; i < end; i ++ ){
            if (d2.isEmpty() || ( (!d1.isEmpty()) && (d1.element().compareTo(d2.element()) <= 0) )) {
                E temp = d1.element();
                d1.remove();
                set(array, i, temp);
            }
            else {
                E temp = d2.element();
                d2.remove();
                set(array, i, temp);
            }
        }
    }
}