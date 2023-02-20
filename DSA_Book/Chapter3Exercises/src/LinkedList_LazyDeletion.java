
/*

3.2 Lazy Deletion

*/
class Node<AnyType> {
    AnyType data;
    Node next;
    Boolean Marked;
    // set to 1 if deleted, and 0 otherwise

    Node(AnyType d) {
        data = d;
        next = null;
        Marked = false;
    }
}

class LinkedList_LazyDeletion<AnyType> {
    Node head; // head of list

    int Total_Count = 0; // the total number of elements in the list
    int Deleted_Count = 0; // the total number of deleted elements

    /* Function to add Node at beginning of list. */
    public void push(int new_data) {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);

        /* 2. Make next of new Node as head */
        new_Node.next = head;

        /* 3. Move the head to point to new Node */
        head = new_Node;
    }

    /*
     * Finds node with specified data.
     */
    Node Find(AnyType X) {
        Node P = this.head;
        while (P != null && (P.data != X || P.Marked == true))
            P = P.next;
        return P;
    }

    /*
     * Finds Node to delete and marks it as deleted.
     */
    void Lazy_Deletion(AnyType X) {
        Node P;
        P = Find(X);
        System.out.println("Deleted: " + P.data);
        if (P != null) {
            P.Marked = true;
            Deleted_Count++;
            if (Total_Count - Deleted_Count == Deleted_Count)
                // the number of deleted elements is the same as the number
                // of nondeleted elements in the list
                Deletion();
        }
    }

    boolean IsLast(Node P) {
        return P.next == null;
    }

    void Deletion() {
        Node P, Previous, TmpCell;
        if (head.Marked == true) {
            this.head = head.next;
        }

        Previous = this.head;
        P = head.next;

        while (!IsLast(P)) {
            System.out.println("Prev:" + Previous.data);
            System.out.println("P:" + P.data);

            if (P.Marked) {
                TmpCell = P;
                P = P.next;
                Previous.next = P;
                // free(TmpCell);
                Total_Count--;
                Deleted_Count--;
            } else {
                Previous = P;
                P = P.next;
            }
        }

        // if last item deleted
        if (P.next == null && P.Marked == true) {
            // System.out.println(Previous);
            Previous.next = null;
        }
    }

    /*
     * This function prints contents of linked list starting
     * from the given Node
     */
    public void printList() {
        Node tNode = head;
        while (tNode != null) {
            // if (tNode.Marked != true) {
            System.out.print(tNode.data + " ");
            // }
            tNode = tNode.next;
        }
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        LinkedList_LazyDeletion llist = new LinkedList_LazyDeletion();

        /*
         * The constructed linked list is:
         * 1->2->3->4->5->6->7
         */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.print(
                "\n Linked list");
        llist.printList();

        System.out.print(
                "\n Lazy Deletion: ");

        llist.Lazy_Deletion(4);
        llist.Lazy_Deletion(5);
        llist.Lazy_Deletion(2);
        llist.Lazy_Deletion(1);
        llist.Lazy_Deletion(7);
        llist.Deletion();

        System.out.print(
                "\n Linked list after deletion");
        llist.printList();
    }
}
