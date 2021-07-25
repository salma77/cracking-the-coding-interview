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
     * Removing duplicates from an unsorted singly linkedlist Solution 1: Using a
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
     * Removing duplicates from an unsorted singly linkedlist Solution 2: Using a
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

    int KthNode(int k) {
        node curr = this;
        while (curr != null) {
            node runner = curr;
            int count = 0;
            while (runner.next != null) {
                count++;
                runner.next = runner.next.next;
            }
            if (count == k)
                break;
        }
        int data2 = curr.data;
        return data2;
    }
}
