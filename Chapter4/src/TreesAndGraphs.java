package Chapter4.src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

import Chapter4.DataStructures.*;

public class TreesAndGraphs {
    /**
     * Function to check if there's a route between two nodes in a graph using BFS
     * 
     * @param g     graph where the nodes are
     * @param start first node
     * @param end   last node
     * @return true, if a route between the nodes is found
     */
    public static boolean routeBetween(Graph g, int start, int end) {

        boolean visited[] = new boolean[g.getNodes()];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            start = queue.poll();
            Iterator<Integer> i = g.getAdj(start).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return visited[end];
    }

    @Test
    public void testRouteBetween() {
        Graph my_graph = new Graph(6, false);
        // Linked list representation should be
        // 0--> 1-2-5
        // 1--> 0-2-5-4
        // 2--> 0-1-4
        // 3-->
        // 4--> 2-1
        // 5--> 0-1
        my_graph.addEdge(0, 1);
        my_graph.addEdge(0, 2);
        my_graph.addEdge(2, 1);
        my_graph.addEdge(4, 2);
        my_graph.addEdge(0, 5);
        my_graph.addEdge(1, 5);
        my_graph.addEdge(4, 1);
        assertFalse(routeBetween(my_graph, 0, 3));
        assertTrue(routeBetween(my_graph, 1, 2));
        assertTrue(routeBetween(my_graph, 1, 1));
    }

    /**
     * Function to create a BST with minimum height
     * 
     * @param nodes a sorted array of unique values of nodes in the BST
     * @param start start index in the array
     * @param end   final index in the array
     * @return minimum height BST
     */
    public static BSTNode minHeightBST(int nodes[], int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) / 2;
        BSTNode n = new BSTNode(nodes[mid]);
        n.setLeft(minHeightBST(nodes, start, mid - 1));
        n.setRight(minHeightBST(nodes, mid + 1, end));
        return n;
    }

    @Test
    public void testMinHeightBST() {
        // Test case 1: random
        int[] arr = { 1, 5, 8, 12, 16, 21, 23, 24, 32, 37, 41, 55, 67 };
        BSTNode bst = minHeightBST(arr, 0, 12);
        // bst.inOrderTraversal(bst);
        int x = TreeHelpers.getHeight(bst);
        assertEquals(x, 4);
        // Test case 2: 2 numbers only
        int[] arr1 = { 0, 7 };
        BSTNode bst1 = minHeightBST(arr1, 0, 1);
        x = TreeHelpers.getHeight(bst1);
        assertEquals(x, 2);
        // Test case 3: 3 numbers, negative number
        int[] arr2 = { -1, 5, 7 };
        BSTNode bst2 = minHeightBST(arr2, 0, 2);
        x = TreeHelpers.getHeight(bst2);
        assertEquals(x, 2);
        // Test case 4: repeated number
        int[] arr3 = { 1, 5, 8, 8, 8 };
        BSTNode bst3 = minHeightBST(arr3, 0, 4);
        x = TreeHelpers.getHeight(bst3);
        assertEquals(x, 3);
    }

    /**
     * Function that creates an array list of linked lists, where each linked list
     * contains nodes at each depth of a certain tree
     * 
     * @param root root node of a tree
     * @return array list of linked lists of nodes at each depth of the tree
     */
    public static ArrayList<LinkedList<BSTNode>> getDepthList(BSTNode root) {
        ArrayList<LinkedList<BSTNode>> result = new ArrayList<LinkedList<BSTNode>>();
        LinkedList<BSTNode> current = new LinkedList<BSTNode>();
        if (root != null)
            current.add(root);
        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<BSTNode> parents = current;
            current = new LinkedList<BSTNode>();
            for (BSTNode parent : parents) {
                if (parent.getLeft() != null)
                    current.add(parent.getLeft());
                if (parent.getRight() != null)
                    current.add(parent.getRight());
            }
        }
        return result;
    }

    @Test
    public void testGetDepthList() {
        BSTNode root = new BSTNode(5);
        BSTNode left = new BSTNode(26);
        BSTNode right = new BSTNode(44);
        BSTNode left_of_left = new BSTNode(9);
        BSTNode right_of_left = new BSTNode(3);
        BSTNode left_of_right = new BSTNode(66);
        BSTNode right_of_right = new BSTNode(93);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(left_of_left);
        left.setRight(right_of_left);
        right.setLeft(left_of_right);
        right.setRight(right_of_right);

        ArrayList<LinkedList<BSTNode>> actual_list = getDepthList(root);
        ArrayList<LinkedList<BSTNode>> predicted_list = new ArrayList<LinkedList<BSTNode>>();
        LinkedList<BSTNode> temp1 = new LinkedList<BSTNode>();
        temp1.add(root);
        predicted_list.add(temp1);
        LinkedList<BSTNode> temp2 = new LinkedList<BSTNode>();
        temp2.add(left);
        temp2.add(right);
        predicted_list.add(temp2);
        LinkedList<BSTNode> temp3 = new LinkedList<BSTNode>();
        temp3.add(left_of_left);
        temp3.add(right_of_left);
        temp3.add(left_of_right);
        temp3.add(right_of_right);
        predicted_list.add(temp3);
        assertEquals(actual_list, predicted_list);
    }

    /**
     * Function to check whether a tree is a binary search tree
     * 
     * @param root root node of the tree
     * @param min  minimum value of the tree nodes
     * @param max  maximum value of the tree nodes
     * @return
     */
    public boolean isBST(BSTNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        if ((min != null && root.getData() <= min) || (max != null && root.getData() > max))
            return false;
        if (!isBST(root.getLeft(), min, root.getData()) || !isBST(root.getRight(), root.getData(), max))
            return false;
        return true;
    }

    // Something's not right here ------>
    @Test
    public void testIsBST() {
        // Test case 1: binary tree, not BST
        BSTNode root = new BSTNode(5);
        BSTNode left = new BSTNode(26);
        BSTNode right = new BSTNode(44);
        root.setLeft(left);
        root.setRight(right);
        left.setRight(new BSTNode(3));
        left.setLeft(new BSTNode(9));
        right.setLeft(new BSTNode(66));
        right.setRight(new BSTNode(93));
        // assertFalse(isBST(root, 3, 93));
        // Test case 2: balanced BST
        BSTNode bst = new BSTNode(26);
        bst.add(5);
        bst.add(3);
        bst.add(66);
        bst.add(44);
        bst.add(9);
        bst.add(93);
        // assertFalse(isBST(bst, 3, 93));
        TreeHelpers.inOrderTraversal(bst);
        // Test case 3: unbalanced BST
        BSTNode bst2 = new BSTNode(26);
        bst2.add(5);
        bst2.add(3);
        bst2.add(4);
        bst2.add(9);
        bst2.add(6);
        assertFalse(isBST(bst2, 3, 26));
    }

    /**
     * Function to find the "next" node (i.e., in-order successor) of a given node
     * in a binary search tree
     * 
     * @param n
     * @param root
     * @return
     */
    public BSTNode inorderSuccessor(BSTNode n, BSTNode root) {
        if (n == null)
            return null;
        if (n.getRight() != null)
            return TreeHelpers.leftMostChild(n.getRight());
        BSTNode q = n;
        BSTNode x = TreeHelpers.getParent(root, q);
        while (x != null && x.getLeft() != q) {
            q = x;
            x = TreeHelpers.getParent(root, x);
        }
        return x;
    }

    @Test
    public void testInorderSuccessor() {
        BSTNode bst = new BSTNode(26);
        BSTNode test = new BSTNode(32);
        BSTNode inorder_test = new BSTNode(44);
        bst.add(5);
        bst.add(3);
        bst.add(inorder_test);
        bst.add(9);
        bst.add(66);
        bst.add(test);
        assertSame(inorder_test, inorderSuccessor(test, bst));
    }

    /**
     * Function to return the common ancestor between two nodes
     * 
     * @param root root of the tree
     * @param p    first node
     * @param q    second node
     * @return
     */
    public BSTNode commonAncestor(BSTNode root, BSTNode p, BSTNode q) {
        if (!TreeHelpers.covers(root, p) || !TreeHelpers.covers(root, q))
            return null;
        return TreeHelpers.ancestorHelper(root, p, q);
    }

    @Test
    public void testCommonAncestor() {
        BSTNode root = new BSTNode(5);
        BSTNode left = new BSTNode(6);
        BSTNode right = new BSTNode(4);
        root.setLeft(left);
        root.setRight(right);
        BSTNode left_right = new BSTNode(3);
        BSTNode left_left = new BSTNode(9);
        left.setRight(left_right);
        left.setLeft(left_left);
        right.setLeft(new BSTNode(7));
        right.setRight(new BSTNode(8));
        assertSame(left, commonAncestor(root, left_right, left_left));
    }

    /**
     * Function to weave lists together in all possible ways. This algorithm works
     * by removing the head from one list, recursing, and then doing the same thing
     * with the other list.
     * 
     * @param first
     * @param second
     * @param results
     * @param prefix
     */
    public void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
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
     * Function to print all possible arrays that could have led to a given binary
     * search tree with distinct elements.
     * 
     * @param node root of the binary tree
     * @return
     */
    ArrayList<LinkedList<Integer>> allSequences(BSTNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        if (node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.getData());
        // Recurse on left and right subtrees.
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.getLeft());
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.getRight());
        // Weave together each list from the left and right sides.
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    @Test
    public void testAllSequences() {
        BSTNode tree = new BSTNode(2);
        tree.add(1);
        tree.add(3);
        ArrayList<LinkedList<Integer>> expected = new ArrayList<LinkedList<Integer>>();
        LinkedList<Integer> temp1 = new LinkedList<Integer>();
        temp1.add(2);
        temp1.add(1);
        temp1.add(3);
        LinkedList<Integer> temp2 = new LinkedList<Integer>();
        temp2.add(2);
        temp2.add(3);
        temp2.add(1);
        expected.add(temp1);
        expected.add(temp2);
        ArrayList<LinkedList<Integer>> actual = allSequences(tree);
        assertEquals(expected, actual);
    }

    /**
     * Function to check whether tree2 is a subtree of tree1
     * 
     * @param tree1
     * @param tree2
     * @return
     */
    public boolean subTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null)
            return false;
        else if (tree1.getData() == tree2.getData() && TreeHelpers.matchTree(tree1, tree2))
            return true;
        return subTree(tree1.getLeft(), tree2) || subTree(tree1.getRight(), tree2);
    }

    /**
     * Function to check whether tree1 contains tree2
     * 
     * @param tree1
     * @param tree2
     * @return
     */
    public boolean containsTree(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null)
            return true;
        return subTree(tree1, tree2);
    }

    @Test
    public void testContainsTree() {
        TreeNode tree1 = new TreeNode(6);
        int[] nodes1 = { 3, 4, 5, 6, 23, 71, 9, 1, 2, 33, 99, 2, 4, 7, 11, 54, 32, 87, 101, 43, 24 };
        tree1 = TreeHelpers.insertLevelOrder(nodes1, tree1, 0);

        TreeNode tree2 = new TreeNode(6);
        int[] nodes2 = { 3, 4, 5, 6 };
        tree2 = TreeHelpers.insertLevelOrder(nodes2, tree2, 0);
        TreeNode tree3 = new TreeNode(7);
        int[] nodes3 = { 3, 2, 1, 2 };
        tree3 = TreeHelpers.insertLevelOrder(nodes3, tree3, 0);

        assertTrue(containsTree(tree1, tree2));
        assertFalse(containsTree(tree1, tree3));
    }

    @Test
    public void testRandomTreeNode() {
        RandomTreeNode tree = new RandomTreeNode(5);
        tree.insertInOrder(6);
        tree.insertInOrder(7);
        tree.insertInOrder(2);
        tree.insertInOrder(53);
        tree.insertInOrder(42);
        tree.insertInOrder(99);
        RandomTreeNode found = tree.find(53);
        assertEquals(53, found.data());

        int random_node = tree.getRandomNode().data();
        found = tree.find(random_node);
        assertEquals(random_node, found.data());
    }

    /**
     * Function to count paths that lead to a certain sum
     * 
     * @param root
     * @param target_sum
     * @return
     */
    public int countPathsWithSum(TreeNode root, int target_sum) {
        return countPathsWithSum(root, target_sum, 0, new HashMap<Integer, Integer>());
    }

    /**
     * Function to track a running sum and check whether we reached the target
     * 
     * @param node
     * @param target_sum
     * @param running_sum
     * @param path_count
     * @return
     */
    public int countPathsWithSum(TreeNode node, int target_sum, int running_sum, HashMap<Integer, Integer> path_count) {
        if (node == null)
            return 0;
        running_sum += node.getData();
        int sum = running_sum - target_sum;
        int total_paths = path_count.getOrDefault(sum, 0);
        if (running_sum == target_sum)
            total_paths++;
        incrementHashTable(path_count, running_sum, 1);
        total_paths += countPathsWithSum(node.getLeft(), target_sum, running_sum, path_count);
        total_paths += countPathsWithSum(node.getRight(), target_sum, running_sum, path_count);
        incrementHashTable(path_count, running_sum, -1);
        return total_paths;
    }

    /**
     * Function to increment the hashtable used to find the running sum
     * 
     * @param hashtable
     * @param key
     * @param delta
     */
    public void incrementHashTable(HashMap<Integer, Integer> hashtable, int key, int delta) {
        int new_count = hashtable.getOrDefault(key, 0) + delta;
        if (new_count == 0)
            hashtable.remove(key);
        else
            hashtable.put(key, new_count);
    }

    @Test
    public void testCountPathsWithSum() {
        TreeNode root = new TreeNode(6);
        int[] nodes1 = { 3, 4, 5, 1, 23, -1, 24, -2, 7, -22, 1, 1, 5, -24, 3 };
        root = TreeHelpers.insertLevelOrder(nodes1, root, 0);
        int count = countPathsWithSum(root, 8);
        assertEquals(count, 6);
        int[] nodes2 = { -1, -1, -1, -1, -1, -1, -1, -1 };
        root = TreeHelpers.insertLevelOrder(nodes2, root, 0);
        count = countPathsWithSum(root, -3);
        assertEquals(count, 5);
    }
}
