package BinarySearchTree.Hard;

import BinaryTree.Node;
import BinaryTree.Traversals.DepthFirstTraversal.preOrderTraversal;

// Two elements of a binary search tree (BST) are swapped by mistake.
//Recover the tree without changing its structure.
// what we are comparing is the current node and its previous node in the "in order traversal".
// https://www.interviewbit.com/problems/recover-binary-search-tree/
// https://www.youtube.com/watch?v=LR3K5XAWV5k
// https://www.ideserve.co.in/learn/how-to-recover-a-binary-search-tree-if-two-nodes-are-swapped
// https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
public class RecoverBinarySearchTree
{
    Node root;

    Node firstElement = null;
    Node lastElement = null;
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
        if (prevElement != null) {
            if (prevElement.data > root.data) {
                if (firstElement == null) {
                    firstElement = prevElement;
                }
                lastElement = root;
            }
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
        firstElement.data = lastElement.data;
        lastElement.data = temp;
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
