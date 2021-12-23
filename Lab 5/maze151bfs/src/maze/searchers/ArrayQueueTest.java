package maze.searchers;

import maze.model.searchers.ArrayQueue;

public class ArrayQueueTest extends QueueTest {

	@Override
	public Queue<Integer> create() {
		return new ArrayQueue<Integer>();
	}

}
