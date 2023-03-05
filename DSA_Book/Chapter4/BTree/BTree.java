package BTree;

public class BTree {

    int T;
    private Node root;

    // Create class for BTree Node
    public class Node {
        int height;
        int[] key = new int[2 * T - 1];
        Node[] children = new Node[2 * T];
        boolean leaf = true;

        public int Find(int k) {
            for (int i = 0; i < this.n; i++) {
                if (this.key[i] == k) {
                    return i;
                }
            }
            return -1;
        };
    }

    public BTree(int t) {
        this.T = t;
        root = new Node();
        root.height = 0;
        root.leaf = true;
    }

    // 1. Starting from the root node, compare k with the first key of the node.
    // If k = the first key of the node,return the node and the index.
    // 2. If k.leaf=true,return NULL (i.e. not found).
    // 3. If k < the first key of the root node, search the left child of this key
    // recursively.
    // 4. If there is more than one key in the current node and k > the first key,
    // compare k with the next key in the node.
    // If k < next key, search the left child of this key (ie. k lies in between the
    // first and the second keys).
    // Else, search the right child of the key.
    // 5. Repeat steps 1 to 4 until the leaf is reached.
    private Node Search(Node x, int key) {
        int i = 0;
        if (x == null) {
            return null;
        }
        for (i = 0; i < x.height; i++) {
            // process to next keys untill the value is less than the key
            if (key < x.key[i]) {
                break;
            } else if (key == x.key[i]) {
                return x;
            }
        }
        // if the node is leaf, return null -> not found
        if (x.leaf) {
            return null;
        } else {
            // else, search the children
            return Search(x.children[i], key);
        }
    }

    // public void insert(int data) {
    // if (root == null) {
    // root = new Node(data);
    // } else {
    // insert(root, data);
    // }
    // }

    // private void insert(Node root, int data) {
    // Node x = root;

    // while (x!= leaf) {
    // if (data < x.data) {
    // x = x.left;
    // } else {
    // x = x.right;
    // }

    // if (y!=full) {
    // x = y;
    // } else {
    // y == full; -> split
    // k<mid key in y: x -> y
    // else : x -> z
    // move key fro, y to its parent
    // }
    // }

    // if (root == null) {
    // root = new Node(data);
    // } else {
    // if (data < root.data) {
    // // check full
    // //
    // if (root.left == null) {
    // root.left = new Node(data);
    // } else {
    // insert(root.left, data);
    // }
    // } else {
    // if (root.right == null) {
    // root.right = new Node(data);
    // } else {
    // insert(root.right, data);
    // }
    // }
    // }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
