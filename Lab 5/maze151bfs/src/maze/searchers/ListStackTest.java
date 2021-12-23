package maze.searchers;

import maze.model.searchers.ListStack;

public class ListStackTest extends StackTest {

	@Override
	public Stack<Integer> create() {
		return new ListStack<Integer>();
	}

}
