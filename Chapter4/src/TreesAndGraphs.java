package Chapter4.src;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import Chapter4.DataStructures.Node;
import Chapter4.DataStructures.BST;
import Chapter4.DataStructures.Graph;

public class TreesAndGraphs {
    /**
     * Function to check if there's a route between two nodes in a graph using BFS
     * 
     * @param g     graph where the nodes are
     * @param start first node
     * @param end   last node
     * @return true, if a route between the nodes is found
     */
    public static boolean routeBetween(Graph g, int start, int end) {

        boolean visited[] = new boolean[g.getNodes()];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            start = queue.poll();
            Iterator<Integer> i = g.getAdj(start).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return visited[end];
    }

    @Test
    public void testRouteBetween() {
        Graph my_graph = new Graph(6, false);
        // Linked list representation should be
        // 0--> 1-2-5
        // 1--> 0-2-5-4
        // 2--> 0-1-4
        // 3-->
        // 4--> 2-1
        // 5--> 0-1
        my_graph.addEdge(0, 1);
        my_graph.addEdge(0, 2);
        my_graph.addEdge(2, 1);
        my_graph.addEdge(4, 2);
        my_graph.addEdge(0, 5);
        my_graph.addEdge(1, 5);
        my_graph.addEdge(4, 1);
        assertFalse(routeBetween(my_graph, 0, 3));
        assertTrue(routeBetween(my_graph, 1, 2));
        assertTrue(routeBetween(my_graph, 1, 1));
    }

    /**
     * Function to create a BST with minimum height
     * 
     * @param nodes a sorted array of unique values of nodes in the BST
     * @param start start index in the array
     * @param end   final index in the array
     * @return minimum height BST
     */
    public static Node minBST(int nodes[], int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) / 2;
        Node n = new Node(nodes[mid]);
        n.setLeft(minBST(nodes, start, mid - 1));
        n.setRight(minBST(nodes, mid + 1, end));
        return n;
    }

    @Test
    public void testMinBST() {
        // Test case 1: random
        int[] arr = { 1, 5, 8, 12, 16, 21, 23, 24, 32, 37, 41, 55, 67 };
        Node bst = minBST(arr, 0, 12);
        // bst.inOrderTraversal(bst);
        int x = getHeight(bst);
        assertEquals(x, 4);
        // Test case 2: 2 numbers only
        int[] arr1 = { 0, 7 };
        Node bst1 = minBST(arr1, 0, 1);
        x = getHeight(bst1);
        assertEquals(x, 2);
        // Test case 3: 3 numbers, negative number
        int[] arr2 = { -1, 5, 7 };
        Node bst2 = minBST(arr2, 0, 2);
        x = getHeight(bst2);
        assertEquals(x, 2);
        // Test case 4: repeated number
        int[] arr3 = { 1, 5, 8, 8, 8 };
        Node bst3 = minBST(arr3, 0, 4);
        x = getHeight(bst3);
        assertEquals(x, 3);
    }

    /**
     * Function that creates an array list of linked lists, where each linked list
     * contains nodes at each depth of a certain tree
     * 
     * @param root root node of a tree
     * @return array list of linked lists of nodes at each depth of the tree
     */
    public static ArrayList<LinkedList<Node>> getDepthList(Node root) {
        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
        LinkedList<Node> current = new LinkedList<Node>();
        if (root != null)
            current.add(root);
        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<Node>();
            for (Node parent : parents) {
                if (parent.getLeft() != null)
                    current.add(parent.getLeft());
                if (parent.getRight() != null)
                    current.add(parent.getRight());
            }
        }
        return result;
    }

    @Test
    public void testGetDepthList() {
        Node root = new Node(5);
        Node left = new Node(26);
        Node right = new Node(44);
        root.setLeft(left);
        root.setRight(right);
        left.setRight(new Node(3));
        left.setLeft(new Node(9));
        right.setLeft(new Node(66));
        right.setRight(new Node(93));
        ArrayList<LinkedList<Node>> test_list = getDepthList(root);
        for (int i = 0; i < test_list.size(); i++) {
            LinkedList<Node> curr = test_list.get(i);
            Iterator<Node> it = curr.listIterator();
            while (it.hasNext()) {
                // assertEquals(it.getData(), );=
            }
        }
    }

    /**
     * Function to check whether a tree is a binary search tree
     * 
     * @param root root node of the tree
     * @param min  minimum value of the tree nodes
     * @param max  maximum value of the tree nodes
     * @return
     */
    public boolean isBST(Node root, Integer min, Integer max) {
        if (root == null)
            return true;
        if ((min != null && root.getData() <= min) || (max != null && root.getData() > max))
            return false;
        if (!isBST(root.getLeft(), min, root.getData()) || !isBST(root.getRight(), root.getData(), max))
            return false;
        return true;
    }

    @Test
    public void testIsBST() {
        // Test case 1: binary tree, not BST
        Node root = new Node(5);
        Node left = new Node(26);
        Node right = new Node(44);
        root.setLeft(left);
        root.setRight(right);
        left.setRight(new Node(3));
        left.setLeft(new Node(9));
        right.setLeft(new Node(66));
        right.setRight(new Node(93));
        assertFalse(isBST(root, 3, 93));
        // Test case 2: balanced BST
        BST bst = new BST(26);
        bst.insert(5);
        bst.insert(3);
        bst.insert(44);
        bst.insert(9);
        bst.insert(66);
        bst.insert(93);
        assertTrue(isBST(bst.getRoot(), 3, 93));
        // Test case 3: unbalanced BST
        BST bst2 = new BST(26);
        bst2.insert(5);
        bst2.insert(3);
        bst2.insert(4);
        bst2.insert(9);
        bst2.insert(6);
        bst2.insert(93);
        assertTrue(isBST(bst2.getRoot(), 3, 93));
    }

    /**
     * Function that gets the height of a tree
     * 
     * @param root root node of the tree
     * @return
     */
    public static int getHeight(Node root) {
        if (root == null)
            return 0;
        int l_height = getHeight(root.getLeft());
        int r_height = getHeight(root.getRight());
        return Math.max(l_height, r_height) + 1;
    }

    @Test
    public void testGraph() {
        Graph my_graph = new Graph(6, false);
        // Linked list representation should be
        // 0--> 1->2->5
        // 1--> 0->2->3->5->4
        // 2--> 0->1->3->4
        // 3--> 1->2
        // 4--> 2->1
        // 5--> 0->1
        my_graph.addEdge(0, 1);
        my_graph.addEdge(0, 2);
        my_graph.addEdge(2, 1);
        my_graph.addEdge(3, 1);
        my_graph.addEdge(4, 2);
        my_graph.addEdge(0, 5);
        my_graph.addEdge(1, 5);
        my_graph.addEdge(3, 2);
        my_graph.addEdge(4, 1);
        for (int j = 0; j < 6; j++) {
            Iterator<Integer> i = my_graph.getAdj(j).listIterator();
            while (i.hasNext())
                System.out.println(i.next().intValue());
            System.out.println("Done =)");
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
