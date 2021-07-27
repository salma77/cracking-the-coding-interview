package DataStructures;

import java.util.EmptyStackException;

public class MyStack<X> {
    private static class StackNode<X> {
        private X data;
        private StackNode<X> next;

        public StackNode(X data) {
            this.data = data;
        }
    }

    private StackNode<X> top;

    public X pop() {
        if (top == null)
            throw new EmptyStackException();
        X item = top.data;
        top = top.next;
        return item;
    }

    public void push(X item) {
        StackNode<X> new_top = new StackNode<X>(item);
        new_top.next = top;
        top = new_top;
    }

    public X peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return (top == null);
    }
}
