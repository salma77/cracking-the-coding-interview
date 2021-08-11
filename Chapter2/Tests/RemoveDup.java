package Chapter2.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Chapter2.DataStructures.Node;

public class RemoveDup {

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
        int[] after_remove = { 1, 2, 3, 4, 7 };
        int[] actuals = new int[5];
        int i = 0;
        assertTrue(done);
        while (n1 != null) {
            actuals[i] = n1.getData();
            i++;
            n1 = n1.getNext();
        }
        assertArrayEquals(after_remove, actuals);
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
        int[] after_remove = { 1, 2, 3, 4, 7 };
        int[] actuals = new int[5];
        int i = 0;
        assertTrue(done);
        while (n1 != null) {
            actuals[i] = n1.getData();
            i++;
            n1 = n1.getNext();
        }
        assertArrayEquals(after_remove, actuals);
    }

}
