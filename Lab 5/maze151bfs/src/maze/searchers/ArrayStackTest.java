package maze.searchers;

import maze.model.searchers.ArrayStack;

public class ArrayStackTest extends StackTest {

	@Override
	public Stack<Integer> create() {
		return new ArrayStack<Integer>();
	}

}
