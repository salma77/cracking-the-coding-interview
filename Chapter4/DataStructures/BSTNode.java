package Chapter4.DataStructures;

/**
 * Implementation of Binary search tree
 */
public class BSTNode {
    private int data;
    private BSTNode left;
    private BSTNode right;

    // Constructor
    public BSTNode(int data) {
        this.data = data;
    }

    // Getters
    public int getData() {
        return this.data;
    }

    public BSTNode getLeft() {
        return this.left;
    }

    public BSTNode getRight() {
        return this.right;
    }

    // Setters
    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
    /**
     * Function to add a new node to the tree
     * @param current
     * @param value
     * @return
     */
    private BSTNode addRecursive(BSTNode current, BSTNode value) {
        if (current == null) {
            return value;
        }

        if (value.getData() < current.getData()) {
            current.left = addRecursive(current.left, value);
        } else if (value.getData() > current.getData()) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {
        BSTNode root = this;
        BSTNode data = new BSTNode(value);
        root = addRecursive(root, data);
    }

    public void add(BSTNode data) {
        BSTNode root = this;
        root = addRecursive(root, data);
    }

    /**
     * Function to print the data of a node
     */
    public void visit() {
        System.out.println(this.getData());
        return;
    }

}
