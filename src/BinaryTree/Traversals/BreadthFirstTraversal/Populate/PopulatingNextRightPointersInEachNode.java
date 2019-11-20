// https://www.geeksforgeeks.org/connect-nodes-at-same-level/
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
package BinaryTree.Traversals.BreadthFirstTraversal.Populate;

import BinaryTree.Node;

//  O(1) Space and O(n) Time (Recursive)
// Only for perfect binary trees
public class PopulatingNextRightPointersInEachNode {

    public void connect(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);

    }

    public static void main(String args[]) {
        PopulatingNextRightPointersInEachNode tree = new PopulatingNextRightPointersInEachNode();

        System.out.println();


    }
}
