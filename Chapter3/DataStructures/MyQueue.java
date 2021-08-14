package Chapter3.DataStructures;

import java.util.NoSuchElementException;

/**
 * Implementation of a queue data structure
 */
public class MyQueue<X> {
    private static class QueueNode<X> {
        private X data;
        private QueueNode<X> next;

        public QueueNode(X data) {
            this.data = data;
        }
    }

    private QueueNode<X> first, last; // First and last elements in the queue

    /**
     * Function to add item to the end of the queue
     * 
     * @param item to be added to the queue
     */
    public void enqueue(X item) {
        QueueNode<X> new_last = new QueueNode<X>(item);
        if (last != null)
            last.next = new_last;
        last = new_last;
        if (first == null)
            first = last;
    }

    /**
     * Function to remove the first item of the queue
     * 
     * @return the removed item
     */
    public X dequeue() throws NoSuchElementException {
        if (first == null)
            throw new NoSuchElementException();
        if (first.next == null)
            last = null;
        X my_first = first.data;
        first = first.next;
        return my_first;
    }

    /**
     * @return the first element in a queue
     */
    public X peek() throws NoSuchElementException {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    /**
     * Function to check whether a queue is empty or not
     * 
     * @return true, if the queue is empty
     */
    public boolean isEmpty() {
        return (first == null);
    }
}
