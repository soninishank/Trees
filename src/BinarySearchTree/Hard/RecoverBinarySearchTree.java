package BinarySearchTree.Hard;

import BinaryTree.Node;
import BinaryTree.Traversals.DepthFirstTraversal.preOrderTraversal;

// Two elements of a binary search tree (BST) are swapped by mistake.
//Recover the tree without changing its structure.
// what we are comparing is the current node and its previous node in the "in order traversal".
// https://www.interviewbit.com/problems/recover-binary-search-tree/
public class RecoverBinarySearchTree {
    Node root;

    Node firstElement = null;
    Node secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    Node prevElement = new Node(Integer.MIN_VALUE);


    private void traverse(Node root) {
        // Base condition
        if (root == null) {
            return;
        }
        traverse(root.left);

        // Start of "do some business", 
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.data >= root.data) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.data >= root.data) {
            secondElement = root;
        }
        prevElement = root;

        // End of "do some business"
        traverse(root.right);
    }


    public void recoverTree(Node root) {
        // In order traversal to find the two elements
        traverse(root);

        // Swap the data of the two nodes
        int temp = firstElement.data;
        firstElement.data = secondElement.data;
        secondElement.data = temp;
    }


    public static void main(String[] args) {

        RecoverBinarySearchTree RecoverBinarySearchTree = new RecoverBinarySearchTree();

        // Inputting Data
        RecoverBinarySearchTree.root = new Node(1);
        RecoverBinarySearchTree.root.left = new Node(2);
        RecoverBinarySearchTree.root.right = new Node(3);


        // Normal In Order Traversal
        RecoverBinarySearchTree.recoverTree(RecoverBinarySearchTree.root);


        new preOrderTraversal().preOrderRecursive(RecoverBinarySearchTree.root);


    }

}
