package BinarySearchTree.Easy;

// * A new key always inserted at leaf in Binary Search Tree

import BinaryTree.Node;
import BinaryTree.Traversals.DepthFirstTraversal.inOrderTraversal;

import static BinaryTree.Traversals.DepthFirstTraversal.inOrderTraversal.inOrderRecursive;

public class insertionInBST {
    Node root;


    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(35);

        insertionInBST tree = new insertionInBST();

        System.out.print("Before inserting new node : ");
        inOrderRecursive(root);

        tree.insertUsingRec(root, 33);
        System.out.println();

        System.out.print("After inserting new node : ");
        inOrderRecursive(root);
    }

    private Node insertUsingRec(Node root, int insertData) {
        if (root == null) {
            root = new Node(insertData);
        } else if (insertData < root.data) {
            root.left = insertUsingRec(root.left, insertData);
        } else if (insertData > root.data) {
            root.right = insertUsingRec(root.right, insertData);
        }
        return root;
    }


}
