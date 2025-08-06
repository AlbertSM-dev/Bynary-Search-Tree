import java.util.Arrays;
import java.util.Scanner;

public class BalancedBST {

    public Node root;

    public Node sortedArrayToBST(int[] data, int start, int end) {

        if (start > end) {
            return null;
        }

        // This element will become the root of the subtree.
        int mid = start + (end - start) / 2;
        Node node = new Node(data[mid]);

        // Recursively.
        // The left child less than the root.
        node.left = sortedArrayToBST(data, start, mid - 1);

        // Recursively.
        // The right child greater than the root.
        node.right = sortedArrayToBST(data, mid + 1, end);

        return node;
    }
    
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node current, int data) {

        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            // If the new value is smaller, go to left subtree.
            current.left = insertRec(current.left, data);
        } else if (data > current.data) {
            // If the new value is larger, go to right subtree.
            current.right = insertRec(current.right, data);
        } else {
            System.out.println("Value " + data + " already exists in the tree.");
            return current;
        }

        return current;
    }
    
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node current, int data) {

        if (current == null) {
            System.out.println("Value " + data + " not found in the tree.");
            return null;
        }

        // 1. Find the node to be deleted.
        if (data < current.data) {
            current.left = deleteRec(current.left, data);
        } else if (data > current.data) {
            current.right = deleteRec(current.right, data);
        } else {
            // Node with the value is found. Now handle the 3 deletion cases.

            // Case 1: Node is a leaf (no children)
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Node has one child
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

        }
        return current;
    }

    public void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    
    public void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printPreOrder(node.left);
        System.out.print(node.data + " ");
        printPreOrder(node.right);
    }
    
    public void printPostOrder(Node node) {
        if (node == null) {
            return;
        }
        printPreOrder(node.left);
        printPreOrder(node.right);
        System.out.print(node.data + " ");
    }   
}
