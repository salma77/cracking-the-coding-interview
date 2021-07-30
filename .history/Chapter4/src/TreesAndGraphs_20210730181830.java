package Chapter4.src;

import DataStructures.Graph;

public class TreesAndGraphs {
    public boolean routeBetween(){
        return true;
    }
    public static void testrouteBetween(){
        Graph my_graph = new Graph(6,false);
        my_graph.addEdge(0,1);
        my_graph.addEdge(0,2);
        my_graph.addEdge(2,1);
        my_graph.addEdge(0,1);
        my_graph.addEdge(0,1);
        my_graph.addEdge(0,1);
    }
    public static void main(String[] args) throws Exception {
        
    }
}
