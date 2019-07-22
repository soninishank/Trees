package BinaryTree.Traversals.DepthFirstTraversal;

import BinaryTree.Node;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
If you know you need to explore the roots before inspecting any leaves,
you pick pre-order because you will encounter all the roots before all of the leaves.*/

// Root (Print ) -> left -> right
public class preOrderTraversal {
    Node root;
    private Stack<Node> stack = new Stack<>();


    private void preOrderRecursive(Node root) {
        if (root == null) {

            return;
        }
        System.out.print(root.data + "  ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    // Things to remember
    // Firstly add root outside the while loop
    // Than right and left

    private void preOrderIterative(Node root) {
        // Base case
        if (root == null) {
            return;
        }
        stack.push(root);
        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (!stack.isEmpty()) {
            Node pop = stack.pop();// Provides me the first node in stack
            System.out.print(pop.data + "   ");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }


    public static void main(String[] args) {
        preOrderTraversal preOrderTraversal = new preOrderTraversal();


        // Inputting data
        preOrderTraversal.root = new Node(1);
        preOrderTraversal.root.left = new Node(2);
        preOrderTraversal.root.left.left = new Node(3);
        preOrderTraversal.root.right = new Node(4);
        preOrderTraversal.root.right.left = new Node(5);

        // Recursive calls
        preOrderTraversal.preOrderRecursive(preOrderTraversal.root);
        System.out.println();

        // Iterative way
        preOrderTraversal.preOrderIterative(preOrderTraversal.root);


    }
}
