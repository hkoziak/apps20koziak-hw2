package ua.edu.ucu.collections;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StackTest {
    Stack baseStack = new Stack();

    @Test
    public void testStackPush() {
        baseStack.push(13);
        int actual = (int) baseStack.peek();
        int expected = 13;
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testStackPop() {
        baseStack.push(13);
        baseStack.push(12);
        int actual1 = (int) baseStack.pop();
        int actual2 = (int) baseStack.pop();
        int expected1 = 12;
        int expected2 = 13;
        assertEquals(expected1, actual2, 0.00001);
        assertEquals(expected1, actual2, 0.00001);

    }
}