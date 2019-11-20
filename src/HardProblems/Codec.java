package HardProblems;

// https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// The idea is simple: print the tree in pre-order traversal and use "X" to denote null node and split node with ",".
// We can use a StringBuilder for building the string on the fly. For de serializing, we use a Queue to store the pre-order traversal and since we have "X" as null node, we know exactly how to where to end building subtrees.

import BinaryTree.Node;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(Node node, StringBuilder sb) {
        if (node == null)
        {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.data).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        String[] split = data.split(spliter);
        List<String> strings = Arrays.asList(split);

        nodes.addAll(strings);
        return buildTree(nodes);
    }

    private Node buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            Node node = new Node(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}