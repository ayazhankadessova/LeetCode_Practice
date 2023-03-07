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

    // Insertion Operation

    // 1. If the tree is empty, allocate a root node and insert the key.
    // 2. Update the allowed number of keys in the node.
    // 3. Search the appropriate node for insertion.If the node is full, follow the
    // steps below.
    // - Insert the elements in increasing order.Now,there are elements greater than
    // its limit.
    // - So, split at the median.
    // - Push the median key upwards and make the left keys as a left child and the
    // right keys as a right child.
    // If the node is not full, follow the steps below.Insert the node in increasing order.

    public void insert(int key) {
        Node r = root;
        if (r == null) {
            r = new Node();
            r.key[0] = key;
            r.height = 1;
        } else {
            if (r.height == 2 * T - 1) {
                Node s = new Node();
                root = s;
                s.leaf = false;
                s.height = 0;
                s.children[0] = r;
                splitChild(s, 0, r);
                insertNonFull(s, key);
            } else {
                insertNonFull(r, key);
            }
        }

    }

    // insert node
    final private void _insert(Node x, int k) {

        if (x.leaf) {
            int i = 0;
            // insert the key in the right position
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
                x.key[i + 1] = x.key[i];
            }
            x.key[i + 1] = k;
            x.n = x.n + 1;
        } else {
            // if the node is not leaf, find the right child
            int i = 0;
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
            }
            ;
            i++;
            Node tmp = x.child[i];
            // if the child is full, split it
            if (tmp.n == 2 * T - 1) {
                split(x, i, tmp);
                if (k > x.key[i]) {
                    i++;
                }
            }
            _insert(x.child[i], k);
        }

    }

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
