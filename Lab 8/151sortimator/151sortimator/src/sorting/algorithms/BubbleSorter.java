package sorting.algorithms;

import java.util.ArrayList;

public class BubbleSorter<E extends Comparable<E>> extends Sorter<E> {

    @Override
    protected void sortAlgorithm(ArrayList<E> array) {
        for(int i = 0; i < array.size() - 1; i++){
            for(int j = 0;  j < array.size() - 1 - i; j++){
                if (array.get(j).compareTo(array.get(j + 1)) > 0){
                    E temp = array.get(j);
                    set(array, j, array.get(j + 1));
                    set(array, j + 1, temp);
                }
            }
        }
    }
}
