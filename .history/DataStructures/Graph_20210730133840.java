package DataStructures;

import java.util.*;

public class Graph {
    private int nodes; // number of vertices
    private LinkedList<Integer> adj[]; // Adjacency lists
    private boolean directed;

    // Constructor
    Graph(int v, boolean d) {
        nodes = v;
        directed = d;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }

    // Function to add an edge between nodes v and w
    void addEdge(int v, int w) {
        adj[v].add(w);
        if (!directed)
            adj[w].add(v);
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
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }

    //Function to do recursive part in DFS
    void DFSrecursion(int node, boolean visited){
        visited[node]
    }

    // Function to do depth first search
    void DFS(int start) {
        visited[start] = true;

    }

}