package BinaryTree.Traversals.BreadthFirstTraversal.Views;

// Basically its an Level Order Traversal
// For Left View - At each level we need first elements
// For right view - At each level we need last elements


// Time complexity - O(n)
// Space complexity - O(n)

// https://www.geeksforgeeks.org/print-left-view-binary-tree/
// https://www.geeksforgeeks.org/print-right-view-binary-tree-2/

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LeftRightView {
    Node root;
    Queue<Node> queue = new LinkedList<>();

    // We need only one node at each levels and when you create levels that node is a first location
    private void leftViewTree(Node root) {
        if (root == null) {
            return;
        }
        queue.add(root);
        while (queue.size() > 0) {
            int count = queue.size();
            int queueCount = queue.size();

            while (count > 0) {
                Node remove = queue.poll();
                if (count == queueCount)  // Only Difference
                {
                    System.out.println(remove.data);
                }
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
                count--;
            }
        }
    }

    // When the count is equal to 1 print that node
    private void rightViewTree(Node root) {
        if (root == null) {
            return;
        }
        queue.add(root);
        while (queue.size() > 0) {
            int count = queue.size();
            while (count > 0) {
                Node remove = queue.poll();
                if (count == 1)  // Only difference
                {
                    System.out.println(remove.data);
                }
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
                count--;
            }
        }
    }


    public static void main(String[] args) {
        LeftRightView leftRightView = new LeftRightView();


        // Inputting Data
        leftRightView.root = new Node(4);
        leftRightView.root.left = new Node(5);
        leftRightView.root.right = new Node(2);

        leftRightView.root.right.left = new Node(3);
        leftRightView.root.right.right = new Node(1);


        leftRightView.root.right.left.left = new Node(6);
        leftRightView.root.right.left.right = new Node(7);


        // Iterative way
        System.out.println("Right view of a Binary Tree is :");
        leftRightView.rightViewTree(leftRightView.root);


        System.out.println();
        System.out.println("Left view of a Binary Tree is :");


        // Iterative way
        leftRightView.leftViewTree(leftRightView.root);


    }


}
