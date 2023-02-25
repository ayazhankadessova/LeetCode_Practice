import java.util.*;

class UnderflowException extends Exception {
};

// Approach:
// start from root
// pushAll from left to stack
// start poping
// When poping -> if has right -> push all left of it to stack and do again
// https:// www.youtube.com/watch?v=D2jMcmxU4bs

public class MyTreeSet<AnyType extends Comparable<? super AnyType>> {
    class BinaryNode<AnyType> {
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> parent;
        BinaryNode<AnyType> right;
        AnyType element;

        BinaryNode(AnyType theElement) {
            this(theElement, null, null, null);
        }

        public BinaryNode(AnyType value, BinaryNode<AnyType> left, BinaryNode<AnyType> right,
                BinaryNode<AnyType> parent) {
            this.left = left;
            this.right = right;
            this.element = value;
            this.parent = parent;
        }
    }

    public java.util.Iterator<AnyType> iterator() {
        return new MyTreeSetIterator();
    }

    private class MyTreeSetIterator implements java.util.Iterator<AnyType> {
        private BinaryNode<AnyType> current = findMin(root);
        private BinaryNode<AnyType> previous;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
        private boolean atEnd = false;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return !atEnd;
        }

        @Override
        public AnyType next() {
            // TODO Auto-generated method stub
            if (modCount != expectedModCount)
                throw new java.util.ConcurrentModificationException();

            if (!hasNext())
                throw new java.util.NoSuchElementException();

            AnyType nextItem = current.element;
            previous = current;

            // if there is a right child, next node is min in right subtree if
            // (current.right != null)
            if (current.right != null) {
                current = findMin(current.right);
            } else {
                // else, find ancestor that it is left of BinaryNode<AnyType> child = current;
                BinaryNode<AnyType> child = current;
                current = current.parent;
                while (current != null && current.left != child) {
                    child = current;
                    current = current.parent;
                }
                if (current == null)
                    atEnd = true;
            }
            okToRemove = true;
            return nextItem;
        }

        public void remove() {
            if (modCount != expectedModCount)
                throw new java.util.ConcurrentModificationException();
            if (!okToRemove)
                throw new IllegalStateException();
            MyTreeSet.this.remove(previous.element);
            okToRemove = false;
        }
    }

    public MyTreeSet() {
        root = null;
    }

    public void makeEmpty() {
        modCount++;
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        else
            return findMin(root).element;
    }

    public AnyType findMax() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        else
            return findMax(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x, root, null);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true; // match
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t == null)
            return null;

        else if (t.right == null)
            return t;
        return findMax(t.right);
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t,
            BinaryNode<AnyType> pt) {
        if (t == null) {
            modCount++;
            return new BinaryNode<AnyType>(x, null, null, pt);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = insert(x, t.left, t);
        else if (compareResult > 0)
            t.right = insert(x, t.right, t);
        else
            ; // duplicate
        return t;
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return t; // not found
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else

        {
            modCount++;
            BinaryNode<AnyType> oneChild;
            oneChild = (t.left != null) ? t.left : t.right;
            oneChild.parent = t.parent; // update parent link
            t = oneChild;
        }
        return t;
    }

    private BinaryNode<AnyType> root;
    int modCount = 0;

    public static void main(String[] args) {
        MyTreeSet<Integer> set = new MyTreeSet<Integer>();
        set.insert(1);
        set.insert(2);
        set.insert(8);
        set.insert(9);
        set.printTree();

    }
}