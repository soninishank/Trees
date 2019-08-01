package BinaryTree.Traversals.DepthFirstTraversal.Images;

import BinaryTree.Node;
import BinaryTree.Traversals.DepthFirstTraversal.inOrderTraversal;

// Mirror image means left become right and right become left
// 1, 2,3,4,5,null,7 becomes 1,3,2,7,null,5,4
// We are swapping the left and the right child at each and every position
// Two trees are a mirror reflection of each other if:
//Their two roots have the same value.
//The right subtree of each tree is a mirror reflection of the left subtree of the other tree.
// Time ans space complexity is O(n)

// In Output you will be able to see that mirror image is the reverse of original InOrder Traversal
// A tree is symmetric if the left subtree is a mirror reflection of the right subtree.
class MirrorImageSymmetricBinaryTree {
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


    public boolean isSymmetric(Node root) {
        return identicalTrees(root, root);
    }

    public boolean identicalTrees(Node root1, Node root2) {
        // Both are empty than both are equal
        if (root1 == null && root2 == null) {
            return true;
        }
        // Both are not empty
        if ((root1 != null && root2 != null)) {
            return (root1.data == root2.data) && identicalTrees(root1.left, root2.right) && identicalTrees(root1.right, root2.left);
        }
        // If any one of them is empty
        return false;
    }


    public static void main(String args[]) {
        MirrorImageSymmetricBinaryTree MirrorImageSymmetricBinaryTree = new MirrorImageSymmetricBinaryTree();
        MirrorImageSymmetricBinaryTree.root = new Node(1);
        MirrorImageSymmetricBinaryTree.root.left = new Node(2);
        MirrorImageSymmetricBinaryTree.root.right = new Node(2);
        MirrorImageSymmetricBinaryTree.root.left.left = new Node(3);
        MirrorImageSymmetricBinaryTree.root.left.right = new Node(4);
        MirrorImageSymmetricBinaryTree.root.right.left = new Node(4);
        MirrorImageSymmetricBinaryTree.root.right.right = new Node(3);

        /* Print inorder traversal of the input tree */
        System.out.print("Inorder traversal of the Binary Tree is  ");
        new inOrderTraversal().inOrderRecursive(MirrorImageSymmetricBinaryTree.root);

        /* Convert tree to its mirror */
        MirrorImageSymmetricBinaryTree.MirrorImageBinaryTrees(MirrorImageSymmetricBinaryTree.root);

        /* Print inorder traversal of the mirror tree */
        System.out.print("\nInorder traversal of the " +
                "mirror tree is  ");

        new inOrderTraversal().inOrderRecursive(MirrorImageSymmetricBinaryTree.root);


        System.out.println();
        System.out.println("Check is symmetric or not ");


        boolean symmetric = MirrorImageSymmetricBinaryTree.isSymmetric(MirrorImageSymmetricBinaryTree.root);


        System.out.println("The tree is symmetric " + symmetric);


    }

}
