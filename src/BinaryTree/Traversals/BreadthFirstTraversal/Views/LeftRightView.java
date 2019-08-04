package BinaryTree.Traversals.BreadthFirstTraversal.Views;

// Basically its an Level Order Traversal
// For Left View - At each level we need first elements
// For right view - At each level we need last elements


// Time complexity - O(n)
//Space complexity - O(n)

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LeftRightView {
    Node root;
    Queue<Node> queue = new LinkedList<>();

    private void rightViewTree(Node root) {
        if (root == null) {
            return;
        }
        queue.add(root);
        while (queue.size() > 0) {
            int count = queue.size();
            while (count > 0) {
                Node remove = queue.poll();
                if (count == 1) {
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
                if (count == queueCount) {
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
        leftRightView.root = new Node(1);
        leftRightView.root.left = new Node(10);
        leftRightView.root.right = new Node(30);
        leftRightView.root.left.left = new Node(40);
        leftRightView.root.right.right = new Node(50);


        // Iterative way
        System.out.println("Right view of a Binary Tree is :");
        leftRightView.rightViewTree(leftRightView.root);


        System.out.println();
        System.out.println("Left view of a Binary Tree is :");


        // Iterative way
        leftRightView.leftViewTree(leftRightView.root);


    }


}
