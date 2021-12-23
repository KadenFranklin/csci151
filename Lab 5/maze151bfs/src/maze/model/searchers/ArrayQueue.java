package maze.model.searchers;

import maze.searchers.Queue;

public class ArrayQueue<E> implements Queue<E> {
    private E[] stuff;
    private int front = 0;
    private int back = 0;
    private int size = 0;

    public ArrayQueue() {
        stuff = (E[])(new Object[8]);
    }


    @Override
    public void add(E data) {
        if(size() == stuff.length){
            E[] stuff2 = (E[])(new Object[stuff.length * 2]);
            for(int i =0;i < stuff.length ;i++){
                stuff2[i] = stuff[(front + i) % stuff.length];
            }
            front = 0;
            back = stuff.length;
            stuff = stuff2;
        }
        stuff[back] = data;
        size++;
        back = (back + 1) % stuff.length;
    }

    @Override
    public E remove() {
        emptyCheck();
        E node = stuff[front];
        front = (front + 1) % stuff.length;
        size--;
        return node;
    }

    @Override
    public E element() {
        emptyCheck();
        return stuff[front];
    }

    @Override
    public int size() {return size;}

    @Override
    public int capacity() {return stuff.length;}
}
