package Chapter3.DataStructures;

import java.util.EmptyStackException;
/**
 * Implementation of a stack data structure
 */
public class MyStack<X> {
    private static class StackNode<X> {
        private X data;
        private StackNode<X> next;

        public StackNode(X data) {
            this.data = data;
        }
    }

    private StackNode<X> top; // Top element of the stack

    /**
     * Function to remove the top of the stack
     * 
     * @return the top element of the stack
     */
    public X pop() throws EmptyStackException {
        if (top == null)
            throw new EmptyStackException();
        X item = top.data;
        top = top.next;
        return item;
    }

    /**
     * Function to push(add) a new element to the stack
     * 
     * @param item element to be added
     */
    public void push(X item) {
        StackNode<X> new_top = new StackNode<X>(item);
        new_top.next = top;
        top = new_top;
    }

    /**
     * 
     * @return the top of the stack
     */
    public X peek() throws EmptyStackException{
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    /**
     * Function to check whether a stack is empty or not
     * 
     * @return true, if the stack is empty
     */
    public boolean isEmpty() {
        return (top == null);
    }
}
