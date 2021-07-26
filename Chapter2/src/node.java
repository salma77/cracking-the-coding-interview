package Chapter2.src;

import java.util.HashSet;

public class node {
    node next = null;
    int data;

    public node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        node end = new node(d);
        node n = this;
        while (n.next != null)
            n = n.next;
        n.next = end;
    }

    /***
     * Removing duplicates from an unsorted singly linkedlist, Solution 1: Using a
     * hashtable
     * 
     * @param head
     */
    void removeDup() {
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
    void removeDupNoBuffer() {
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

    node KthNode(node head, int k) {
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
    void deleteMiddle(node middle) {
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
    node partition(node head, int x) {
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
    int getNumber(node head) {
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
    node toList(int x) {
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

    node sumLists(node head) {
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

    /*-----------------------------2.5-Recursion---------------------------------*/
    node sumListsRecursive(node head1, node head2, int carry) {
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
}
