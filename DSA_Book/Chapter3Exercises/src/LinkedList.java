

/*

3.2 Swap two given nodes of a linked list

1. if x and y are the same -> no change
2. Search for X, keep track of prevX and currX
3. Search for X, keep track of prevX and currX
4. Check if either x or y don't exist
5. If x not head -> prevX.next = currY. If head -> Y
6. Same for y
7. Swap next pointers 

*/
class Node {
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
 
class LinkedList {
    Node head; // head of list
 
    /* Function to swap Nodes x and y in linked list by
       changing links */
    public void swapNodes(int x, int y)
    {
        // 1. if x and y are the same -> no change
        if (x == y)
            return;

        // 2. Search for X, keep track of prevX and currX
        Node prevX = null;
        Node currentX = head;
        while (currentX!=null && currentX.data!=x) {
            prevX = currentX;
            currentX = currentX.next;
        }

        // 3. Search for Y, keep track of prevY and currY
        Node prevY = null;
        Node currentY = head;
        while (currentY!=null && currentY.data!=y) {
            prevY = currentY;
            currentY = currentY.next;
        }

        // 4. Check if either x or y don't exist

        if (currentX==null || currentY==null) {
            return;
        }

        // 5. If x not head -> prevX.next = currY. If head -> Y
        if (prevX!=null) {
            prevX.next = currentY;
        } else {
            head = currentY;
        }

        // 6. Same for y
        if (prevY!=null) {
            prevY.next = currentX;
        } else {
            head = currentX;
        }

        // 7. Swap next pointers 

        Node temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;


    }
 
    /* Function to add Node at beginning of list. */
    public void push(int new_data)
    {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);
 
        /* 2. Make next of new Node as head */
        new_Node.next = head;
 
        /* 3. Move the head to point to new Node */
        head = new_Node;
    }
 
    /* This function prints contents of linked list starting
       from the given Node */
    public void printList()
    {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
    }
 
    /* Driver program to test above function */
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
 
        /* The constructed linked list is:
            1->2->3->4->5->6->7 */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
 
        System.out.print(
            "\n Linked list before calling swapNodes() ");
        llist.printList();
 
        llist.swapNodes(4, 3);
 
        System.out.print(
            "\n Linked list after calling swapNodes() ");
        llist.printList();
    }
}
    
