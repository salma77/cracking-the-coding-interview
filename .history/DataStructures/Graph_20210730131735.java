package DataStructures;

import java.util.*;

public class Graph<T> {
    private int nodes; // number of vertices
    private LinkedList<T> adj[]; // Adjacency lists

    // Constructor
    Graph(int v) {
        nodes = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<T>();
    }

    void addEdge(T v, T w) {
        adj[v] = 1;
    }

}
