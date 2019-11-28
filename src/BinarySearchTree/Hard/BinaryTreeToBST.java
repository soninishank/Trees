package BinarySearchTree.Hard;

import BinaryTree.Node;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static BinaryTree.Traversals.DepthFirstTraversal.inOrderTraversal.inOrderRecursive;

/*
 * Convert a Binary Tree into BST by maintaining its original structure
 *
 * Traverse the Binary tree and store its data in a treeset. We know that
 * an in-order traversal of a BST returns the node in a sorted order, so we
 * traverse the tree again in in-order fashion and put back the keys present
 * in the set (in sorted order) back to their correct position in BST.
 *
 * The advantage of using Treeset over array is, we no need to sort the Treeset
 * explicitly.
 */

public class BinaryTreeToBST {

    //Method to traverse Binary tree and store its data in a set
    private void extractData(Node root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        extractData(root.left, set);
        set.add(root.data);
        extractData(root.right, set);
    }

    //Method to construct BST by using data from set in in-order fashion
    private void convertToBST(Node root, Iterator<Integer> iterator) {
        if (root == null) {
            return;
        }
        convertToBST(root.left, iterator);
        root.data = iterator.next();
        convertToBST(root.right, iterator);
    }


    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(75);
        root.right = new Node(25);
        root.left.left = new Node(125);
        root.left.right = new Node(100);
        root.right.left = new Node(150);
        root.right.right = new Node(175);

        BinaryTreeToBST tree = new BinaryTreeToBST();
        Set<Integer> set = new TreeSet<>();

        System.out.print("Binary Tree - ");
        inOrderRecursive(root);
        System.out.println();

        System.out.print("Binary Search Tree - ");
        tree.extractData(root, set);
        tree.convertToBST(root, set.iterator());
        inOrderRecursive(root);
    }

}
