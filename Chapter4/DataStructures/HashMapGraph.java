package Chapter4.DataStructures;

import java.util.*;

/***
 * Implementation of Graph using a Hashmap
 */

class HashMapGraph<T> {

    // Hashmap to store the edges in the graph
    private Map<T, List<T>> map = new HashMap<>();

    /**
     * This function adds a new node to the graph
     * 
     * @param v Node to be added
     */
    public void addNode(T v) {
        map.put(v, new LinkedList<T>());
    }

    /**
     * This function adds the edge between source to destination
     * 
     * @param source        the first node
     * @param destination   the second node
     * @param bidirectional true, if a graph is undirected
     */
    public void addEdge(T source, T destination, boolean bidirectional) {

        if (!map.containsKey(source))
            addNode(source);

        if (!map.containsKey(destination))
            addNode(destination);

        map.get(source).add(destination);
        if (bidirectional == true)
            map.get(destination).add(source);

    }

    /**
     * @return the count of nodes in a graph
     */
    public int getNodeCount() {
        return map.keySet().size();
    }

    /**
     * Function to return the count of edges
     * 
     * @param bidirection true, if a graph is undirected
     * @return
     */
    public int getEdgesCount(boolean bidirection) {
        int count = 0;
        for (T v : map.keySet())
            count += map.get(v).size();

        if (bidirection)
            count = count / 2;

        return count;
    }

    /**
     * Function to check whether a node exists or not
     * 
     * @param v value to check for
     * @return true, if a node is present with that value
     */
    public boolean hasNode(T v) {
        if (map.containsKey(v))
            return true;
        return false;
    }

    /**
     * 
     * Function to check whether an edge exists between two nodes
     * 
     * @param source      the first node
     * @param destination the second node
     * @return true, if an edge between them exists
     */
    public boolean hasEdge(T source, T destination) {
        if (map.get(source).contains(destination))
            return true;
        return false;
    }

    /**
     * Function to return the adjancency list of each node
     * 
     * @return adjancency list of each node
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v))
                builder.append(w.toString() + " ");

            builder.append("\n");
        }

        return (builder.toString());
    }
}