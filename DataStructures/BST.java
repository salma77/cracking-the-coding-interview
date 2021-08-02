package DataStructures;

public class BST {
    private Node root;

    public BST(int data){
        root = new Node(data);
    }

    public Node getRoot(){
        return root;
    }

    public void insert(int x) {
        if (root == null)
            root = new Node(x);
        else if (x < root.getData())
            root.setLeft(new Node(x));
        else if (x > root.getData())
            root.setRight(new Node(x));
    }

    public int getHeight(Node root) {
        if (root == null)
            return 0;
        int l_height = getHeight(root.getLeft());
        int r_height = getHeight(root.getRight());
        return Math.max(l_height, r_height) + 1;
    }

    public boolean checkBalance() {
        if (root == null)
            return true;
        int l_height = getHeight(root.getLeft());
        int r_height = getHeight(root.getRight());

        if (Math.abs(l_height - r_height) > 1)
            return false;

        return root.getLeft().checkBalance && root.getRight().checkBalance;
    }
    
}
