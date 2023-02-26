public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    Node<T> root;

    /**
     * This class represents a node in an AVLtree.
     * 
     * @param <T> - the type of data stored in the node.
     */
    class Node<T extends Comparable<T>> {
        Node<T> left = null;
        Node<T> right = null;
        // the height of the node (initially set to 1)
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

    /**
     * 
     * This class is responsible for inserting a new data into an AVLtree.
     * 
     * @param data - the data to be inserted.
     * @param node - the current node being checked.
     * @return the new root node after any necessary rotations.
     */
    private Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        // if the data is less than the current node's data, insert it into the left
        // subtree
        if (data.compareTo(node.data) < 0) {
            System.out.println(data + " is less than " + node.data);
            node.left = insert(data, node.left);
        }
        // if the data is greater than the current node's data, insert it into the right
        // subtree
        else if (data.compareTo(node.data) > 0) {
            System.out.println(data + " is more than " + node.data);

            node.right = insert(data, node.right);
        }
        // if the data is equal to the current node's data, return the current node (no
        // insertion needed)
        else {
            return node;
        }
        // update the height of the current node
        updateHeight(node);
        // apply any necessary rotations to balance the tree and return the new root
        // node
        return applyRotation(node);
    }

    // heigh of node is max heigh of children
    private void updateHeight(Node<T> node) {
        int maxHeight = Math.max(
                height(node.left),
                height(node.right));
        node.height = maxHeight + 1;
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
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
     * 3. update height of node
     * 4. apply rotation
     */
    private Node<T> deleteR(T data, Node<T> n) {
        if (n == null)
            return null;
        if (data.compareTo(n.data) < 0)
            n.left = deleteR(data, n.left);
        else if (data.compareTo(n.data) > 0)
            n.right = deleteR(data, n.right);
        else {
            // node with only one child or no child -> return the child that exists
            if (n.left == null)
                return n.right;
            else if (n.right == null)
                return n.left;

            n.data = getMax(n.left);
            n.left = deleteR(n.data, n.left);

            // // node with two children: get smallest in right subtree
            // n = removeMinNode(n.right);

            // // Delete the inorder successor
            // n.right = deleteR(data, n.right);
        }
        updateHeight(n);
        return applyRotation(n);
    }

    /**
     * 
     * This method checks the balance factor of the given AVLtree node and applies
     * the appropriate rotation(s)
     * to balance the tree if necessary.
     * 
     * @param node - the node to check and rotate if necessary.
     * @return the new root node after any necessary rotations.
     */
    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);
        // if the node is left-heavy, rotate right
        if (balance > 1) {
            // check if a left-right rotation is necessary (LR)
            if (balance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            // need more than just one rotation
            return rotateRight(node);
        }
        // if the node is right-heavy, rotate left
        if (balance < -1) {
            // check if a right-left rotation is necessary (RL)
            if (balance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            // need more than just one rotation
            return rotateLeft(node);
        }
        // if the node is balanced, no rotation is needed
        return node;
    }

    /**
     * 
     * This method performs a right rotation of the given node to balance the
     * AVLtree.
     * A right rotation is performed on a node when its left subtree is heavier than
     * its right subtree.
     * 
     * @param node - the node to be rotated.
     * @return the new root node after the rotation.
     */

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.left;
        Node<T> centerNode = leftNode.right;
        // perform the right rotation by setting the new relationships between nodes
        leftNode.right = (node);
        node.left = (centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    /**
     * AVLtree.A left
     * rotation is
     * performed on
     * a node when
     * its right
     * subtree is
     * heavier than
     * its left subtree.
     * 
     * @param node - the node to be rotated.
     * @return the new root node after the rotation.
     */
    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.right;
        Node<T> centerNode = rightNode.left;
        rightNode.left = (node);
        node.right = (centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    /**
     * This method calculates the balance factor of an AVLtree node.
     * Balance factor is defined as the difference between the height of the left
     * and right subtrees of a node.
     * A balance factor of -1, 0, or 1 indicates that the node is balanced,
     * while a balance factor of 2 or -2 indicates that the node is unbalanced and
     * requires rebalancing.
     * 
     * @param node - the AVLtree node whose balance factor is being calculated.
     * 
     * @return the balance factor of the AVLtree node.
     */
    private int balance(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            // the balance factor is the difference between left and right heights
            return height(node.left) - height(node.right);
        }
    }

    /**
     * Min node of the given node
     */
    private Node<T> removeMinNode(Node<T> right) {

        while (right.left != null) {
            right = right.left;
        }
        return right;
    }

    @Override
    public void traverse() {
        printInorder(root);
    }

    /* Given an avlTree, print its nodes in inorder */
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

    private T getMax(Node<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    @Override
    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    @Override
    public T getMin() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            return null;
        }
        return removeMinNode(root).data;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(11);
        avlTree.insert(20);
        avlTree.insert(25);

        System.out.println("\nInOrder Traversal: ");
        avlTree.traverse();

        System.out.println("\nMax is: " + avlTree.getMax());
        System.out.println("Min is: " + avlTree.getMin());

        System.out.println("\nDeleting 11 ...");
        avlTree.delete(11);

        avlTree.traverse();

        System.out.println("\nMax is: " + avlTree.getMax());
        System.out.println("Min is: " + avlTree.getMin());

        System.out.println("\nDeleting 25 ...");
        avlTree.delete(25);

        avlTree.traverse();

        System.out.println("\nMax is: " + avlTree.getMax());
        System.out.println("Min is: " + avlTree.getMin());
    }

}
