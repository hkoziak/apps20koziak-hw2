package ua.edu.ucu.collections;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QueueTest {

    @Test
    public void testQueuePeekAndEnQueue() {
        Queue queue = new Queue();
        queue.enQueue(13);

        int expected = 13;
        int actual = (int) queue.peekTop();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testQueueDeQueue() {
        Queue queue = new Queue();
        queue.enQueue(13);

        int actual = (int) queue.deQueue();
        int expected = 13;
        assertEquals(actual, expected, 0.00001);
    }

}
