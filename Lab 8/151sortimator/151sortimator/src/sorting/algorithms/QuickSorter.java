package sorting.algorithms;

import java.util.ArrayList;

public class QuickSorter<E extends Comparable<E>> extends Sorter<E>
{
    @Override
    protected void sortAlgorithm(ArrayList<E> array) {
        quickSortHelper(array,0,array.size());
    }
    private void quickSortHelper(ArrayList<E> array, int start, int end){
        if (end - start > 1){
            int pivot = partition(array,start,end);
            quickSortHelper(array,start,pivot);
            quickSortHelper(array,pivot,end);
        }
    }
    private int partition(ArrayList<E> array,int start,int end){ ;
        E pivotElement = array.get(end - 1);
        int small = start;
        for(int i = start; i < end - 1;i++){
            if (array.get(i).compareTo(pivotElement) <= 0){
                E temp = array.get(small);
                set(array,small,array.get(i));
                set(array,i,temp);
                small++;
            }
        }
        E temp = array.get(small);
        set(array,small,array.get(end - 1));
        set(array,end - 1,temp);
        return small;
    }
}