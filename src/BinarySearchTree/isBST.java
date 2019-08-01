package BinarySearchTree;

import BinaryTree.Node;

import java.util.Stack;

/*  Assume a BST is defined as follows: Validating BST
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.*/
//  inorder traversal of BST is an array sorted in the ascending order.
// root.right.data > root.val
// root.val > root.left.data
public class isBST {
    Node root;
    Stack<Node> stack = new Stack<>();

    public boolean isValidBSTUsingInOrderTraversal(Node root) {
        Node current = root;
        // Base condition you must apply in every Binary Tree Questions
        if (root == null) {
            return true;
        }
        double inOrder = -Double.MAX_VALUE; // Mandatory and it is negative

        while (current != null || stack.size() > 0) {
            while (current != null) // Will be checked until we reached the last node of a left tree
            {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop(); // Most important step have to remember
            if (current.data <= inOrder) {
                return false;
            }
            inOrder = current.data;
            current = current.right;
        }
        return true;
    }

    public static void main(String[] args) {
        isBST isBST = new isBST();

        // Inputting Data
        isBST.root = new Node(4);
        isBST.root.left = new Node(2);
        isBST.root.right = new Node(5);
        isBST.root.left.left = new Node(1);
        isBST.root.left.right = new Node(3);


        // Recursive way
        //   isBST.inOrderRecursive(isBST.root);

        System.out.println();

        // Iterative Pre Order Traversal
        boolean validBSTUsingInOrderTraversal = isBST.isValidBSTUsingInOrderTraversal(isBST.root);
        System.out.println(validBSTUsingInOrderTraversal);


    }


}
