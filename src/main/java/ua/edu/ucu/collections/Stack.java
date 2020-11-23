package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList linkedArray = new ImmutableLinkedList();

    public Stack() {
    }

    public Object peek() {
        return this.linkedArray.getStartValue();
    }

    public Object pop() {
        if (this.linkedArray.size() > 0) {
            Object restOfStack = this.linkedArray.getStartValue();
            this.linkedArray = this.linkedArray.remove(0);
            return restOfStack;
        }
        return null;
    }

    public void push(Object e) {
        this.linkedArray = this.linkedArray.add(0, e);
    }
}