package Chapter2.src;

import org.junit.Test;

import Chapter2.DataStructures.Node;

public class sumLists {

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
        Node sum = n1.sumLists(n1);

        System.out.println("Function Result: ");
        while (sum != null) {
            System.out.println(sum.getData());
            sum = sum.getNext();
        }
        System.out.println("Actual Result: " + (7777 + 111));
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
        while (n3 != null) {
            System.out.println(n3.getData());
            n3 = n3.getNext();
        }
    }

}
