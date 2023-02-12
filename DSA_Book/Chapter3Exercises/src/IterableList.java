import java.util.Iterator;

public class IterableList<T> implements Iterable<T>, Iterator<T> {


    class Node {
        Node next;
        Node prev;
        T value;

        Node(T value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    Node current;
    int size;

    IterableList() {
        this.head = new Node(null);
        this.tail = new Node(null);
        head.next = tail;
        tail.prev = head;
    }

    public void append(T value) {
        Node curNode = head;
        while(curNode.next != tail) {
            curNode = curNode.next;
        }

        Node newNode = new Node(value);
        curNode.next = newNode;
        newNode.prev = curNode;
        newNode.next = tail;
        tail.prev = newNode;

        size++;

    }

    public void printLots(IterableList<T> list2) {

        for (T element: list2) {
            System.out.println(this.get(((Integer)element)).value);
        }

    }

    private Node get(int element) {

        int counter = 0;
        Node curNode = head;
        while(counter!=element) {
            curNode = curNode.next; 
            if (curNode.next==tail) {
                return new Node(null);
            }
            counter++;
        }
        return curNode;
    }

    @Override
    public Iterator<T> iterator() {
        current = head;
        // TODO Auto-generated method stub
        return this;
    }
    
    @Override
    public boolean hasNext() {
        return current.next!=tail;
        // TODO Auto-generated method stub
        // return false;
    }

    @Override 
    public T next() {
        current = current.next;
        // TODO Auto-generated method stub
        return current.value;
    }
    public static void main(String[] args) throws Exception {
        IterableList<Integer> iterList = new IterableList<Integer>();
        IterableList<Integer> iterList2 = new IterableList<Integer>();

        int[] arrayInt = {1, 3, 4, 6};
        int[] arrayInt2 = {1,2,3,4,5,6,7};

        for (int elem: arrayInt) {
            iterList.append(elem);
        }

        for (int elem: arrayInt2) {
            iterList2.append(elem);
        }

        for (Integer value : iterList) {
            System.out.println(value);
        }

        iterList.printLots(iterList2);

    }
}
