package BinarySearchTree;

import BinaryTree.Node;

import java.util.Stack;

/*  Assume a BST is defined as follows: Validating BST
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.*/
public class isBST {
    Node root;
    Stack<Node> stack = new Stack<>();

    public boolean isValidBST(Node root) {
        // Base case
        if (root == null) {
            return true;
        }
        Node current = root;
        while (current != null || stack.size() > 0) {
            while (current != null) {
                stack.push(root);
                current = current.left;
            }
        }

        return false;
    }


}
