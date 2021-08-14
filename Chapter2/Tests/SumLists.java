package Chapter2.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Chapter2.DataStructures.Node;

public class SumLists {

    @Test
    public void testSumLists() {
        Node n1 = new Node(7);
        n1.appendToTail(7);
        n1.appendToTail(7);
        n1.appendToTail(7);
        n1.appendToTail('+');
        n1.appendToTail(1);
        n1.appendToTail(1);
        n1.appendToTail(1);
        Node sum = n1.sumLists();
        String test = "";
        while (sum != null) {
            test += sum.getData();
            sum = sum.getNext();
        }
        assertEquals(test, "8887");
    }

    @Test
    public void testSumListsRecursive() {
        Node n1 = new Node(7);
        n1.appendToTail(7);
        n1.appendToTail(7);
        n1.appendToTail(7);
        Node n2 = new Node(1);
        n2.appendToTail(1);
        n2.appendToTail(1);
        Node n3 = n1.sumListsRecursive(n1, n2, 0);
        String test = "";
        while (n3 != null) {
            test += n3.getData();
            n3 = n3.getNext();
        }
        assertEquals(test, "8887");
    }

}
