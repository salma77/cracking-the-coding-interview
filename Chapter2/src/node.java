package Chapter2.src;

import java.util.HashSet;
import java.util.Stack;

public class node {
    node next = null;
    int data;

    public node(int d) {
        data = d;
    }

    public void appendToTail(int d) {
        node end = new node(d);
        node n = this;
        while (n.next != null)
            n = n.next;
        n.next = end;
    }

    public node appendToHead(node head, int d) {
        node start = new node(d);
        start.next = head;
        head = start;
        return head;
    }

    /***
     * Removing duplicates from an unsorted singly linkedlist, Solution 1: Using a
     * hashtable
     * 
     * @param head
     */
    public void removeDup() {
        HashSet<Integer> set = new HashSet<Integer>();
        node prev = null;
        node curr = this;
        while (curr != null) {
            if (set.contains(curr.data))
                prev.next = curr.next;
            else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    /***
     * Removing duplicates from an unsorted singly linkedlist, Solution 2: Using a
     * runner pointer, and no extra buffer
     * 
     * @param head
     */
    public void removeDupNoBuffer() {
        node curr = this;
        while (curr != null) {
            node runner = curr;
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
    }

    /***
     * Returns the Kth node from the end of a singly linked list
     * 
     * @param head
     * @param k
     * @return
     */

    public node KthNode(node head, int k) {
        node slow = head;
        node fast = head; // moves with a pace of k
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

    /***
     * Deletes a node from the middle of a singly linkedlist given access to only
     * the node
     * 
     * @param middle
     */
    public void deleteMiddle(node middle) {
        if (middle.next == null)
            return;
        middle.data = middle.next.data;
        middle.next = middle.next.next;
    }

    /***
     * Partition a linkedlist at a certain node, where elements less than pivot are
     * to the left and those greater than the pivot are to the right, the pivot
     * itself is anywhere in the right partition
     * 
     * @param head
     * @param x
     * @return
     * 
     */
    public node partition(node head, int x) {
        node tail = head;
        node curr = head;
        while (curr != null) {
            node next = curr.next; // prevent getting stuck in the loop, as curr.next will be updated
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

    /*-----------------------------2.5---------------------------------*/

    /***
     * Form a number from a linked list where the head is the units digit
     * 
     * @param head
     * @return
     */
    public int getNumber(node head) {
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
    public node toList(int x) {
        node sum = new node(x % 10);

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

    public node sumLists(node head) {
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

    /***
     * Gets the sum of two numbers arranged in a linkedlist with the following
     * format 7 -> 1 -> 6 -> + -> 5 -> 9 -> 2 equivalent to 617 + 295
     * 
     * @param head1
     * @param head2
     * @param carry
     * @return
     */
    public node sumListsRecursive(node head1, node head2, int carry) {
        if (head1 == null && head2 == null && carry == 0)
            return null;

        int value = carry;

        if (head1 != null)
            value += head1.data;
        if (head2 != null)
            value += head2.data;

        node result = new node(value % 10);
        if (head1 != null || head2 != null) {
            node sum = sumListsRecursive(head1 == null ? null : head1.next, head2 == null ? null : head2.next,
                    value >= 10 ? 1 : 0);
            result.next = sum;
        }
        return result;
    }

    /***
     * To check whether a linkedlist is a palindrome or not
     * 
     * @param head
     * @return
     */
    public boolean isPalindrome(node head) {
        node reverse = null;
        node curr = head;
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

    /***
     * To check whether a linkedlist is a palindrome or not using a stack
     * 
     * @param head
     * @return
     */
    boolean isPalindromeStack(node head) {
        node runner = head;
        node curr = head;
        Stack<Integer> first_half = new Stack<Integer>();

        while (runner != null && runner.next != null) {
            first_half.push(curr.data); // Note: should implement a new node class with Character data type
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
}
