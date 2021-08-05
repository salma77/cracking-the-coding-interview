package Chapter4.DataStructures;

public class BST {
    private Node root;

    // Constructor
    public BST(int data) {
        root = new Node(data);
    }

    /**
     * 
     * @return the root of the binary search tree
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Function to insert a node in a BST
     * 
     * @param x integer value to be inserted
     */
    public void insert(int x) {
        if (root == null)
            root = new Node(x);
        else if (x < root.getData())
            root.setLeft(new Node(x));
        else if (x > root.getData())
            root.setRight(new Node(x));
    }

    /**
     * Function to get height of a BST
     * 
     * @param root root of the BST
     * @return height of the tree
     */
    public int getHeight(Node root) {
        if (root == null)
            return 0;
        int l_height = getHeight(root.getLeft());
        int r_height = getHeight(root.getRight());
        return Math.max(l_height, r_height) + 1;
    }

    /**
     * Function to check whether a BST is balanced or not
     * 
     * @return true, if a tree is balanced
     */
    public boolean checkBalance() {
        if (root == null)
            return true;
        int l_height = getHeight(root.getLeft());
        int r_height = getHeight(root.getRight());

        if (Math.abs(l_height - r_height) > 1)
            return false;

        return root.getLeft().getBalance() && root.getRight().getBalance();
    }

}
