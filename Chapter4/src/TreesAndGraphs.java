package Chapter4.src;

import java.util.*;

import DataStructures.Graph;
import DataStructures.Node;

public class TreesAndGraphs {
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

    public static Node minBST(int nodes[], int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) / 2;
        Node n = new Node(nodes[mid]);
        n.setLeft(minBST(nodes, start, mid - 1));
        n.setRight(minBST(nodes, mid + 1, end));
        return n;
    }

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

    public static boolean isBST(Node root, Integer min, Integer max) {
        if (root == null)
            return true;
        if ((min != null && root.getData() <= min) || (max != null && root.getData() > max))
            return false;
        if (!isBST(root.getLeft(), min, root.getData()) || !isBST(root.getRight(), root.getData(), max))
            return false;
        return true;
    }

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

    public static void testrouteBetween() {
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

    public static void testminBST() {
        int[] arr = { 1, 5, 8, 12, 16, 21, 23, 24, 32, 37, 41, 55, 67 };
        Node bst = minBST(arr, 0, 12);
        bst.inOrderTraversal(bst);
    }

    public static void main(String[] args) throws Exception {
        // testGraph();
        // testrouteBetween();
        // testminBST();
    }
}
