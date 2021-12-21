package maze.searchers;

public class ArrayStack<E> implements Stack<E> {

	private int top;
	private E[] stuff;

	public ArrayStack() {
		this(8);
	}

	public ArrayStack(int initialSize) {
		// THIS METHOD IS CORRECT, DO NOT TOUCH
		stuff = (E[])(new Object[initialSize]);
		top = 0;
	}

	@Override
	public void push(E e) {
		if (top == stuff.length) {
			int newStuff = top * 2;
			E[] newArray = (E[]) (new Object[newStuff]);
			for (int i = 0; i < top; i++) {
				newArray[i] = stuff[i];
			}
			stuff = newArray;
		}
		stuff[top] = e;
		top++;
	}

	@Override
	public E pop() {
		emptyCheck();
		top --;
		return stuff[top];
	}

	@Override
	public E peek() {
		emptyCheck();
		return stuff[top - 1] ;
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < top; i++){
			s += (stuff[i]);
			s += (" ");
		}
		return s;
	}

	@Override
	public int capacity() {
		return stuff.length;
	}
}
