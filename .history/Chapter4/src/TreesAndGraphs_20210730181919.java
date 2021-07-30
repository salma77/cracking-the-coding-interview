package Chapter4.src;

import DataStructures.Graph;

public class TreesAndGraphs {
    public boolean routeBetween(){
        return true;
    }
    public static void testrouteBetween(){
        Graph my_graph = new Graph(6,false);
        //0->1-
        my_graph.addEdge(0,1);
        my_graph.addEdge(0,2);
        my_graph.addEdge(2,1);
        my_graph.addEdge(3,1);
        my_graph.addEdge(4,2);
        my_graph.addEdge(0,5);
        my_graph.addEdge(1,5);
        my_graph.addEdge(3,2);
        my_graph.addEdge(4,1);
    }
    public static void main(String[] args) throws Exception {
        
    }
}
