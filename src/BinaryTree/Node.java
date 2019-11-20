package BinaryTree;


// A binaryTree is having Data and having address of left and right pointers
// This is the basic binary tree structure used by all classes of binary tree
public class Node {
    public int data;
    public Node left, right;
    public Node next;

    public Node(int item) {
        left = null;
        right = null;
        this.data = item;
        next = null;

    }

    public String toString() {
        return String.valueOf(data);
    }

}
