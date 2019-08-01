package BinarySearchTree;

import BinaryTree.Node;

import java.util.*;

public class secondMinimum {
    Node root;

    public int findSecondMinimumValue(Node root) {
        Stack<Node> stack = new Stack<>();
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            set.add(root.data);
            root = root.right;
        }
        list.addAll(set);
        if (list.size() > 1) {
            return list.get(1);
        }
        return -1;
    }


    public static void main(String[] args) {
        secondMinimum secondMinimum = new secondMinimum();

        // Inputting Data
        secondMinimum.root = new Node(2);
        secondMinimum.root.left = new Node(2);
        secondMinimum.root.right = new Node(5);
        secondMinimum.root.right.left = new Node(5);
        secondMinimum.root.right.right = new Node(7);


        int secondMinimumValue = secondMinimum.findSecondMinimumValue(secondMinimum.root);
        System.out.println(secondMinimumValue);

    }


}
