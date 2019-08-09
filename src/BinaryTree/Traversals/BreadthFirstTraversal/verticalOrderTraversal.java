package BinaryTree.Traversals.BreadthFirstTraversal;

import BinaryTree.Node;

import java.util.*;

// https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/
// We need to get the distance from parentNode to a Node
// For left = Distance  - 1 ;
// For right = Distance + 1 ;
// Using TreeMap , it keeps all the keys in a sorted order so firstly key with -2 , -1 , 0 , 1 , 2 will be printed
public class verticalOrderTraversal {
    Node root;

    Map<Integer, TreeSet<int[]>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        populate(root, 0, 0);
        for (int i : map.keySet()) {
            List<Integer> list = new LinkedList<>();
            for (int[] j : map.get(i))
                list.add(j[0]);

            res.add(list);
        }
        return res;
    }

    private void populate(Node root, int order, int level) {
        if (root == null) return;
        if (!map.containsKey(order))
            map.put(order, new TreeSet<int[]>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]));

        map.get(order).add(new int[]{root.data, level});
        populate(root.left, order - 1, level + 1);
        populate(root.right, order + 1, level + 1);
    }


    public static void main(String[] args) {
        verticalOrderTraversal verticalOrderTraversal = new verticalOrderTraversal();

        // Inputting Data
        verticalOrderTraversal.root = new Node(1);
        verticalOrderTraversal.root.left = new Node(2);
        verticalOrderTraversal.root.right = new Node(3);
        verticalOrderTraversal.root.left.left = new Node(4);
        verticalOrderTraversal.root.left.right = new Node(5);

        // Recursive way
        List<List<Integer>> lists = verticalOrderTraversal.verticalTraversal(verticalOrderTraversal.root);

        System.out.println(lists);


    }

}
