package BinaryTree.Traversals.BreadthFirstTraversal;

import BinaryTree.Node;
import BinaryTree.calculation.heightMaxDepth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//It traverses all the nodes at each level before going to the next level (depth)
// FIFO - Order - Queue  - Dequeue and Enqueue operation
// Time Complexity - O(N)
// Space complexity - Here our queue is growing and shrinking - Dynamic queue - O (1) - Best , O(n) Worst ,Average
public class LevelOrderTraversal {
    Node root;
    Queue<Node> queue = new LinkedList<>();


    private void levelOrderRecursive(Node root) {
        if (root == null) {
            return;
        }
        int height = new heightMaxDepth().heightRecursiveWay(root); // Get the height first
        for (int i = 0; i <= height; i++) {
            printAtEachLevel(root, i);
        }
    }


    private void levelOrderRecursiveLineByLine(Node root) {
        if (root == null) {
            return;
        }
        int height = new heightMaxDepth().heightRecursiveWay(root); // Get the height first
        for (int i = 0; i <= height; i++) {
            printAtEachLevel(root, i);
            System.out.println(); // Added this extra line
        }
    }


    private void printAtEachLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");

        } else {
            printAtEachLevel(root.left, level - 1);
            printAtEachLevel(root.right, level - 1);
        }
    }

    // We need to store the children's at each node . We use queue
    private void levelOrderIterative(Node root) // Time Complexity – O(n)  Space Complexity – O(n) The Queue size is equal to the number of the nodes.
    {
        if (root == null) {
            return;
        }
        queue.add(root); // Adding the L0 element
        while (!queue.isEmpty()) // If queue is not empty than loop until we covered all left and right elements - while there is at least one discovered node
        {
            Node tempNode = queue.poll(); // Take the front element and remove it from the Queue
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    private List<List<Integer>> levelOrderIterativeAtEachLevel(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                Node tempNode = queue.poll();// Take the front element and remove it from the Queue
                level.add(tempNode.data);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                size--;
            }
            list.add(level);
        }
        return list;
    }


    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        // Inputting Data
        levelOrderTraversal.root = new Node(3);
        levelOrderTraversal.root.left = new Node(9);
        levelOrderTraversal.root.right = new Node(20);
        levelOrderTraversal.root.right.left = new Node(15);
        levelOrderTraversal.root.right.right = new Node(7);

        // Recursive way
        levelOrderTraversal.levelOrderRecursive(levelOrderTraversal.root);

        System.out.println();
        System.out.println("Iterative way ");

        // Iterative way
        levelOrderTraversal.levelOrderIterative(levelOrderTraversal.root);

        System.out.println();
        System.out.println();

        // Recursive line by line
        levelOrderTraversal.levelOrderRecursiveLineByLine(levelOrderTraversal.root);

        System.out.println();
        System.out.println("Iterative queue way ");
        List<List<Integer>> lists = levelOrderTraversal.levelOrderIterativeAtEachLevel(levelOrderTraversal.root);
        System.out.println(lists);
    }


}
