import java.util.Iterator;

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
    public boolean reverse = false;

    /**
     *  Initialize an IterableList
     *  head and tail have no values
     *  Head's next is tail.
     *  Tail's prev is head.
     */
    JosephusIterableList() {
        this.head = new Node(null);
        this.tail =new Node(null);
        head.next = tail;
        tail.previous = head;
    }

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
        IterableList<String> list= new IterableList<>();
        String[] data = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for (String i : data)
            list.append(i);
        /// expected output: Mon Tue Wed Thu Fri Sat Sun
        for (String s: list)
            System.out.print(s + " ");
        System.out.println();
/// expeced output: Sun Sat Fri Thu Wed Tue Mon
        list.reverse = true;
        for (String s: list)
            System.out.print(s + " ");
        System.out.println();
/// expected output: Mon Tue Wed Thu Fri Sat Sun
        list.reverse = false;
        for (String s: list)
            System.out.print(s + " ");
        System.out.println();
    }
}
    
