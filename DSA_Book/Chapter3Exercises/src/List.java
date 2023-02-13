import java.io.*;
import java.util.ListIterator;
public class List<AnyType>
{
   
    // head nodes for pointing to 1st and 2nd linked lists
    Node a = null, b = null;
   
    // dummy node for storing intersection
   Node dummy = null;
   
    // tail node for keeping track of
  // last node so that it makes easy for insertion
    Node tail = null;
     
    // class - Node
    class Node<Antype> {
        AnyType data;
        Node next;
 
        Node(AnyType data) {
            this.data = data;
            next = null;
        }
    }
     
    // function for printing the list
    void printList(Node start) {
        Node p = start;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
     
    // inserting elements into list
    void push(AnyType data) {
        Node temp = new Node(data);
        if(dummy == null) {
            dummy = temp;
            tail = temp;
        }
        else {
            tail.next = temp;
            tail = temp;
        }
    }
     
     
public static <AnyType extends Comparable<? super AnyType>> void union(List<AnyType> L1, List<AnyType> L2,List<AnyType> Result){

        ListIterator<AnyType> iterL1 = L1.listIterator();

    }

    public static <AnyType> void main(String[] args) {
        // // findUnion TryOne = new findUnion();
        // List<AnyType> L1 = new List<AnyType>();
        // List<AnyType> L2 = new List<AnyType>();
        // List<AnyType> Result = new List<AnyType>();

        // int[] arr1 = {1, 2, 3, 4, 5};
        // int[] arr2 = {2, 4, 5, 6};

        // for (int elem : arr1) {
        //     L1.push(elem);
        // }

        // for (int elem : arr2) {
        //     L2.push(elem);
        // }

        // findUnion(L1, L2, Result);
    }

    public ListIterator<AnyType> listIterator() {
        return null;
    }
}