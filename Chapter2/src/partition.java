package Chapter2.src;

import org.junit.Test;

import Chapter2.DataStructures.Node;

public class partition {

    @Test
    public void testPartition() {
        Node n1 = new Node(2);
        n1.appendToTail(3);
        n1.appendToTail(9);
        n1.appendToTail(1);
        n1.appendToTail(5);
        n1.appendToTail(3);
        n1.appendToTail(7);
        n1 = n1.partition(n1, 5);
        while (n1 != null) {
            System.out.println(n1.getData());
            n1 = n1.getNext();
        }
    }
}
