package BinaryTree.Traversals.DepthFirstTraversal.Images;

import BinaryTree.Node;

// To check weather both the trees are same  or not  - Both trees having same data
// Here two trees are compared one by one
public class IdenticalTress {

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


    public static void main(String[] args) {
        IdenticalTress tree = new IdenticalTress();

        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);

        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);

        if (tree.identicalTrees(tree.root1, tree.root2)) {
            System.out.println("Both trees are identical");
        } else {
            System.out.println("Trees are not identical");
        }
    }

}
