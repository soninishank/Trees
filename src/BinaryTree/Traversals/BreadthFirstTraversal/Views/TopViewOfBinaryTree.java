package BinaryTree.Traversals.BreadthFirstTraversal.Views;

// https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
// We need only these levels values -2 -1 0 1 2 -> depending on tree size


import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class TopViewOfBinaryTree {


    static class Obj {
        Node node;
        int level;

        public Obj(Node node, int level) {
            this.level = level;
            this.node = node;
        }
    }

    private void topTree(Node root) {
        TreeMap<Integer, Node> treeMap = new TreeMap<>();
        Queue<Obj> queue = new LinkedList<>();

        queue.add(new Obj(root, 0));
        while (!queue.isEmpty()) {
            Obj current = queue.remove();
            // Only difference
            if (!treeMap.containsKey(current.level)) // we dont want to override
            {
                treeMap.put(current.level, current.node);
            }
            if (current.node.left != null)
                queue.add(new Obj(current.node.left, current.level - 1));
            if (current.node.right != null)
                queue.add(new Obj(current.node.right, current.level + 1));
           /* Set<Integer> set = treeMap.keySet();
            for (int i : set) {
                System.out.print("Level is " + i + " + " + treeMap.get(i).data + "   ");
            }
            System.out.println();*/
        }
        System.out.println(treeMap);
        System.out.println();
        Set<Integer> set = treeMap.keySet();
        for (int num : set) {
            System.out.print(treeMap.get(num).data + " ");
        }

    }

    public static void main(String[] args) {
        TopViewOfBinaryTree topViewOfBinaryTree = new TopViewOfBinaryTree();
        // Inputting Data
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);


        // Iterative way
        System.out.println("Bottom view of a Binary Tree is :");
        topViewOfBinaryTree.topTree(root);
    }


}
// Different levels
// -2  -1  0  +1 +2
