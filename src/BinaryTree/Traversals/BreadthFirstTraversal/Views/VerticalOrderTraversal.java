package BinaryTree.Traversals.BreadthFirstTraversal.Views;

import BinaryTree.Node;
import BinaryTree.Traversals.DepthFirstTraversal.inOrderTraversal;

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
    }
}
