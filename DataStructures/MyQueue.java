package DataStructures;

import java.util.NoSuchElementException;

public class MyQueue<X> {
    private static class QueueNode<X> {
        private X data;
        private QueueNode<X> next;

        public QueueNode(X data) {
            this.data = data;
        }
    }

    private QueueNode<X> first, last;

    public void add(X item) {
        QueueNode<X> new_last = new QueueNode<X>(item);
        if (last != null)
            last.next = new_last;
        last = new_last;
        if (first == null)
            first = last;
    }

    public X remove() {
        if (first == null)
            throw new NoSuchElementException();
        if (first.next == null)
            last = null;
        X my_first = first.data;
        first = first.next;
        return my_first;
    }

    public X peek() {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }
    public boolean isEmpty(){
        return (first == null);
    }
}
