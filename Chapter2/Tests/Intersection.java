package Chapter2.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Chapter2.DataStructures.Node;

public class Intersection {

    @Test
    public void testIntersection() {
        // Test case 1
        Node common = new Node(777);
        assertNotNull(common);
        Node node1 = new Node(5);
        node1.appendToTail(3);
        node1.appendToTail(4);
        node1.insert(common);
        node1.appendToTail(8);
        Node node2 = new Node(1);
        node2.appendToTail(3);
        node2.appendToTail(7);
        node2.appendToTail(9);
        node2.appendToTail(22);
        node2.appendToTail(27);
        node2.appendToTail(31);
        node2.insert(common);
        node2.appendToTail(2);
        node2.appendToTail(6);
        assertSame(common, node1.intersection(node1, node2));
        // Test case 2
        Node node3 = new Node(44);
        node3.appendToTail(3);
        node3.appendToTail(2);
        node3.appendToTail(6);

        Node node4 = node3;
        node4.appendToTail(3);
        node4.appendToTail(4);
        node4.appendToTail(7);
        node4.appendToTail(22);
        node4.appendToTail(9);
        node4.appendToTail(1);
        node4.appendToTail(8);

        assertSame(node3, node4.intersection(node4, node3));
    }
}
