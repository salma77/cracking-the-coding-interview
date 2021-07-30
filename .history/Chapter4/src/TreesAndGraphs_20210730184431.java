package Chapter4.src;

import java.util.*;
import DataStructures.Graph;

public class TreesAndGraphs {
    public boolean routeBetween() {

        return true;
    }

    public static void testGraph(int node) {
        Graph my_graph = new Graph(6, false);
        // Linked list representation should be
        // 0--> 1->2->5
        // 1--> 0->2->3->5->4
        // 2--> 0->1->3->4
        // 3--> 1->2
        // 4--> 1->2
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
        Iterator<Integer> i = my_graph.getAdj(node).listIterator();
        while (i.hasNext())
            System.out.println(i.next().intValue());
    }

    public static void main(String[] args) throws Exception {
        testGraph();
    }
}
