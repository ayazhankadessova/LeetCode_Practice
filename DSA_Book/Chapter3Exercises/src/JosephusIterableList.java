import java.util.Iterator;

/*
 * Josephus Problem Approach:
 * 1. Create a Doubly Linked List
 * 2. Start with head, iterate while only one element is left
 * 3. skip specified number of times
 * 4. If while skipping we reach a tail, then we start from the head.next
 * 5. Delete element -> reassign next/prev
 * 6. When only one element is left, then return head.next
 * 
 */
public class JosephusIterableList<T> implements Iterator<T>, Iterable<T> {

    /**
     * Node class
     */
    class Node {
        Node next;
        Node previous;
        T value;

        Node(T value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    // keep track of what we are iterating
    Node current;
    int size;
    int skip;

    /**
     *  Initialize an IterableList
     *  head and tail have no values
     *  Head's next is tail.
     *  Tail's prev is head.
     */
    JosephusIterableList(int m) {
        this.head = new Node(null);
        this.tail =new Node(null);
        this.skip = m;
        head.next = tail;
        tail.previous = head;
    }

    /*
     * Josephus problem driver
     */
    public T josephusProblem() {
        Node start = head.next;
        while (size>1) {
            int i = 0;
            while(i < skip) {
                if (start.next==null) {
                    start=head.next;
                    System.out.println("Next is null");
                }
                System.out.println(start.value);
                start = start.next;
                i++;
            }
            if(start == head) {
                start=start.next;
            } else if (start == tail) {
                start=head.next;
            }
            System.out.println("Deleting: " + start.value);
            this.delete(start);
            start = start.next;
            
            size--;
            System.out.println("size" + size);
        }
        
        return head.next.value;
    }

    // public T getRem

    /**
     * Appends a value to the doubly Linked list's end
     * Increment size.
     * @param value
     */
    public void append(T value) {
        Node current = head;
        while(current.next !=tail) {
            current = current.next;
        }
        Node newNode = new Node(value);
        current.next = newNode;
        newNode.previous = current;
        //current.next.next = tail;
        newNode.next = tail;
        tail.previous = current.next;
        size++;
    }

    public void delete(Node node) {
        node.previous.next = node.next;
        System.out.println("Next Value reassigned: "+ node.previous.next.value);
        if( node.next != null) {
            node.next.previous = node.previous;
        }
        
    }

    /**
     *  Cursor -> start with head or tail
     *  Change with next
     * @return this - since IterableList is also Iterator -> return it
     */
    @Override
    public Iterator<T> iterator() {

        if (!reverse) {
            current = head;
        } else {
            current = tail;
        }
        return this;
    }

    @Override
    public boolean hasNext() {

        if (!reverse) {
            return current.next!=tail;
        }
        return current.previous !=head;
    }

    @Override
    public T next() {
        if (!reverse) {
            current = current.next;
            return current.value;
        }
        current = current.previous;
        return current.value;
    }

    public static void main(String[] args) {
        JosephusIterableList<Integer> list= new JosephusIterableList<>(1);
        int[] data = {1, 2, 3, 4, 5};
        for (int i : data)
            list.append(i);
        

        System.out.println("Joesphus Problem with " +list.skip + " skips: " + list.josephusProblem());
    }
}
    
