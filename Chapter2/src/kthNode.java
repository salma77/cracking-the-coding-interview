package Chapter2.src;

import static org.junit.Assert.*;

import org.junit.Test;

import Chapter2.DataStructures.Node;

public class kthNode {
    @Test
    public void testKthNode() {
        Node n1 = new Node(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.appendToTail(4);
        n1.appendToTail(3);
        n1.appendToTail(7);
        assertEquals(n1.kthNode(n1, 6).getData(), 2);
        assertEquals(n1.kthNode(n1, 1).getData(), 7);
    }
}
