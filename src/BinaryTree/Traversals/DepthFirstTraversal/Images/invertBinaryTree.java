// https://leetcode.com/problems/invert-binary-tree/
package BinaryTree.Traversals.DepthFirstTraversal.Images;

import BinaryTree.Node;
import BinaryTree.Traversals.DepthFirstTraversal.preOrderTraversal;

// https://www.interviewbit.com/problems/invert-the-binary-tree/
public class invertBinaryTree {

    Node rooot;

    public Node invertTree(Node root) {
        if (root == null) {
            return root;
        }
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        //Swap the left and right pointers
        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        invertBinaryTree invertBinaryTree = new invertBinaryTree();

        invertBinaryTree.rooot = new Node(1);
        invertBinaryTree.rooot.left = new Node(2);
        invertBinaryTree.rooot.right = new Node(3);
        invertBinaryTree.rooot.left.left = new Node(4);
        invertBinaryTree.rooot.left.right = new Node(5);


        Node node = invertBinaryTree.invertTree(invertBinaryTree.rooot);


        new preOrderTraversal().preOrderRecursive(node);

    }

}
