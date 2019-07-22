package BinaryTree.Traversals.DepthFirstTraversal.Images;

import BinaryTree.Node;
import BinaryTree.Traversals.DepthFirstTraversal.inOrderTraversal;

// Mirror image means left become right and right become left
// 1, 2,3,4,5,null,7 becomes 1,3,2,7,null,5,4
// We are swapping the left and the right child at each and every position

// Time ans space complexity is O(n)

// In Output you will be able to see that mirror image is the reverse of original InOrder Traversal
class MirrorImageBinaryTree {
    Node root;

    // Do Post Order Traversal than do swapping
    private void MirrorImageBinaryTrees(Node root) {
        /// Base case
        if (root == null) {
            return;
        }
        // Now do postOrderTraversal
        MirrorImageBinaryTrees(root.left);
        MirrorImageBinaryTrees(root.right);

        // Now swap the left and right children
        Node temp = root.left; // save left value to temp
        root.left = root.right;
        root.right = temp; // Make right value equals to left


    }


    public static void main(String args[]) {
        MirrorImageBinaryTree MirrorImageBinaryTree = new MirrorImageBinaryTree();
        MirrorImageBinaryTree.root = new Node(1);
        MirrorImageBinaryTree.root.left = new Node(2);
        MirrorImageBinaryTree.root.right = new Node(3);
        MirrorImageBinaryTree.root.left.left = new Node(4);
        MirrorImageBinaryTree.root.left.right = new Node(5);

        /* Print inorder traversal of the input tree */
        System.out.print("Inorder traversal of the Binary Tree is  ");
        new inOrderTraversal().inOrderRecursive(MirrorImageBinaryTree.root);

        /* Convert tree to its mirror */
        MirrorImageBinaryTree.MirrorImageBinaryTrees(MirrorImageBinaryTree.root);

        /* Print inorder traversal of the mirror tree */
        System.out.print("\nInorder traversal of the " +
                "mirror tree is  ");

        new inOrderTraversal().inOrderRecursive(MirrorImageBinaryTree.root);


    }

}
