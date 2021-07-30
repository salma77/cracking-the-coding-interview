package DataStructures;

import java.util.*;

public class Graph<T> {
    private int V;                  // number of vertices
    private LinkedList<T> adj[];    // Adjacency lists

    // Constructor
    Graph(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i] = new LinkedList<T>();
    }
    void addEdge(T v, T w){adj[v] = }
    
}
