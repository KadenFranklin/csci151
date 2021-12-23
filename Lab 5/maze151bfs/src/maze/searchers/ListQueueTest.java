package maze.searchers;

import maze.model.searchers.ListQueue;

public class ListQueueTest extends QueueTest {

	@Override
	public Queue<Integer> create() {
		return new ListQueue<Integer>();
	}

}
