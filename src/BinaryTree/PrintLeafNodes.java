package BinaryTree;

import java.util.Stack;

public class PrintLeafNodes {

    Node root;

    private void printLeafLeftToRight(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (stack.size() != 0) {
            Node current = stack.pop();
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.left == null && current.right == null) {
                System.out.print(current.data + " ");
            }
        }
    }


    private void printLeafRightToLeft(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (stack.size() != 0) {
            Node current = stack.pop();
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left == null && current.right == null) {
                System.out.print(current.data + " ");
            }
        }
    }

    public static void main(String[] args) {
        PrintLeafNodes printLeafNodes = new PrintLeafNodes();

        // Inputting Data
        printLeafNodes.root = new Node(8);
        printLeafNodes.root.left = new Node(3);
        printLeafNodes.root.right = new Node(10);
        printLeafNodes.root.left.left = new Node(1);
        printLeafNodes.root.right.left = new Node(6);
        printLeafNodes.root.right.right = new Node(14);
        printLeafNodes.root.right.left.left = new Node(4);
        printLeafNodes.root.right.left.right = new Node(7);
        printLeafNodes.root.right.right.left = new Node(13);


        new PrintLeafNodes().printLeafLeftToRight(printLeafNodes.root);

        System.out.println();
        new PrintLeafNodes().printLeafRightToLeft(printLeafNodes.root);
    }

}
