package BinaryTree.Traversals.DepthFirstTraversal;

// https://www.interviewbit.com/problems/postorder-traversal/

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class postOrderTraversal {
    Node root;
    List<Integer> list = new LinkedList<>();
    Stack<Node> stack = new Stack<>();


    private void postOrderRecursive(Node root) {
        if (root == null) {
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data + " ");

    }

    // Things to remember
    //  Firstly add root , than add at index 0 when a new left element comes the old element will get shifted
    // root , left , right in a stack
    public List<Integer> postorderTraversal(Node root) {
        // Base case
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            list.add(0, curr.data);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        postOrderTraversal postOrderTraversal = new postOrderTraversal();

        // Inserting the data
        postOrderTraversal.root = new Node(1);
        postOrderTraversal.root.left = new Node(2);
        postOrderTraversal.root.right = new Node(3);
        postOrderTraversal.root.left.left = new Node(4);
        postOrderTraversal.root.left.right = new Node(5);

        //
        postOrderTraversal.postOrderRecursive(postOrderTraversal.root);

        System.out.println();

        List<Integer> list = postOrderTraversal.postorderTraversal(postOrderTraversal.root);
        System.out.println(list);
    }


}
