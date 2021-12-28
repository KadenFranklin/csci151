package maze.searchers;

import java.util.ArrayList;
import java.util.Comparator;

public class MinHeap<E> implements Searcher<E> {
    private ArrayList<E> stuff;
    private Comparator<E> comparator;

    public MinHeap(Comparator<E> comparator) {
        stuff = new ArrayList<>();
        this.comparator = comparator;
    }

    public int size() {
        return stuff.size();
    }

    public int capacity() {
        return stuff.size();
    }

    // Exists only for unit testing purposes.
    void backdoorAdd(E value) {
        stuff.add(value);
    }

    // Exists only for unit testing purposes.
    E get(int i) {
        return stuff.get(i);
    }

    static int parent(int i) { return (i - 1) / 2; }

    static int left(int i) { return (2 * i) + 1; }

    static int right(int i) { return (2 * i) + 2; }

    boolean legal(int i) {
        if( (i >= 0) && (i < stuff.size() ) ){
            return true;
        }
        return false;
    }

    boolean isHeap() {
       for (int i = 0; i < stuff.size(); i++) {
           if (legal(left(i)) && comparator.compare(stuff.get(i), stuff.get(left (i))) >= 0){
                return false;
           }else if (legal(right(i)) && comparator.compare(stuff.get(i), stuff.get(right (i))) >= 0) {
                return false;
           }
       }
       return true;
    }

    void swap(int i, int j) {
        E tempVarI = stuff.get(i);
        E tempVarJ = stuff.get(j);
        stuff.set(i, tempVarJ);
        stuff.set(j, tempVarI);
    }

    public E element() {
        return stuff.get(0);
    }
    // * Your solution can be simplified by using the swap() and parent() methods.

    public void add(E data) {
        stuff.add(data);
        int i = stuff.size() - 1 ;
        while (comparator.compare(data, stuff.get(parent(i))) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    int indexOfLowestInFamily(int parent) {
        int a = 0;
        if ( legal(left(parent)) && comparator.compare(stuff.get(left(parent)), stuff.get(parent)) < 0) {
            a = left(parent);
        }else{
            a = parent;
        }
        if ( legal(right(parent)) && comparator.compare(stuff.get(right(parent)), stuff.get(a)) < 0) {
            a = right(parent);
        }
        return a;
    }


    public E remove() {
        emptyCheck();
        swap(0, stuff.size() - 1);
        E tempVar = stuff.get(stuff.size() - 1);
        stuff.remove(stuff.size() - 1);
        int location = 0;
        while( indexOfLowestInFamily(location) != location ) {
            int indexVar = indexOfLowestInFamily(location);
            swap(location, indexVar);
            location = indexVar;
        }
        return tempVar;
    }
}
