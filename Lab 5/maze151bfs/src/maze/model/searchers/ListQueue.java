package maze.model.searchers;

import maze.searchers.Queue;

public class ListQueue<E> implements Queue<E>{

    private int size = 0;
    private ListNode<E> front ;
    private ListNode<E> back ;

    @Override
    public int size() {return size;}

    @Override
    public int capacity() { return size();}

    @Override
    public E remove() {
        emptyCheck();
        E node = front.getItem();
        front = front.getNext();
        size--;
        return node;
    }

    @Override
    public void add(E item) {
        ListNode<E> node = new ListNode<E>(item, null);
        if(isEmpty()){
            front = node;
        }
        else{
            back.setNext(node);
        }
        back = node;
        size++;
    }

    @Override
    public E element() {
        emptyCheck();
        return front.getItem();
    }
}
