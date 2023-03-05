package BTree;

public class BTree {

    int m;
    Node root;

    // Create class for BTree Node
    public static class Node {
        int capacity;
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            insert(root, data);
        }
    }

    private void insert(Node root, int data) {
        Node x = root;

        while (x!= leaf) {
            if (data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }

            if (y!=full) {
                x = y;
            } else {
                y == full; -> split
                k<mid key in y: x -> y
                else : x -> z
                move key fro, y to its parent
            }
        }




        if (root == null) {
            root = new Node(data);
        } else {
            if (data < root.data) {
                // check full
                // 
                if (root.left == null) {
                    root.left = new Node(data);
                } else {
                    insert(root.left, data);
                }
            } else {
                if (root.right == null) {
                    root.right = new Node(data);
                } else {
                    insert(root.right, data);
                }
            }
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
