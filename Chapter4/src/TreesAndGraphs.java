package Chapter4.src;

import java.util.*;

import org.junit.Test;

import Chapter4.DataStructures.Node;
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

    /**
     * Function to check whether a tree is a binary search tree
     * 
     * @param root root node of the tree
     * @param min  minimum value of the tree nodes
     * @param max  maximum value of the tree nodes
     * @return
     */
    public static boolean isBST(Node root, Integer min, Integer max) {
        if (root == null)
            return true;
        if ((min != null && root.getData() <= min) || (max != null && root.getData() > max))
            return false;
        if (!isBST(root.getLeft(), min, root.getData()) || !isBST(root.getRight(), root.getData(), max))
            return false;
        return true;
    }

    @Test
    public static void testGraph() {
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

    public static void testRouteBetween() {
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
        System.out.println(routeBetween(my_graph, 0, 3));
        System.out.println(routeBetween(my_graph, 1, 2));
    }

    public static void testMinBST() {
        int[] arr = { 1, 5, 8, 12, 16, 21, 23, 24, 32, 37, 41, 55, 67 };
        Node bst = minBST(arr, 0, 12);
        bst.inOrderTraversal(bst);
    }

    public static void testGetDepthList() {

    }

    public static void testIsBST() {

    }

    public static void main(String[] args) throws Exception {
        // testGraph();
        // testRouteBetween();
        // testMinBST();
    }
}
