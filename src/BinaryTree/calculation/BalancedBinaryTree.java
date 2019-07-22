package BinaryTree.calculation;

import BinaryTree.Node;

// TEST IF A BINARY TREE IS HEIGHT-BALANCED
// Given a binary tree, determine if it is height-balanced.
// Every node of left subtree height and right subtree height cannot have an absolute difference of greater than 1
// | leftSubtree - rightSubtree | <= 1
// Empty tree is a balanced tree
// So we need to find the height at each node so at leaf node the height is Max{-1,-1) +1 = 0
// Bottom to up approach
// Time complexity - O(n)
// Space complexity - O(h)
//  boolean subtreesAreBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
//  int height = Math.max(leftResult.height, rightResult.height) + 1;
public class BalancedBinaryTree {
    Node root;

    boolean isBalanced = true;

    public boolean isBalanced(Node root) {
        if (root == null) {
            return isBalanced;
        }
        backtrack(root);
        return isBalanced;
    }

    private int backtrack(Node root) {
        if (root == null) {
            return 0;
        }
        int left = backtrack(root.left);
        int right = backtrack(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);


        boolean balanced = tree.isBalanced(tree.root);
        System.out.println(balanced);

    }


}
