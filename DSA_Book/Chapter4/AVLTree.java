public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    Node<T> root;

    class Node<T extends Comparable<T>> {
        Node<T> left = null;
        Node<T> right = null;
        int height = 1;
        T data;

        public Node(T data) {
            this.data = data;
        }

    }

    @Override
    public Tree<T> insert(T data) {
        root = insert(data, root);
        return this;
    }

    private Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insert(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(data, node.right);
        } else {
            return node;
        }

        updateHeight(node);
        return applyRotation(node);
    }

    // heigh of node is max heigh of children
    private void updateHeight(AVLTree<T>.Node<T> node) {
        int maxHeight = 0;
        if (node.left == null && node.right != null) {
            maxHeight = node.right.height;
        } else if (node.right == null && node.left != null) {
            maxHeight = node.left.height;
        } else if (node.right == null && node.left == null) {
            node.height = 1;
            return;
        } else if (node.right != null && node.left != null) {
            maxHeight = Math.max(node.right.height, node.left.height);
        }
        node.height = maxHeight + 1;
    }

    @Override
    public void delete(T value) {
        root = deleteR(value, root);
        // delete(value, root);
    }

    /*
     * Delete recursively
     * 1. Find the node to be deleted
     * 2. Check cases: 1/2/0 children
     */
    private Node<T> deleteR(T data, Node<T> n) {
        if (n == null)
            return null;
        if (data.compareTo(n.data) < 0)
            n.left = deleteR(data, n.left);
        else if (data.compareTo(n.data) > 0)
            n.right = deleteR(data, n.right);
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
            n.right = deleteR(data, n.right);
        }
        updateHeight(n);
        return applyRotation(n);
    }

    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);
        // left heavy -> rotate right
        if (balance > 1) {
            // LR
            if (balance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            // need more than just one rotation
            return rotateRight(node);
        }
        // right heavy -> rotate left
        if (balance < -1) {
            // RL
            if (balance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            // need more than just one rotation
            return rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> n) {
        Node<T> leftNode = n.left;
        Node<T> centerNode = leftNode.right;
        leftNode.right = n;
        n.left = centerNode;
        updateHeight(n);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node<T> rotateLeft(Node<T> n) {
        Node<T> rightNode = n.right;
        Node<T> centerNode = rightNode.left;
        rightNode.right = n;
        n.right = centerNode;
        updateHeight(n);
        updateHeight(rightNode);
        return rightNode;
    }

    private int balance(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            int left;
            if (node.left == null) {
                left = 0;
            } else {
                left = node.left.height;
            }

            int right;
            if (node.right == null) {
                right = 0;
            } else {
                right = node.right.height;
            }

            return left - right;
        }
    }

    private Node<T> removeMinNode(Node<T> right) {

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
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    @Override // Wrappers over above recursive functions
    public void traverse() {
        printInorder(root);
    }

    @Override
    public T getMax() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMax'");
    }

    @Override
    public T getMin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMin'");
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(10).insert(2).insert(6).insert(8).insert(25).insert(18).insert(35).insert(15).insert(22).insert(42)
                .insert(30).insert(40).insert(12).insert(17).insert(19).insert(24).insert(28).insert(33).insert(38);

        tree.traverse();
    }

}
