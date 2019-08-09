package BinaryTree.Traversals.DepthFirstTraversal;

// https://www.interviewbit.com/problems/inorder-traversal/
import BinaryTree.Node;
import java.util.Stack;

// In case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order.
// To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder traversals reversed can be used.


// inOrderTraversal can be applied at Many Places - all will be done by same iterative approach
// 1. Traversal BFS approach
// 2. Checking isBST
// 3. Recursive Binary Tree
// 4. Finding the kth smallest element in BST
public class inOrderTraversal {
    Node root;
    Stack<Node> stack = new Stack<>(); // Used for inOrderTraversal in Iterative way


    public void inOrderRecursive(Node root) {
        // Base condition

        if (root == null) {
            return;
        }
        inOrderRecursive(root.left);
        System.out.print(root.data + " ");
        inOrderRecursive(root.right);

    }


    private void inOrderIterative(Node root) {
        Node current = root;
        // Base condition you must apply in every Binary Tree Questions
        if (root == null) {
            return;
        }
        while (current != null || stack.size() > 0) {
            while (current != null) // Will be checked until we reached the last node of a left tree
            {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop(); // Most important step have to remember
            System.out.print(current.data + "  ");
            current = current.right;
        }
    }


    public static void main(String[] args) {
        inOrderTraversal inOrderTraversal = new inOrderTraversal();

        // Inputting Data
        inOrderTraversal.root = new Node(1);
        inOrderTraversal.root.left = new Node(2);
        inOrderTraversal.root.right = new Node(3);
        inOrderTraversal.root.left.left = new Node(4);
        inOrderTraversal.root.right.left = new Node(5);


        // Recursive way
        inOrderTraversal.inOrderRecursive(inOrderTraversal.root);

        System.out.println();

        // Iterative Pre Order Traversal
        inOrderTraversal.inOrderIterative(inOrderTraversal.root);


    }
}


