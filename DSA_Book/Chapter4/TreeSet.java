import java.util.*;

class UnderflowException extends Exception {
};

// Approach:
// start from root
// pushAll from left to stack
// start poping
// When poping -> if has right -> push all left of it to stack and do again
// https:// www.youtube.com/watch?v=D2jMcmxU4bs

public class TreeSet<AnyType extends Comparable<? super AnyType>> {
    class BinaryNode<AnyType> {
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> parent;
        BinaryNode<AnyType> right;
        AnyType value;

        BinaryNode(AnyType theElement) {
            this(theElement, null, null, null);
        }

        public BinaryNode(AnyType value, BinaryNode<AnyType> left, BinaryNode<AnyType> right,
                BinaryNode<AnyType> parent) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.parent = parent;
        }
    }

    public java.util.Iterator<AnyType> iterator() {
        return new MyTreeSetIterator(root);
    }

    private class MyTreeSetIterator implements java.util.Iterator<AnyType> {
        private Stack<BinaryNode<AnyType>> stack = new Stack<BinaryNode<AnyType>>();

        public MyTreeSetIterator(BinaryNode root) {
            // TODO Auto-generated constructor stub
            pushAll(root);
        }

        private void pushAll(BinaryNode<AnyType> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return stack.isEmpty();
        }

        @Override
        public AnyType next() {
            // TODO Auto-generated method stub
            BinaryNode<AnyType> tmp = stack.pop();
            pushAll(tmp.right);
            return tmp.value;

        }
    }

}