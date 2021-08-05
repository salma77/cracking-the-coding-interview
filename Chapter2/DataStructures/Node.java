package Chapter2.DataStructures;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    public Node getNext() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.getNext() != null)
            n = n.getNext();
        n.next = end;
    }

    public Node appendToHead(Node head, int d) {
        Node start = new Node(d);
        start.next = head;
        head = start;
        return head;
    }

    public void insert(Node x) {
        Node n = this;
        while (n.next != null)
            n = n.next;
        n.next = x;
    }

    /**
     * Removing duplicates from an unsorted singly linkedlist, Solution 1: Using a
     * hashtable
     * 
     * @param head
     */
    public boolean removeDup() {
        HashSet<Integer> set = new HashSet<Integer>();
        Node prev = null;
        Node curr = this;
        while (curr != null) {
            if (set.contains(curr.data))
                prev.next = curr.next;
            else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
        return true;
    }

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

    /***
     * Removing duplicates from an unsorted singly linkedlist. Solution 2: Using a
     * runner pointer, and no extra buffer
     * 
     * @param head
     */
    public boolean removeDupNoBuffer() {
        Node curr = this;
        while (curr != null) {
            Node runner = curr;
            while (runner.next != null) {
                // curr runner
                // a -> b -> c -> d -> e -> f -> g -> null
                if (curr.data == runner.next.data)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }
            curr = curr.next;
        }
        return true;
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

    /***
     * Returns the Kth Node from the end of a singly linked list
     * 
     * @param head
     * @param k
     * @return
     */

    public Node kthNode(Node head, int k) {
        Node slow = head;
        Node fast = head; // moves with a pace of k
        for (int i = 0; i < k; i++) {
            if (fast == null)
                return null; // NullPointerException thrown
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    @Test
    public void testKthNode() {
        Node n1 = new Node(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(4);
        n1.appendToTail(4);
        n1.appendToTail(3);
        n1.appendToTail(7);
        System.out.println(n1.kthNode(n1, 6).getData());
        assertEquals(n1.kthNode(n1, 6).getData(), 2);
        assertEquals(n1.kthNode(n1, 1).getData(), 7);
    }

    /***
     * Deletes a Node from the middle of a singly linkedlist given access to only
     * the Node
     * 
     * @param middle
     */
    public void deleteMiddle(Node middle) {
        if (middle.next == null)
            return;
        middle.data = middle.next.data;
        middle.next = middle.next.next;
    }

    /***
     * Partition a linkedlist at a certain Node, where elements less than pivot are
     * to the left and those greater than the pivot are to the right, the pivot
     * itself is anywhere in the right partition
     * 
     * @param head the first element of a linked list
     * @param x    the pivot
     * @return
     * 
     */
    public Node partition(Node head, int x) {
        Node tail = head;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next; // prevent getting stuck in the loop, as curr.next will be updated
            if (curr.data < x) {
                curr.next = head;
                head = curr;
            } else if (curr.data >= x) {
                tail.next = curr;
                tail = curr;
            }
            curr = next;
        }
        tail.next = null;
        return head;
    }

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


    /***
     * Form a number from a linked list where the head is the units digit
     * 
     * @param head
     * @return
     */
    public int getNumber(Node head) {
        int i = 0, num = 0;
        while (head != null) {
            if (head.data == '+')
                break;
            num += head.data * Math.pow(10, i);
            i++;
            head = head.next;
        }
        return num;
    }

    /***
     * Converts a number to a linkedlist composed of its digits
     * 
     * @param x
     * @return
     */
    public Node toList(int x) {
        Node sum = new Node(x % 10);

        while (x > 0) {
            x /= 10;

            if (x != 0)
                sum.appendToTail(x % 10);
        }
        return sum;
    }

    /***
     * Gets the sum of two numbers arranged in a linkedlist with the following
     * format 7 -> 1 -> 6 -> + -> 5 -> 9 -> 2 equivalent to 617 + 295
     * 
     * @param head
     * @return
     */

    public Node sumLists(Node head) {
        int sum = 0;
        sum += getNumber(head);

        while (head != null) {
            if (head.data == '+') {
                sum += getNumber(head.next);
                break;
            }
            head = head.next;
        }
        return toList(sum);
    }
    @Test
    public void testSumLists(){
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
    /***
     * Gets the sum of two numbers arranged in a linkedlist with the following
     * format 7 -> 1 -> 6 -> + -> 5 -> 9 -> 2 equivalent to 617 + 295
     * 
     * @param head1
     * @param head2
     * @param carry
     * @return
     */
    public Node sumListsRecursive(Node head1, Node head2, int carry) {
        if (head1 == null && head2 == null && carry == 0)
            return null;

        int value = carry;

        if (head1 != null)
            value += head1.data;
        if (head2 != null)
            value += head2.data;

        Node result = new Node(value % 10);
        if (head1 != null || head2 != null) {
            Node sum = sumListsRecursive(head1 == null ? null : head1.next, head2 == null ? null : head2.next,
                    value >= 10 ? 1 : 0);
            result.next = sum;
        }
        return result;
    }
    @Test
    public void testSumListsRecursive(){
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

    /***
     * To check whether a linkedlist is a palindrome or not
     * 
     * @param head
     * @return
     */
    public boolean isPalindrome(Node head) {
        Node reverse = null;
        Node curr = head;
        boolean flag = true;
        while (curr != null) {
            reverse = appendToHead(reverse, curr.data);
            curr = curr.next;
        }
        while (head != null) {
            if (head.data != reverse.data) {
                flag = false;
                break;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return flag;
    }
    @Test
    public void testIsPalindrome(){
        Node n1 = new Node('a');
        n1.appendToTail('s');
        n1.appendToTail('j');
        n1.appendToTail('s');
        n1.appendToTail('a');
        assertTrue(isPalindrome(n1));
    }

    /***
     * To check whether a linkedlist is a palindrome or not using a stack
     * 
     * @param head
     * @return
     */
    public boolean isPalindromeStack(Node head) {
        Node runner = head;
        Node curr = head;
        Stack<Integer> first_half = new Stack<Integer>();

        while (runner != null && runner.next != null) {
            first_half.push(curr.data); // Note: should implement a new Node class with Character data type
            runner = runner.next.next;
            curr = curr.next;
        }
        // If list length is odd
        if (runner != null)
            curr = curr.next;

        while (!first_half.empty()) {
            if (curr.data != first_half.pop())
                return false;
            curr = curr.next;
        }
        return true;
    }
    @Test
    public void testIsPalindromeStack(){
        Node n1 = new Node('a');
        // n1.appendToTail('s');
        // n1.appendToTail('j');
        // n1.appendToTail('s');
        // n1.appendToTail('a');
        assertTrue(isPalindromeStack(n1));
    }

    /***
     * Find the intersection Node between two linkedlists Complexity: O(n^2)
     * 
     * @param head1
     * @param head2
     * @return
     */

    public Node intersection(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;

        while (curr2 != null) {
            while (curr1 != null) {
                if (curr1 == curr2)
                    return curr1;
                curr1 = curr1.next;
            }
            curr1 = head1;
            curr2 = curr2.next;
        }
        return head1;
    }
    @Test
    public void testIntersection(){
        //Test case 1
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
        //Test case 2
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
    // Didn't figure out how to test this one yet

    public Node findLoopBeginning(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == null)
            return null;
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
