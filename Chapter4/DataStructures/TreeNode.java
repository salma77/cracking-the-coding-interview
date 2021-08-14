package Chapter4.DataStructures;

/**
 * Implementation of a binary tree
 */
public class TreeNode {
    private int data;
    private TreeNode right;
    private TreeNode left;

    public TreeNode(int d) {
        this.data = d;
        left = null;
        right = null;
    }

    // Getters
    public int getData() {
        return this.data;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    // Setters
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * Function that gets the height of a tree
     * 
     * @param root root node of the tree
     * @return
     */
    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int l_height = getHeight(root.getLeft());
        int r_height = getHeight(root.getRight());
        return Math.max(l_height, r_height) + 1;
    }

}
