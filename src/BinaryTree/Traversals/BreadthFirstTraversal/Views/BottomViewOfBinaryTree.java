package BinaryTree.Traversals.BreadthFirstTraversal.Views;

// https://www.geeksforgeeks.org/bottom-view-binary-tree/
// https://www.youtube.com/watch?v=ZyWh2v-74QI
// https://github.com/amitslm29/JavaInCloud9/blob/730962052a94f2613a65be201b5b26891bb953c3/JavaInCloud9/src/com/org/tree/ViewBottom.java

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

    Node root;


    static class Obj {
        Node node;
        int level;

        public Obj(Node node, int level) {
            this.node = node;
            this.level = level;
        }

    }
    // The only difference is here we are directly adding in map instead of checking so that it can override values at different levels -2 , -1 , 0 , +1 , +2

    private void bottomTree(Node root) {
        if (root == null) {
            return;
        }

        TreeMap<Integer, Node> map = new TreeMap<>();
        Queue<Obj> queue = new LinkedList<>();
        queue.add(new Obj(root, 0)); // Add root with 0


        while (!queue.isEmpty()) {
            Obj current = queue.remove();
            // Here we want it to override
            map.put(current.level, current.node); // Add in treeMap , level and node
            if (current.node.left != null) {
                queue.add(new Obj(current.node.left, current.level - 1));
            }
            if (current.node.right != null) {
                queue.add(new Obj(current.node.right, current.level + 1));
            }
            Set<Integer> set = map.keySet();
            for (int i : set) {
                System.out.print("Level is " + i + " + " + map.get(i).data + "   ");
            }
            System.out.println();
        }

        Set<Integer> set = map.keySet();
        for (int i : set) {
            System.out.print(map.get(i).data + " ");
        }

    }

    public static void main(String[] args) {
        BottomViewOfBinaryTree bottomViewOfBinaryTree = new BottomViewOfBinaryTree();
        // Inputting Data
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        // Iterative way
        System.out.println("Bottom view of a Binary Tree is :");
        bottomViewOfBinaryTree.bottomTree(root);


    }
}
