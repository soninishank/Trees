package BinaryTree.Traversals.BreadthFirstTraversal.Views;

import BinaryTree.Node;

import javax.jws.Oneway;
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
            Set<Integer> set = treeMap.keySet();
            for (int i : set) {
                System.out.print("Level is " + i + " + " + treeMap.get(i).data + "   ");
            }
            System.out.println();
        }

        Set<Integer> set = treeMap.keySet();
        for (int num : set) {
            System.out.print(treeMap.get(num).data + " ");
        }

    }

    public static void main(String[] args) {
        TopViewOfBinaryTree topViewOfBinaryTree = new TopViewOfBinaryTree();
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
        topViewOfBinaryTree.topTree(root);
    }


}
