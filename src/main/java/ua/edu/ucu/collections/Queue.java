package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedArray = new ImmutableLinkedList();

    public Queue() {
    }

    public Object deQueue() {
        if (this.linkedArray.size() > 0) {
            Object restOfQueue = this.linkedArray.getStartValue();
            this.linkedArray = this.linkedArray.remove(0);
            return restOfQueue;
        }
        return null;
    }

    public void enQueue(Object e) {
        this.linkedArray = this.linkedArray.add(e);
    }

    public Object peekTop() {
        return linkedArray.getStartValue();
    }
}