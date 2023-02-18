import java.util.Iterator;

/*
 * Assume that a singly linked list is implemented with a header node, but no tail node, and that it maintains only a reference to the header node. Write a class that includes methods to
a. return the size of the linked list
b. print the linked list
c. test if a value x is contained in the linked list
d. add a value x if it is not already contained in the linked list 
e. remove a value x if it is contained in the linked list

Approach:

1. Initilize head
2. Initialize head.next
3. Contains: iter with while and checl
4. add: check if contains, if not, create p and p.next = head.next; head.next = p; add in the middle
5. remove: check if contains. Do tracing node and current node. When found node to remove -> prev.next = current.next

 */

public class SLL_headeronly_sorted<T> implements Comparable<T> {

    private Node header;
    int size;
    
    SLL_headeronly_sorted() {
        header = new Node(null);
        size = 0;
        header.next = null;
    }


    class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
        }
    }

    public int getSize() {
        return size;
    }
    
    public void printList() {
        Node current;
        if (header.next!= null) {
            current = header.next;
        } else {
            return;
        }
        
        while (current!= null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    boolean contains( T data ){
    Node p = header.next;
    while (p != null) {
      if (data.equals(p.data)) {
        return true;
      }      else {
        p = p.next;
      }
    }
    return false;
    }

    boolean add( T data ) {
    if (contains(data))
      return false;
      else {
      Node p = new Node(data);
        if (p.data.compareTo(header.next.data) ) {
             p.next = header.next;
      header.next = p;
        }


      p.next = header.next;
      header.next = p;
      size++;
    }
    return true;
  }


  /*
   * Set a node which will trace the previous elem and when we find an item to delete make the tracer point to deleted's next node.
   */
    public void remove(T data) {
        if (!contains(data)) {
            System.out.println("Data not found");
            return;
        } else {

            Node previous = header;
            Node current = header.next;

            while (!current.data.equals(data)) {
                // System.out.println(previous.data);
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
            size--;

        }
        

    }

    public static void main(String[] args) {

        SLL_headeronly_sorted<Integer> iterList = new SLL_headeronly_sorted<Integer>();

        int[] arrayInt = {1, 3, 4, 6, 3};

        for (int elem: arrayInt) {
            iterList.add(elem);
        }

        iterList.printList();
        System.out.println("Get the size of the list: " + iterList.size);
        System.out.println("Contains 9: " + iterList.contains(9));
        iterList.remove(1);
        System.out.println("Get the size of the list: " + iterList.size);
        iterList.remove(10);
        
    }
}
