package BinarySearchTree.Easy;

import BinaryTree.Node;

public class countNodesInBST {
    Node root;

    public int countNodes(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.data >= low && root.data <= high) {
            return 1 + countNodes(root.left, low, high) + countNodes(root.right, low, high);
        }
        // Recur in left  child
        else if (root.data < low) {
            return countNodes(root.right, low, high);
        } else {
            return countNodes(root.left, low, high);
        }
    }

    public static void main(String[] args) {
        countNodesInBST tree = new countNodesInBST();

        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(50);
        tree.root.left.left = new Node(1);
        tree.root.right.left = new Node(40);
        tree.root.right.right = new Node(100);
        /* Let us constructed BST shown in above example
          10
        /    \
      5       50
     /       /  \
    1       40   100   */
        int l = 5;
        int h = 45;
        int i = tree.countNodes(tree.root, l, h);
        System.out.println("Count of nodes between [" + l + ", " + h + "] is " + i);
    }
}
