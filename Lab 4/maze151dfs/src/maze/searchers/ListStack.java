package maze.searchers;

import java.util.List;

public class ListStack<E> implements Stack<E> {

    private ListNode<E> top;

    @Override
    public void push(E data) {
        ListNode<E> temp = new ListNode<E>(data);
        temp.setNext(top);
        top = temp;
    }

    @Override
    public E pop() {
        emptyCheck();
        ListNode<E> a = top;
        top = top.getNext();
        return a.getValue();
    }

    @Override
    public E peek() {
        emptyCheck();
        return top.getValue();
    }

    @Override
    public int size() {
        int count = 0;
        if(top == null){
            return 0;
        }else {
            ListNode<E>temp = top;
            while(temp != null){
                count++;
                temp = temp.getNext();
            }
        }return count;
    }

    @Override
    public String toString() {
        String s = "";
        ListNode<E> temp = top;
        for (int i = 0; i < size(); i++){
            s =(temp.getValue()) + s;
            s =(" ") + s;
            temp = temp.getNext();
        }
        return s;
    }

    @Override
    public int capacity() {
        return size();
    }

}
