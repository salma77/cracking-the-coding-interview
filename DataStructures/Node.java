package DataStructures;

public class Node {
    private String name;
    private Node left;
    private Node right;

    public String visit(Node x) {
        return x.name;
    }

    public void preOrderTraversal(Node root) {
        if (root != null) {
            visit(root);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            visit(root);
            inOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            visit(root);
        }
    }
}
