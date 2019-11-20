package HardProblems;

import BinaryTree.Node;
import BinaryTree.Traversals.DepthFirstTraversal.inOrderTraversal;
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

// Great solution of the post order traversal in (right, left, root) order!
// Basically, the traversing order after flattening is pre order traversal in (root, left, right), like
public class FlatteningBinaryTreeToLinkedList {
    Node prev, root;

    public void flatten(Node root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }


    public static void main(String[] args) {
        FlatteningBinaryTreeToLinkedList tree = new FlatteningBinaryTreeToLinkedList();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.right = new Node(6);


        tree.flatten(tree.root);

        new inOrderTraversal().inOrderRecursive(tree.root);
    }


}
