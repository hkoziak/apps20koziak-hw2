package ua.edu.ucu.collections.immutable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class Node {
    private Object value = null;
    private Node next = null;

    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }
}
