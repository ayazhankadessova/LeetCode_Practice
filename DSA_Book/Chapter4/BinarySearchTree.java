import java.util.Stack;

// Simple BST & Inorder Traversal

public class BinarySearchTree {

    Node root;

    class Node {
        Node right;
        Node left;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    BinarySearchTree() {
        root = null;
    }

    public Node insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
        return root;
    }

    public Node insert(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(node.left, value);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insert(node.right, value);
            }
        }
        return node;
    }

    public void delete(int value) {
        root = deleteR(value, root);
        // delete(value, root);
    }

    /*
     * Delete recursively
     * 1. Find the node to be deleted
     * 2. Check cases: 1/2/0 children
     */
    private Node deleteR(int v, Node n) {
        if (n == null)
            return null;
        if (v < n.value)
            n.left = deleteR(v, n.left);
        else if (v > n.value)
            n.right = deleteR(v, n.right);
        else {
            System.out.println("HERE");
            // node with only one child or no child -> return the child that exists
            if (n.left == null)
                return n.right;
            else if (n.right == null)
                return n.left;

            // node with two children: get smallest in right subtree
            n = removeMinNode(n.right);

            // Delete the inorder successor
            n.right = deleteR(v, n.right);
        }
        // important!
        return n;
    }

    private Node removeMinNode(Node right) {

        while (right.left != null) {
            right = right.left;
        }
        return right;
    }

    /* Given a binary tree, print its nodes in inorder */
    void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the value of node */
        System.out.print(node.value + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    // Wrappers over above recursive functions
    void printInorder() {
        printInorder(root);
    }

    // public void printTree() {
    // inOrder();
    // }

    // public void inOrder() {
    // if (root != null) {
    // inOrder(root);
    // }
    // }

    // private void inOrder(Node root) {
    // Stack<Node> a = new Stack<Node>();

    // a = pushAll(a, root);
    // while (!a.isEmpty()) {
    // Node tmp = (Node) a.pop();
    // System.out.println(tmp.value);
    // if (tmp.right != null) {
    // a = pushAll(a, tmp.right);
    // }
    // }

    // }

    public Stack<Node> pushAll(Stack stack, Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return stack;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);

        System.out.println("\nInorder traversal: ");
        bst.printInorder();

        System.out.println("\nDelete non existent element: ");
        bst.delete(0);
        bst.printInorder();

        System.out.println("\nDelete existent element: ");
        bst.delete(5);
        bst.printInorder();

    }

}
