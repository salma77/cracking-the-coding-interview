package Chapter2.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Chapter2.DataStructures.Node;

public class KthNode {
    @Test
    public void testKthNode() {
        Node n1 = new Node(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.appendToTail(4);
        n1.appendToTail(3);
        n1.appendToTail(7);
        assertEquals(n1.kthNode(6).getData(), 2);
        assertEquals(n1.kthNode(1).getData(), 7);
    }
}
