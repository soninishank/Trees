package BinarySearchTree.Easy;

import BinaryTree.Node;

public class searchInBST {

    Node root1;

    private Node search(Node root, int target) {
        if (root == null) {
            return null;
        }
        Node temp = root;
        while (temp != null) {
            if (target == temp.data) {
                return temp;
            }
            if (target < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    private Node searchUsingRecursion(Node root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return root;
        }
        if (root.data < target) {
            searchUsingRecursion(root.right, target);
        } else {
            searchUsingRecursion(root.left, target);
        }
        return null;
    }


    public static void main(String[] args) {
        searchInBST root = new searchInBST();
        root.root1 = new Node(20);
        root.root1.left = new Node(10);
        root.root1.right = new Node(30);
        root.root1.left.left = new Node(5);
        root.root1.left.right = new Node(15);
        root.root1.right.left = new Node(25);
        root.root1.right.right = new Node(35);


        Node result = root.search(root.root1, 15);
        if (result == null)
            System.out.println("Search data is not found !!!");
        else
            System.out.println("Search data is found !!!");
    }


}
