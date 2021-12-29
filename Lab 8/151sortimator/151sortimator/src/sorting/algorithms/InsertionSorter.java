package sorting.algorithms;

import java.util.ArrayList;

public class InsertionSorter<E extends Comparable<E>> extends Sorter<E> {

    @Override
    protected void sortAlgorithm(ArrayList<E> array) {
        for(int i = 1; i < array.size(); i++){
            int j = i;
            while( j > 0 && array.get(j).compareTo(array.get(j - 1)) < 0 ){
                E temp = array.get(j - 1);
                set(array, j - 1, array.get(j));
                set(array, j, temp);
                j--;
            }
        }
    }
}
