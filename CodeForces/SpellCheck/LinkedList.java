// package CodeForces.SpellCheck;

public class LinkedList {

    Node head = null;
    int count;

    class Node {

        int number;
        Node next;

        public Node(int number) {
            this.number = number;
            this.next = null;
        }
    }

    public void add(int number) {
        Node newNode = new Node(number);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        count++;
    }

    public int getCount() {
        return count;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.number + " ");
            temp = temp.next;
        }
    }

    public LinkedList() {
        this.head = null;
    }

}
