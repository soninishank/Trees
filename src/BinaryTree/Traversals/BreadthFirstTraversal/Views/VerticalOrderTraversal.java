package BinaryTree.Traversals.BreadthFirstTraversal.Views;

import BinaryTree.Node;
// https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
import java.util.*;

public class VerticalOrderTraversal {
    static class Obj {
        Node node;
        int level;

        public Obj(Node node, int level) {
            this.level = level;
            this.node = node;
        }
    }

    private void verticalOrder(Node root) {
        if (root == null) {
            return;
        }
        TreeMap<Integer, ArrayList<Node>> treeMap = new TreeMap<>();
        Queue<Obj> queue = new LinkedList<>();

        queue.add(new Obj(root, 0));
        while (!queue.isEmpty()) {
            Obj current = queue.poll();
            if (!treeMap.containsKey(current.level)) // If does not contain
            {
                ArrayList<Node> arrayList = new ArrayList<>();
                arrayList.add(current.node);
                treeMap.put(current.level, arrayList);
            } else {
                // if it contains
                ArrayList<Node> list = treeMap.get(current.level);
                list.add(current.node);
                treeMap.put(current.level, list);
            }
            if (current.node.left != null) {
                queue.add(new Obj(current.node.left, current.level - 1));
            }
            if (current.node.right != null) {
                queue.add(new Obj(current.node.right, current.level + 1));
            }
        }

        Set<Integer> set = treeMap.keySet();
        for (int key : set) {
            System.out.println(treeMap.get(key));
        }
    }


    void verticalOrderTraversalUsingRecursion(Node node, int level, TreeMap<Integer, ArrayList<Integer>> map) {
        if (node == null) {
            return;
        }
        if (map.containsKey(level)) {
            ArrayList<Integer> list = map.get(level);
            list.add(node.data);
            map.put(level, list);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            map.put(level, list);
        }

        verticalOrderTraversalUsingRecursion(node.left, level - 1, map);
        verticalOrderTraversalUsingRecursion(node.right, level + 1, map);

    }


    public static void main(String[] args) {
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
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
        System.out.println("Vertical view of a Binary Tree is :");
        verticalOrderTraversal.verticalOrder(root);


        // Recursive way
        System.out.println("Vertical view of a Binary Tree is :");
        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
        int level = 0;
        verticalOrderTraversal.verticalOrderTraversalUsingRecursion(root, 0, treeMap);
        verticalOrderTraversal.print(treeMap);


    }

    public void print(TreeMap<Integer, ArrayList<Integer>> map) {
        Set<Integer> set = map.keySet();
        for (int key : set) {
            System.out.println(map.get(key));
        }
    }
}
