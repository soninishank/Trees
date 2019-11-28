import BinaryTree.Node;

import java.util.ArrayList;
import java.util.Stack;

public class Test {
    Node root;

    public int kthLargest(Node root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = inoRderRecusrive(root, list);
        System.out.println(list1);
        return list.get(k - 1);
    }

    private ArrayList<Integer> inoRderRecusrive(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        inoRderRecusrive(root.right, list);
        list.add(root.data);
        inoRderRecusrive(root.left, list);
        return list;
    }

    public int kthLargestIterative(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        while (root != null || stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                System.out.println(root.data);
                return root.data;
            }
            root = root.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        Test tt = new Test();

        // Inputting Data
        tt.root = new Node(20);
        tt.root.left = new Node(8);
        tt.root.right = new Node(22);

        tt.root.left.left = new Node(4);
        tt.root.left.right = new Node(12);

        tt.root.left.right.right = new Node(14);
        tt.root.left.right.left = new Node(10);

        int k = 2;
        int i = new Test().kthLargest(tt.root, k);
        System.out.println(i);


        int i1 = new Test().kthLargest(tt.root, k);
        System.out.println(i1);
    }
}
