package Chapter2.src;

import static org.junit.Assert.*;

import org.junit.Test;

import Chapter2.DataStructures.Node;

public class removeDup {

    @Test
    public void testRemoveDup() {
        Node n1 = new Node(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.appendToTail(4);
        n1.appendToTail(3);
        n1.appendToTail(7);
        boolean done = n1.removeDup();
        assertTrue(done);
        while (n1 != null) {
            System.out.println(n1.getData());
            n1 = n1.getNext();
        }
    }

    @Test
    public void testRemoveDupNoBuffer() {
        Node n1 = new Node(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.appendToTail(4);
        n1.appendToTail(3);
        n1.appendToTail(7);
        boolean done = n1.removeDupNoBuffer();
        assertTrue(done);
        while (n1 != null) {
            System.out.println(n1.getData());
            n1 = n1.getNext();
        }
    }

}
