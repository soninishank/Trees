package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// As we know that for sorted BST -  inorder traversal of BST is an array sorted in the ascending order.
public class KthSmallestElementInBST {
    Node root;

    public ArrayList<Integer> inorderRecursive(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorderRecursive(root.left, arr);
        arr.add(root.data);
        inorderRecursive(root.right, arr);
        return arr;
    }

    public int kthSmallestRecusrive(Node root, int k) {
        ArrayList<Integer> nums = inorderRecursive(root, new ArrayList<Integer>());
        System.out.println(nums);
        return nums.get(k - 1);// Because array index starts from 0
    }


    //This way one could speed up the solution because there is no need to build the entire inorder traversal, and one could stop after the kth element
    public int kthSmallestIterative(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (stack.size() > 0 || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (--k == 0) {
                return root.data;
            }
            current = current.right;
        }
        return -1;
    }





    public static void main(String[] args) {
        KthSmallestElementInBST KthSmallestElementInBST = new KthSmallestElementInBST();

        // Inputting Data
        KthSmallestElementInBST.root = new Node(4);
        KthSmallestElementInBST.root.left = new Node(2);
        KthSmallestElementInBST.root.right = new Node(5);
        KthSmallestElementInBST.root.left.left = new Node(1);
        KthSmallestElementInBST.root.left.right = new Node(3);


        // Recursive way
        //   KthSmallestElementInBST.inOrderRecursive(KthSmallestElementInBST.root);

        System.out.println();

        int kthRecusrive = KthSmallestElementInBST.kthSmallestRecusrive(KthSmallestElementInBST.root, 2);
        System.out.println(kthRecusrive);


        int kthSmallestIterative = KthSmallestElementInBST.kthSmallestIterative(KthSmallestElementInBST.root, 3);
        System.out.println(kthSmallestIterative);


    }

}
