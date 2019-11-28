package HardProblems;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    Node root;

    public boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        }

        int value = sum - root.data;
        if (root.left == null && root.right == null && value == 0) {
            return true;
        }
        boolean b = hasPathSum(root.left, value);
        boolean b1 = hasPathSum(root.right, value);
        return b || b1;
    }

    public List<String> binaryTreePaths(Node root) {
        if (root == null) {
            return null;
        }
        List list = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        dfsApproach(root, list, stringBuilder);
        return list;
    }

    private void dfsApproach(Node root, List list, StringBuilder stringBuilder)
    {
        if (root== null)
        {
            return;
        }
        if (root.left == null && root.right == null)
        {
            list.add(stringBuilder.toString());
            return;
        }

    }


    public static void main(String[] args) {
        PathSum tree = new PathSum();
        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(8);

        tree.root.right.left = new Node(13);
        tree.root.right.right = new Node(4);
        tree.root.right.right.right = new Node(1);

        tree.root.left.left = new Node(11);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(2);


        System.out.println(tree.hasPathSum(tree.root, 22));


    }
}
