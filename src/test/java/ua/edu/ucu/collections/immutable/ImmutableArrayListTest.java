package ua.edu.ucu.collections.immutable;
import org.junit.Test;
import static org.junit.Assert.*;


public class ImmutableArrayListTest {
    public Object[] startArray = {20, 19, 18, 58, 42, 0, 1};
    public Object[] extraArray = {13, 12, 88};
    public int startSize = 7; 
    public ImmutableArrayList baseArray = new ImmutableArrayList(startArray);

    @Test
    public void testConstructFromArr() {
        ImmutableArrayList array = new ImmutableArrayList(startArray);
        int expected = 1;
        int actual = (Integer)array.get(startSize - 1);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayAddValue() {
        ImmutableArrayList newArray = baseArray.add(8);
        int expected = 8;
        int actual = (Integer)newArray.get(startSize);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayAddValueOnPosition() {
        ImmutableArrayList newArray = baseArray.add(0, 21);
        int expected = 21;
        int actual = (Integer)newArray.get(0);
        assertEquals(expected, actual, 0.00001);

        // now lets insert in the middle
        newArray = baseArray.add(3, 17);
        expected = 17;
        actual = (Integer)newArray.get(3);
        assertEquals(expected, actual, 0.00001);

        expected = 18;
        actual = (Integer)newArray.get(2);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayAddAllValuesOnPosition() {
        ImmutableArrayList newArray = baseArray.addAll(1, extraArray);

        int expected = 13;
        int actual = (Integer)newArray.get(1);
        assertEquals(expected, actual, 0.00001);

        expected = 88;
        actual = (Integer)newArray.get(3);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayAddAllValuesWithoutPosition() {
        ImmutableArrayList newArray = baseArray.addAll(extraArray);

        int expected = 13;
        int actual = (Integer)newArray.get(startSize);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayGetValue() {
        int expected = 1;
        Integer actual = (Integer)baseArray.get(startSize - 1);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayRemoveValue() {
        ImmutableArrayList newArray = baseArray.remove(startSize - 1);
        int expected = 0;
        Integer actual = (Integer) newArray.get(0);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArraySetValue() {
        ImmutableArrayList newArray = baseArray.set(0, 1);
        int expected = 1;
        Integer actual = (Integer)newArray.get(1);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testIndexOf() {
        int expected = startSize - 1;
        int actual = baseArray.indexOf(1);
        assertEquals(expected, actual, 0.00001);

        expected = -1;
        actual = baseArray.indexOf(846893210);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testSize() {
        int expected = startSize;
        int actual = baseArray.size();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testClear() {
        ImmutableArrayList newArray = baseArray.clear();
        boolean actual = newArray.isEmpty();
        assertTrue(actual);
    }

    @Test
    public void testIsEmpty() {
        ImmutableArrayList NewArray = new ImmutableArrayList();
        boolean actualResult = NewArray.isEmpty();
        assertTrue(actualResult);
    }

    @Test
    public void testToArray() {
        Object[] newArray = baseArray.toArray();
        assertArrayEquals(startArray, newArray);
    }
}