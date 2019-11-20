package BinaryTree.Traversals.BreadthFirstTraversal;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversalBinaryTree {
    Node root;

    public void diagonal(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    System.out.println();
                }
            } else {
                while (current != null) {
                    System.out.print(current.data + " ");
                    if (current.left != null) {
                        queue.add(current.left);
                    }
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        DiagonalTraversalBinaryTree diagonalTraversalBinaryTree = new DiagonalTraversalBinaryTree();

        // Inputting Data
        diagonalTraversalBinaryTree.root = new Node(8);
        diagonalTraversalBinaryTree.root.left = new Node(3);
        diagonalTraversalBinaryTree.root.right = new Node(10);
        diagonalTraversalBinaryTree.root.left.left = new Node(1);
        diagonalTraversalBinaryTree.root.right.left = new Node(6);
        diagonalTraversalBinaryTree.root.right.right = new Node(14);
        diagonalTraversalBinaryTree.root.right.left.left = new Node(4);
        diagonalTraversalBinaryTree.root.right.left.right = new Node(7);
        diagonalTraversalBinaryTree.root.right.right.left = new Node(13);


        new DiagonalTraversalBinaryTree().diagonal(diagonalTraversalBinaryTree.root);
    }

}