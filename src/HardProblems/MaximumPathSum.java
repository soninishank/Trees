package HardProblems;

import BinaryTree.Node;

public class MaximumPathSum {
    Node root;
    int maxValue;

    public int maxPathSum(Node root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    public int maxPathDown(Node root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));
        maxValue = Math.max(left + right + root.data, maxValue);
        return Math.max(left, right) + root.data;

    }


    public static void main(String[] args) {
        MaximumPathSum tree = new MaximumPathSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);


        System.out.println(tree.maxPathSum(tree.root));


    }

}
