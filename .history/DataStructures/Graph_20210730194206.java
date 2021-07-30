package DataStructures;

import java.util.*;

public class Graph {
    private int nodes; // number of vertices
    private LinkedList<Integer> adj[]; // Adjacency lists
    private boolean directed;

    // Constructor
    public Graph(int v, boolean d) {
        nodes = v;
        directed = d;
        adj = new LinkedList<Integer> [v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<Integer>();
    }

    // Function to add an edge between nodes v and w
    public void addEdge(int v, int w) {
        adj[v].add(w);
        if (!directed)
            adj[w].add(v);
    }

    public LinkedList<Integer> getAdj(int node) {
        return adj[node];
    }

    public int getNodes() {
        return nodes;
    }

    // Function to do breadth first search
    void BFS(int start) {
        boolean visited[] = new boolean[nodes];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            start = queue.poll();
            Iterator<Integer> i = adj[start].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Function to do recursive part in DFS
    void DFSrecursion(int node, boolean visited[]) {
        visited[node] = true;
        Iterator<Integer> i = adj[node].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSrecursion(n, visited);
        }
    }

    // Function to do depth first search
    void DFS(int start) {
        boolean visited[] = new boolean[nodes];
        visited[start] = true;
        DFSrecursion(start, visited);
    }

}
