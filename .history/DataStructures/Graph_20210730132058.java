package DataStructures;

import java.util.*;

public class Graph {
    private int nodes; // number of vertices
    private LinkedList<Integer> adj[]; // Adjacency lists

    // Constructor
    Graph(int v) {
        nodes = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }
    //Function to add an edge between nodes v and w
    void addEdge(int v, int w) {
        adj[v].add(w);
    }


}
