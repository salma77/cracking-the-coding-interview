package Chapter4.DataStructures;

/**
 * Implementation of Binary tree
 */
public class Node {
    private int data;
    private Node left;
    private Node right;
    private boolean check_balance;

    // Constructor
    public Node(int data) {
        this.data = data;
    }

    // Getters
    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public boolean getBalance() {
        return check_balance;
    }

    // Setters
    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Function to insert a new node in the tree
     * 
     * @param data value of the node to be added
     */
    public void insert(int data) {
        Node n = new Node(data);
        if (this.left == null)
            this.right = n;
        else
            this.left = n;
    }

    /**
     * Function to print the data of a node
     */
    public void visit() {
        System.out.println(this.getData());
        return;
    }

    /**
     * Function to do pre-order traversal for a tree {root-left-right}
     * 
     * @param root root node of the tree
     */
    public void preOrderTraversal(Node root) {
        if (root != null) {
            root.visit();
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /**
     * Function to do in-order traversal for a tree {left-root-right}
     * 
     * @param root root node of the tree
     */
    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            root.visit();
            inOrderTraversal(root.right);
        }
    }

    /**
     * Function to do post-order traversal for a tree {left-right-root}
     * 
     * @param root root node of the tree
     */
    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            root.visit();
        }
    }
}
