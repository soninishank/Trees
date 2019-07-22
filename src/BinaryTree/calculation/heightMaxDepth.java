package BinaryTree.calculation;

import BinaryTree.Node;

// Used in levelOrderTraversal
//Height of Tree = No of edges in longest path from root to leaf node
// Height of tree = Height of root
// Height = Max(LeftSubtree, RightSubtree ) + 1 ( Connecting the root node to subtree )
// Time complexity O(n)
//Space complexity
public class heightMaxDepth {
    Node root;


    public int heightRecursiveWay(Node root) {
        // Base case - Exit condition
        if (root == null) {
            return 0; // some persons return -1
        } else {
            int leftDepth = heightRecursiveWay(root.left);
            int rightDepth = heightRecursiveWay(root.right);
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }

    public static void main(String[] args) {

        heightMaxDepth heightMaxDepth = new heightMaxDepth();
        heightMaxDepth.root = new Node(1);
        heightMaxDepth.root.left = new Node(2);
        heightMaxDepth.root.right = new Node(3);
        heightMaxDepth.root.left.left = new Node(4);
        heightMaxDepth.root.left.right = new Node(5);
        int height = heightMaxDepth.heightRecursiveWay(heightMaxDepth.root);
        System.out.println("Height or Max Depth of a binary tree is " + height);
    }

}
