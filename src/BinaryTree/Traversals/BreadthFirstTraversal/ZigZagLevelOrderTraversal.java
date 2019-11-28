package BinaryTree.Traversals.BreadthFirstTraversal;

import BinaryTree.Node;

import java.util.*;

// Time complexity - O(n)
// Space complexity - O(n) - Even though two stacks are there bcz no of elements that you are going to stored in the Binary Tree is O(n)
// Reverse of data at Even levels
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
                System.out.print(pop.data + " ");

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
                System.out.print(" " + pop.data + " ");

                if (pop.right != null) {
                    stack1.push(pop.right);
                }
                if (pop.left != null) {
                    stack1.push(pop.left);
                }

            }
        }
    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        boolean ZigZag = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tempList = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                Node tempNode = queue.poll();
                if (ZigZag) {
                    tempList.add(0, tempNode.data); // Over ride the previous index
                } else {
                    tempList.add(tempNode.data);
                }
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                size--;
            }
            lists.add(tempList);
            ZigZag = !ZigZag; // Change the sign
        }
        return lists;
    }


    public static void main(String[] args) {
        ZigZagLevelOrderTraversal ZigZagLevelOrderTraversal = new ZigZagLevelOrderTraversal();

        // Inputting Data
        ZigZagLevelOrderTraversal.root = new BinaryTree.Node(1);
        ZigZagLevelOrderTraversal.root.left = new BinaryTree.Node(2);
        ZigZagLevelOrderTraversal.root.right = new BinaryTree.Node(3);
        ZigZagLevelOrderTraversal.root.left.left = new BinaryTree.Node(7);
        ZigZagLevelOrderTraversal.root.left.right = new BinaryTree.Node(6);

        ZigZagLevelOrderTraversal.root.left.right.left = new BinaryTree.Node(70);
        ZigZagLevelOrderTraversal.root.right.left = new BinaryTree.Node(50);
        ZigZagLevelOrderTraversal.root.right.left.left = new BinaryTree.Node(60);

        // Iterative way
        ZigZagLevelOrderTraversal.zigZagOrderIterative(ZigZagLevelOrderTraversal.root);

        System.out.println();

        List<List<Integer>> lists = ZigZagLevelOrderTraversal.zigzagLevelOrder(ZigZagLevelOrderTraversal.root);
        System.out.println("List is " + lists);


    }

}
