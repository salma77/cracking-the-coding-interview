package Chapter4.DataStructures;

import java.util.Random;

/**
 * Implementation if binary tree with function to get a random node
 */
public class RandomTreeNode {
    private int data;
    public RandomTreeNode left;
    public RandomTreeNode right;
    private int size = 0;

    public RandomTreeNode(int d) {
        this.data = d;
        size = 1;
    }

    public int size() {
        return size;
    }

    public int data() {
        return data;
    }

    /**
     * Function to get a random node from the tree
     * 
     * @return
     */
    public RandomTreeNode getRandomNode() {
        int leftSize = left == null ? 0 : left.size();
        Random random = new Random();
        int index = random.nextInt(size);
        if (index < leftSize)
            return left.getRandomNode();
        else if (index == leftSize)
            return this;
        else
            return right.getRandomNode();
    }

    /**
     * Function to insert data into a new node in the tree
     * 
     * @param d data to be inserted
     */
    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null)
                left = new RandomTreeNode(d);
            else
                left.insertInOrder(d);

        } else {
            if (right == null)
                right = new RandomTreeNode(d);
            else
                right.insertInOrder(d);

        }
        size++;
    }

    /**
     * Function to add new node to the tree
     * 
     * @param node node to be added
     */
    public void insertNode(RandomTreeNode node) {
        insertInOrder(node.data());
    }

    /**
     * Function to find a node with certain data in the tree
     * 
     * @param d data to be found
     * @return
     */
    public RandomTreeNode find(int d) {
        if (d == data)
            return this;
        else if (d <= data)
            return left != null ? left.find(d) : null;
        else if (d > data)
            return right != null ? right.find(d) : null;
        return null;
    }
}
