package DataStructures;

public class Node {
    private int data;
    private Node left;
    private Node right;
    public boolean checkBalance;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void insert(int data) {
        Node n = new Node(data);
        if (this.left == null)
            this.right = n;
        else
            this.left = n;
    }

    public void visit() {
        System.out.println(this.getData());
        return;
    }

    public void preOrderTraversal(Node root) {
        if (root != null) {
            root.visit();
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            root.visit();
            inOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            root.visit();
        }
    }
}
