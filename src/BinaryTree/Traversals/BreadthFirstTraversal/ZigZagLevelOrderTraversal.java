package BinaryTree.Traversals.BreadthFirstTraversal;

import BinaryTree.Node;

import java.util.Stack;

// Time complexity - O(n)
// Space complexity - O(n) - Even though two stacks are there bcz no of elements that you are going to stored in the Binary Tree is O(n)
// Space com
//Reverse of data at Even levels
// Need to use two stacks - s1 - insert right first than left , s2 - insert left first than right
public class ZigZagLevelOrderTraversal {
    Node root;
    Stack<Node> stack1 = new Stack<>(); // Push left first to stack2 than right
    Stack<Node> stack2 = new Stack<>(); // Push right first


    private void zigZagOrderIterative(Node root) {
        if (root == null) {
            return;
        }
        stack1.push(root);


        while (stack1.size() > 0 || stack2.size() > 0) {
            while (stack1.size() > 0) {
                Node pop = stack1.pop();
                System.out.println(pop.data);

                // Firstly push left in stack 2
                if (pop.left != null) {
                    stack2.push(pop.left);
                }
                // Than right in stack 2
                if (pop.right != null) {
                    stack2.push(pop.right);
                }
            }
            // now pop from stack 2 when stack 1 is completely empty and start pushing right first than left to stack 1
            while (stack2.size() > 0) {
                Node pop = stack2.pop();
                System.out.println(pop.data);

                if (pop.right != null) {
                    stack1.push(pop.right);
                }
                if (pop.left != null) {
                    stack1.push(pop.left);
                }

            }
        }
    }


    public static void main(String[] args) {
        ZigZagLevelOrderTraversal ZigZagLevelOrderTraversal = new ZigZagLevelOrderTraversal();

        // Inputting Data
        ZigZagLevelOrderTraversal.root = new BinaryTree.Node(1);
        ZigZagLevelOrderTraversal.root.left = new BinaryTree.Node(10);
        ZigZagLevelOrderTraversal.root.right = new BinaryTree.Node(20);
        ZigZagLevelOrderTraversal.root.left.left = new BinaryTree.Node(30);
        ZigZagLevelOrderTraversal.root.left.right = new BinaryTree.Node(40);
        ZigZagLevelOrderTraversal.root.left.right.left = new BinaryTree.Node(70);
        ZigZagLevelOrderTraversal.root.right.left = new BinaryTree.Node(50);
        ZigZagLevelOrderTraversal.root.right.left.left = new BinaryTree.Node(60);

        // Iterative way
        ZigZagLevelOrderTraversal.zigZagOrderIterative(ZigZagLevelOrderTraversal.root);


    }

}
