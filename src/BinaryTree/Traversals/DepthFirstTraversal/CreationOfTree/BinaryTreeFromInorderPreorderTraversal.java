package BinaryTree.Traversals.DepthFirstTraversal.CreationOfTree;

import BinaryTree.Node;
import BinaryTree.Traversals.DepthFirstTraversal.inOrderTraversal;
import BinaryTree.Traversals.DepthFirstTraversal.postOrderTraversal;
import BinaryTree.Traversals.DepthFirstTraversal.preOrderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderPreorderTraversal {
    Node root;

    public Node buildTree(int[] preorder, int[] inorder) {
        // To Remember the indexes of inOrderTraversal
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        ArrayList<Integer> pre = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            pre.add(preorder[i]);
        }
        Node root = buildTree(pre, 0, inorder.length - 1, inMap);
        return root;
    }

    private Node buildTree(ArrayList<Integer> list, int low, int high, Map<Integer, Integer> inMap) {
        if (low > high) {
            return null;
        }
        Integer integer = list.get(0);// Root of the tree - Pre Order - First Index
        Node node = new Node(integer);
        // Now find the root in inOrder HashMap and get its index
        int inOrderIndex = inMap.get(node.data);
        list.remove(0);


        // Recursive calls
        node.left = buildTree(list, low, inOrderIndex - 1, inMap);// Left side
        node.right = buildTree(list, inOrderIndex + 1, high, inMap);// Right side
        return node;

    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Node node = new BinaryTreeFromInorderPreorderTraversal().buildTree(preorder, inorder);

        System.out.print("In Order is ==> ");
        new inOrderTraversal().inOrderRecursive(node);
        System.out.println();
        System.out.print("Pre  Order ==> ");
        new preOrderTraversal().preOrderRecursive(node);

        System.out.println();
        System.out.print("Post  Order ==> ");
        new postOrderTraversal().postOrderRecursive(node);


    }
}
