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

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    public void insert(Node node, int value) {
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
    }

    /* Given a binary tree, print its nodes in inorder */
    void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
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

        bst.printInorder();
    }

}
