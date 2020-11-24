package ua.edu.ucu.collections;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QueueTest {
    public Queue baseQueue = new Queue();

    @Test
    public void testQueuePeekAndEnQueue() {
        baseQueue.enQueue(13);
        int expected = 13;
        int actual = (int) baseQueue.peekTop();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testQueueDeQueue() {
        baseQueue.enQueue(13);
        int actual = (int) baseQueue.deQueue();
        int expected = 13;
        assertEquals(actual, expected, 0.00001);
    }

}
