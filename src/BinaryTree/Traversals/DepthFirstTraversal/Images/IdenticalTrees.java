package BinaryTree.Traversals.DepthFirstTraversal.Images;

import BinaryTree.Node;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

// To check weather both the trees are same  or not  - Both trees having same data
// Same Tree
// https://leetcode.com/problems/same-tree/
public class IdenticalTrees {

    Node root1, root2;

    private boolean identicalTrees(Node root1, Node root2) {
        // Both are empty than both are equal
        if (root1 == null && root2 == null) {
            return true;
        }
        // Both are not empty
        if ((root1 != null && root2 != null)) {
            return (root1.data == root2.data) && identicalTrees(root1.left, root2.left) && identicalTrees(root1.right, root2.right);
        }
        // If one of them is empty
        return false;
    }

    public boolean isSameTree(Node p, Node q) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty())
        {
            Node f = queue.poll();
            Node s = queue.poll();
            if (f == null && s == null) {
                continue;
            } else if (f == null || s == null || f.data != s.data) {
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }
        return true;
    }


    public static void main(String[] args) {
        IdenticalTrees sameTree = new IdenticalTrees();

        sameTree.root1 = new Node(1);
        sameTree.root1.left = new Node(2);
        sameTree.root1.right = new Node(3);
        sameTree.root1.left.left = new Node(4);
        sameTree.root1.left.right = new Node(5);

        sameTree.root2 = new Node(1);
        sameTree.root2.left = new Node(2);
        sameTree.root2.right = new Node(3);
        sameTree.root2.left.left = new Node(4);
        sameTree.root2.left.right = new Node(5);

        if (sameTree.identicalTrees(sameTree.root1, sameTree.root2))
        {
            System.out.println("Both trees are identical");
        } else {
            System.out.println("Trees are not identical");
        }


        boolean sameTree1 = sameTree.isSameTree(sameTree.root1, sameTree.root2);
        System.out.println(sameTree1);
    }

}
