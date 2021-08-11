package Chapter2.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Chapter2.DataStructures.Node;

public class Intersection {

    @Test
    public void testIntersection() {
        // Test case 1
        Node common = new Node(777);
        assertNotNull(common);
        Node n1 = new Node(5);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.insert(common);
        n1.appendToTail(8);
        Node n2 = new Node(1);
        n2.appendToTail(3);
        n2.appendToTail(7);
        n2.appendToTail(9);
        n2.appendToTail(22);
        n2.appendToTail(27);
        n2.appendToTail(31);
        n2.insert(common);
        n2.appendToTail(2);
        n2.appendToTail(6);
        assertSame(common, n1.intersection(n1, n2));
        // Test case 2
        Node n3 = new Node(44);
        n3.appendToTail(3);
        n3.appendToTail(2);
        n3.appendToTail(6);

        Node n4 = n3;
        n4.appendToTail(3);
        n4.appendToTail(4);
        n4.appendToTail(7);
        n4.appendToTail(22);
        n4.appendToTail(9);
        n4.appendToTail(1);
        n4.appendToTail(8);

        assertSame(n3, n4.intersection(n4, n3));
    }
}
