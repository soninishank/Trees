import BinaryTree.Node;

public class TreeDepth {
    Node root;


    public static void main(String[] args) {
        TreeDepth tt = new TreeDepth();

        // Inputting Data
        tt.root = new Node(1);
        tt.root.left = new Node(2);
        tt.root.right = new Node(3);


        tt.root.left.left = new Node(4);
        tt.root.right.left = new Node(5);
        tt.root.right.right = new Node(6);

        tt.root.right.left.right = new Node(7);


        tt.root.left.right.left = new Node(10);

        int k = 2;
        int i = new Test().kthLargest(tt.root, k);
        System.out.println(i);


        int i1 = new Test().kthLargest(tt.root, k);
        System.out.println(i1);
    }
}
