package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Node start;
    private Node end;
    private int size;

    public ImmutableLinkedList() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public ImmutableLinkedList(Object[] elements) {
        for (Object element : elements) {
            Node newNode = new Node(element, null);
            if (this.size == 0) {
                this.start = newNode;
            } else {
                this.end.setNext(newNode);
            }
            ++size;
            this.end = newNode;
        }
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        Object[] newArray = new Object[this.size + 1];
        newArray[this.size] = e;
        Object[] currentArray = this.toArray();
        if (!this.isEmpty()) {
            System.arraycopy(currentArray, 0, newArray, 0, this.size);
        }
        return new ImmutableLinkedList(newArray);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(this.size, c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        checkIndex(index - 1);
        Object[] newArray = new Object[this.size + c.length];
        Object[] currentArray = this.toArray();
        System.arraycopy(currentArray, 0, newArray, 0, index);
        System.arraycopy(currentArray, index, newArray, index + c.length,
                this.size - index);
        System.arraycopy(c, 0, newArray, index, c.length);
        return new ImmutableLinkedList(newArray);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        Node currentNode = this.start;
        for (int i = 0; i < index; ++i) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        Object[] newArray = new Object[this.size - 1];
        Object[] currentArr = this.toArray();
        System.arraycopy(currentArr, 0, newArray, 0, index);
        System.arraycopy(currentArr, index + 1, newArray, index,
                this.size - index - 1);
        return new ImmutableLinkedList(newArray);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        checkIndex(index);
        Object[] currentArr = this.toArray();
        currentArr[index] = e;
        return new ImmutableLinkedList(currentArr);
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node currentNode = this.start;
        while (index < this.size) {
            if (currentNode.getValue().equals(e)) {
                return index;
            }
            currentNode = currentNode.getNext();
            ++index;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        if (this.size > 0) {
            Node current = this.start;
            for (int i = 0; i < size; ++i) {
                array[i] = current.getValue();
                current = current.getNext();
            }
        }
        return array;
    }

    private void checkIndex(int index) {
        if ((index >= size) || (index < 0)) {
            throw new IndexOutOfBoundsException();
        }
    }

//Added additional methods for Queue and Stack
    public Object getStartValue() {
        if (!this.isEmpty()) {
            return this.start.getValue();
        }
        return null;
    }

    public Object getEndValue() {
        if (!this.isEmpty()) {
            return this.end.getValue();
        }
        return null;
    }
}
