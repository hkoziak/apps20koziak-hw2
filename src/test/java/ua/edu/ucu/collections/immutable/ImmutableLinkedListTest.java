package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    public Object[] startArray = {20, 19, 18, 58, 42, 0, 1};
    public Object[] extraArray = {13, 12, 88};
    public int startSize = 7;
    public ImmutableLinkedList baseArray = new ImmutableLinkedList(startArray);

    @Test
    public void testConstructFromArr() {
        ImmutableLinkedList newArray = new ImmutableLinkedList(startArray);
        int expected = 1;
        int actual = (Integer) newArray.get(startSize - 1);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayAddValue() {
        ImmutableLinkedList newArray = baseArray.add(88);
        int expected = 88;
        int actual = (Integer) newArray.getEndValue();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayAddValueOnIndex() {
        ImmutableLinkedList newArray = baseArray.add(startSize - 2,88);
        int expected = 88;
        int actual = (Integer) newArray.get(startSize - 2);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayAddAllValuesOnPosition() {
        ImmutableLinkedList newArray = baseArray.addAll(1, extraArray);
        int expected = 13;
        int actual = (Integer)newArray.get(1);
        assertEquals(expected, actual, 0.00001);

        expected = 88;
        actual = (Integer)newArray.get(3);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayAddAllValuesWithoutPosition() {
        ImmutableLinkedList newArray = baseArray.addAll(extraArray);

        int expected = 13;
        int actual = (Integer)newArray.get(startSize);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayGetValue() {
        int expected = 19;
        Integer actual = (Integer) baseArray.get(1);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayRemoveValue() {
        ImmutableLinkedList newArray = baseArray.remove(1);
        int expected = 18;
        Integer actual = (Integer) newArray.get(1);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArraySetValue() {
        ImmutableLinkedList newArray = baseArray.set(startSize - 1, 77);
        int expected = 77;
        Integer actual = (Integer) newArray.get(startSize - 1);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArrayIndexOfValue() {
        int expected = startSize - 1;
        int actual = baseArray.indexOf(1);
        assertEquals(expected, actual, 0.00001);
        expected = -1;
        actual = baseArray.indexOf(14654640);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testArraySize() {
        int actual = baseArray.size();
        assertEquals(startSize, actual, 0.00001);
    }

    @Test
    public void testArrayIfClear() {
        boolean actual = baseArray.clear().isEmpty();
        assertTrue(actual);
    }

    @Test
    public void testArrayIfEmpty() {
        boolean actual = baseArray.clear().isEmpty();
        assertTrue(actual);
    }

    @Test
    public void testConvertToArray() {
        Object[] newArray = baseArray.toArray();
        assertArrayEquals(startArray, newArray);
    }
}