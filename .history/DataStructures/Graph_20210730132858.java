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
    //Function to do breadth first search
    void BFS(int start){
        boolean visited[]=new boolean[nodes];
        Queue<Integer> queue = new Queue<Integer>();
        queue.add(start);
        while(!queue.isEmpty()){
            
        }
    }
    //Function to do depth first search
    void DFS(int start){

    }

}
