package BinarySearchTree;

// https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.Stack;

// As we know that for sorted BST -  inorder traversal of BST is an array sorted in the ascending order.
public class KthSmallestLargestElementInBST {
    Node root;

    // For smallest Element
    public ArrayList<Integer> inorderRecursiveSmallest(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorderRecursiveSmallest(root.left, arr);
        arr.add(root.data);
        inorderRecursiveSmallest(root.right, arr);
        return arr;
    }

    // For smallest Element
    public int kthSmallestRecursiveSmallest(Node root, int k) {
        ArrayList<Integer> nums = inorderRecursiveSmallest(root, new ArrayList<Integer>());
        System.out.println("Smallest " + nums);
        return nums.get(k - 1);// Because array index starts from 0
    }

    //This way one could speed up the solution because there is no need to build the entire inorder traversal, and one could stop after the kth element
    public int kthSmallestIterative(Node root, int k)
    {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.data;
            }
            root = root.right;
        }

        return -1;
    }

    // For smallest Element
    public int kthSmallestRecursiveLargest(Node root, int k) {
        ArrayList<Integer> nums = inorderRecursiveLargest(root, new ArrayList<Integer>());
        System.out.println("Largest " + nums);
        return nums.get(k - 1);// Because array index starts from 0
    }

    // Need to use reverse inorder
    public ArrayList<Integer> inorderRecursiveLargest(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorderRecursiveSmallest(root.right, arr);
        arr.add(root.data);
        inorderRecursiveSmallest(root.left, arr);
        return arr;
    }


    public int kthLargestIterative(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.data;
            }
            root = root.left;
        }

        return -1;
    }


    public static void main(String[] args) {
        KthSmallestLargestElementInBST KthSmallestLargestElementInBST = new KthSmallestLargestElementInBST();

        // Inputting Data
        KthSmallestLargestElementInBST.root = new Node(20);
        KthSmallestLargestElementInBST.root.left = new Node(8);
        KthSmallestLargestElementInBST.root.right = new Node(22);

        KthSmallestLargestElementInBST.root.left.left = new Node(4);
        KthSmallestLargestElementInBST.root.left.right = new Node(12);

        KthSmallestLargestElementInBST.root.left.right.right = new Node(14);
        KthSmallestLargestElementInBST.root.left.right.left = new Node(10);


        Node root = KthSmallestLargestElementInBST.root;


        System.out.println("Largest " + KthSmallestLargestElementInBST.kthSmallestRecursiveLargest(root, 2));
        System.out.println("Largest " + KthSmallestLargestElementInBST.kthLargestIterative(root, 2));

        System.out.println("Smallest " + KthSmallestLargestElementInBST.kthSmallestRecursiveSmallest(root, 2));
        System.out.println("Smallest " + KthSmallestLargestElementInBST.kthSmallestIterative(root, 2));


    }

}
