package Chapter4.src;

import java.util.*;
import DataStructures.Graph;

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

    public static void testrouteBetween(int node) {
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
        System.out.println(routeBetween(my_graph, 1, 3));
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

    public static void main(String[] args) throws Exception {
        testGraph();
    }
}
