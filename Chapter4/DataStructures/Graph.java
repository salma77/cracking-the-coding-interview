package Chapter4.DataStructures;

import java.util.*;

public class Graph {
    private int nodes; // number of vertices
    private LinkedList<Integer> adj[]; // Adjacency lists
    private boolean directed;

    // Constructor
    public Graph(int v, boolean d) {
        nodes = v;
        directed = d;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<Integer>();
    }

    /**
     * Function that adds an edge between two nodes
     * 
     * @param v first node
     * @param w second node
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        if (!directed)
            adj[w].add(v);
    }

    /**
     * Function that gets adjacency list of a node
     * 
     * @param node
     * @return Adjaceny list of the node
     */
    public LinkedList<Integer> getAdj(int node) {
        return adj[node];
    }

    /**
     * Function that gets total number of nodes in a graph
     * 
     * @return number of nodes in a graph
     */
    public int getNodes() {
        return nodes;
    }

    /**
     * Function that does breadth first search on a graph
     * 
     * @param start_node the node from which the search is started
     */
    public void BFS(int start_node) {
        boolean visited[] = new boolean[nodes];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[start_node] = true;
        queue.add(start_node);
        while (!queue.isEmpty()) {
            start_node = queue.poll();
            Iterator<Integer> i = adj[start_node].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    /**
     * Helper function that does the recursive part of Depth first search
     * 
     * @param start_node the node from which the search is started
     * @param visited    array where index indicates node and value indicates
     *                   whether it's visited or not in the search
     */
    public void DFSrecursion(int start_node, boolean visited[]) {
        visited[start_node] = true;
        Iterator<Integer> i = adj[start_node].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSrecursion(n, visited);
        }
    }

    /**
     * Function that does depth first search
     * 
     * @param start_node the node from which the search is started
     */
    public void DFS(int start_node) {
        boolean visited[] = new boolean[nodes];
        visited[start_node] = true;
        DFSrecursion(start_node, visited);
    }

}
