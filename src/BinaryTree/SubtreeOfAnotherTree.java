package BinaryTree;

import java.util.HashSet;

// https://leetcode.com/problems/subtree-of-another-tree/solution/
public class SubtreeOfAnotherTree {
    HashSet<String> hashSet = new HashSet<>();

    public boolean isSubtree(Node s, Node t) {
        String tree1 = preOrder(s, true);
        String tree2 = preOrder(t, true);
        int i = tree1.indexOf(tree2);
        return i >= 0;

    }

    private String preOrder(Node root, boolean left) {
        if (root == null) {
            if (left) {
                return "lnull";
            } else {
                return "rnull";
            }
        }
        return "#" + root.data + " " + preOrder(root.left, true) + " " + preOrder(root.right, false);
    }



}
