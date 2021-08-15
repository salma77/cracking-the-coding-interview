package Chapter4.src;

import java.util.*;

import Chapter4.DataStructures.*;

public class TreeHelpers {
    /**
     * Function that gets the height of a tree
     * 
     * @param root root node of the tree
     * @return
     */
    public static int getHeight(BSTNode root) {
        if (root == null)
            return 0;
        int l_height = getHeight(root.getLeft());
        int r_height = getHeight(root.getRight());
        return Math.max(l_height, r_height) + 1;
    }

    /**
     * Function to get the parent of a node
     * 
     * @param root root of the tree
     * @param p    node to find the parent of
     * @return
     */
    public static BSTNode getParent(BSTNode root, BSTNode p) {
        return parentHelper(root, p);
    }

    private static BSTNode parentHelper(BSTNode currentRoot, BSTNode p) {
        if (p == null || currentRoot == null) {
            return null;
        } else {
            if (currentRoot.getLeft() == p || currentRoot.getRight() == p)
                return currentRoot;
            else {
                if (currentRoot.getData() < p.getData()) {
                    return parentHelper(currentRoot.getRight(), p);
                } else {
                    return parentHelper(currentRoot.getLeft(), p);
                }
            }
        }
    }

    /**
     * Function to insert nodes in level order
     * 
     * @param arr  array of nodes data
     * @param root root of the tree
     * @param i    index in the array that we'll start from
     * @return
     */
    public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) {
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            root.setLeft(insertLevelOrder(arr, root.getLeft(), 2 * i + 1));
            root.setRight(insertLevelOrder(arr, root.getRight(), 2 * i + 2));
        }
        return root;
    }

    /**
     * 
     * Function to add a new node to the tree
     * 
     * @param node
     * @param value
     */
    public static void insert(TreeNode node, int value) {
        if (value < node.getData()) {
            if (node.getLeft() != null) {
                insert(node.getLeft(), value);
            } else {
                node.setLeft(new TreeNode(value));
            }
        } else if (value > node.getData()) {
            if (node.getRight() != null) {
                insert(node.getRight(), value);
            } else {
                node.setRight(new TreeNode(value));
            }
        }
    }

    /**
     * Function to return the leftmost child of a sub tree
     * 
     * @param root of the subtree
     * @return
     */
    public static BSTNode leftMostChild(BSTNode root) {
        if (root == null)
            return null;
        while (root != null)
            root = root.getLeft();
        return root;
    }

    /**
     * Function to trace node's path upwards and check if it covers
     * 
     * @param root of the tree
     * @param p    the node to be checked
     * @return
     */
    public static boolean covers(BSTNode root, BSTNode p) {
        if (root == null)
            return false;
        if (root == p)
            return true;
        return covers(root.getLeft(), p) || covers(root.getRight(), p);
    }

    /**
     * Helper function that finds the first common ancestor between two nodes
     * 
     * @param root root of the tree
     * @param p    first node
     * @param q    second node
     * @return
     */
    public static BSTNode ancestorHelper(BSTNode root, BSTNode p, BSTNode q) {
        if (root == null || p == root || q == root)
            return root;
        boolean p_is_on_left = covers(root.getLeft(), p);
        boolean q_is_on_left = covers(root.getLeft(), q);
        if (p_is_on_left != q_is_on_left)
            return root;
        BSTNode child = p_is_on_left ? root.getLeft() : root.getRight();
        return ancestorHelper(child, p, q);
    }

    /**
     * Function to do pre-order traversal for a tree {root-left-right}
     * 
     * @param root root node of the tree
     */
    public static void preOrderTraversal(BSTNode root) {
        if (root != null) {
            root.visit();
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }

    /**
     * Function to do in-order traversal for a tree {left-root-right}
     * 
     * @param root root node of the tree
     */
    public static void inOrderTraversal(BSTNode root) {
        if (root != null) {
            inOrderTraversal(root.getLeft());
            root.visit();
            inOrderTraversal(root.getRight());
        }
    }

    /**
     * Function to do post-order traversal for a tree {left-right-root}
     * 
     * @param root root node of the tree
     */
    public static void postOrderTraversal(BSTNode root) {
        if (root != null) {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            root.visit();
        }
    }

    /**
     * Function to weave lists together in all possible ways. This algorithm works
     * by removing the head from one list, recursing, and then doing the same thing
     * with the other list.
     * 
     * @param first   first list to be weaved
     * @param second  second list to be weaved
     * @param results array of resulted lists
     * @param prefix  prefix to add remainder of the list to
     * @return
     */
    public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
            ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        // One list is empty. Add remainder to [a cloned] prefix and store result.
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
        // Recurse with head of first added to the prefix. Removing the head will damage
        // first, so we'll need to put it back where we found it afterwards.
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        // Do the same thing with second, damaging and then restoring the list.
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);

        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    /**
     * Function to check whether two subtrees have the same nodes
     * 
     * @param subtree1
     * @param subtree2
     * @return
     */
    public static boolean matchTree(TreeNode subtree1, TreeNode subtree2) {
        if (subtree1 == null && subtree2 == null)
            return true;
        else if (subtree1 == null || subtree2 == null)
            return true;
        else if (subtree1.getData() != subtree2.getData())
            return false;
        else
            return matchTree(subtree1.getLeft(), subtree2.getLeft())
                    && matchTree(subtree1.getRight(), subtree2.getRight());
    }

}
