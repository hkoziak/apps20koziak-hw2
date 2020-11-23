package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private Object[] array;
    private int size;

    public ImmutableArrayList() {
        this.size = 0;
        this.array = new Object[0];
    }

    public ImmutableArrayList(Object[] addArray) {
        this.size = addArray.length;
        this.array =  new Object[size];
        System.arraycopy(addArray, 0, array, 0, size);
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return addAll(size, new Object[]{e});
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(this.size, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        checkIndex(index - 1);
        Object[] newArray = new Object[this.size + c.length];
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(this.array, index, newArray, index + c.length,
                this.size - index);
        System.arraycopy(c, 0, newArray, index, c.length);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkIndex(index);
        Object[] newArray = new Object[this.size - 1];
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(this.array, index + 1, newArray, index,
                this.size - index - 1);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        checkIndex(index);
        Object[] newArray = new Object[size];
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int index = 0; index < this.size; index++) {
            if (this.array[index].equals(e)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] output = new Object[size];
        System.arraycopy(this.array, 0, output, 0, this.size);
        return output;
    }

    public String toString() {
        StringBuilder res = new StringBuilder("[");
        if (size > 0) {
            for (int index = 0; index < size; index++) {
                res.append(", ").append(this.array[index].toString());
            }
        }
        res.append("]");
        return res.toString();
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
}
