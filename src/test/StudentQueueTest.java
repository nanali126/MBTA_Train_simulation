package test;

import static org.junit.Assert.assertTrue;
import main.Queue;
import main.Rider;

import org.junit.jupiter.api.Test;

class StudentQueueTest {
	Queue<Rider> queue;

	@Test
	void initTest() {
		queue = new Queue<Rider>(10);
		assertTrue(queue.numEntries == 0);
		assertTrue(queue.s == 10);
	}
	
	@Test
	void EnqueueDequeueTest() {
		queue = new Queue<Rider>(10);
		Rider r = new Rider("1", "a", "q");
		queue.enqueue(r);
		assertTrue(queue.front().equals(r));
		assertTrue(queue.numEntries==1);
		queue.dequeue();
		assertTrue(queue.front()==null);
	}

}
