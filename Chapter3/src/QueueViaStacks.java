package Chapter3.src;

import java.util.*;

/**
 * Implementation of a queue using 2 stacks
 */
public class QueueViaStacks<T> {

    private Stack<T> front, back;

    public QueueViaStacks() {
        front = new Stack<T>();
        back = new Stack<T>();
    }

    public void enqueue(T item) {
        back.push(item);
    }

    public T dequeue() {
        if (front.isEmpty()) {
            while (!back.isEmpty()) {
                front.push(back.pop());
            }
        }
        return front.pop();
    }

    public boolean isEmpty() {
        return front.isEmpty() && back.isEmpty();
    }
}
