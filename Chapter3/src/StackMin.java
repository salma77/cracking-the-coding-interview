package Chapter3.src;

import java.util.EmptyStackException;

/**
 * Implementation of a stack, which in addition to push and pop, has a function
 * min that returns the minimum element in O(1) time
 */
public class StackMin {

    private static class NodeMin {
        private int data;
        private int min;
        private NodeMin next;

        public NodeMin(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }

    private NodeMin top;

    public int getMin() {
        return top.min;
    }

    public int pop() throws EmptyStackException {
        if (top == null)
            throw new EmptyStackException();
        int item = top.data;
        top = top.next;
        return item;
    }

    public void push(int item) {
        int new_min = 0;
        if (top == null)
            new_min = item;
        else
            new_min = (item <= top.min) ? item : top.min;
        NodeMin new_top = new NodeMin(item, new_min);
        new_top.next = top;
        top = new_top;
    }

    public int peek() throws EmptyStackException {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return (top == null);
    }
}
