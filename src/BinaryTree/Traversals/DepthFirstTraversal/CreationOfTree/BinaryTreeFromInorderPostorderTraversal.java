package BinaryTree.Traversals.DepthFirstTraversal.CreationOfTree;

import BinaryTree.Node;
import BinaryTree.Traversals.DepthFirstTraversal.inOrderTraversal;
import BinaryTree.Traversals.DepthFirstTraversal.postOrderTraversal;
import BinaryTree.Traversals.DepthFirstTraversal.preOrderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderPostorderTraversal {

    public Node buildTree(int[] inorder, int[] postOrder) {
        // To Remember the indexes of inOrderTraversal
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        ArrayList<Integer> pre = new ArrayList<>();
        for (int i = 0; i < postOrder.length; i++) {
            pre.add(postOrder[i]);
        }
          Node root = buildTree(pre, 0, inorder.length - 1, inMap);
         return root;

        //return buildTreePostIn(inorder, 0, inorder.length - 1, postOrder, 0, postOrder.length - 1, inMap);

    }

    private Node buildTreePostIn(int[] list, int low, int high, int[] postOrder, int postLow, int postHigh, Map<Integer, Integer> inMap) {
        if (postLow > postHigh || low > high) {
            return null;
        }
        Node root = new Node(postOrder[postHigh]);
        int inOrderIndex = inMap.get(postOrder[postHigh]);
        Node leftchild = buildTreePostIn(list, low, inOrderIndex - 1, postOrder, postLow, postLow + inOrderIndex - low - 1, inMap);
        Node rightchild = buildTreePostIn(list, inOrderIndex + 1, high, postOrder, postLow + inOrderIndex - low, postHigh - 1, inMap);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }

    private Node buildTree(ArrayList<Integer> list, int low, int high, Map<Integer, Integer> inMap) {
        if (low > high) {
            return null;
        }
        Integer integer = list.get(list.size() - 1);// Root of the tree - Pre Order - First Index
        Node node = new Node(integer);
        // Now find the root in inOrder HashMap and get its index
        int inOrderIndex = inMap.get(node.data);
        list.remove(list.size() - 1);


        // Recursive calls
        node.left = buildTree(list, low, inOrderIndex - 1, inMap);// Left side
        node.right = buildTree(list, inOrderIndex + 1, high, inMap);// Right side
        return node;

    }


    public static void main(String[] args) {
        int[] postOrder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        Node node = new BinaryTreeFromInorderPostorderTraversal().buildTree(inorder, postOrder);

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
