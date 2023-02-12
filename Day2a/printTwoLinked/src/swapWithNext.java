// beforeP is the cell before the two adjacent cells that are to be swapped.
// Error checks are omitted for clarity.
public static void swapWithNext( Node beforep ) {
        Node p, afterp;
        p = beforep.next;
        afterp = p.next; // Both p and afterp assumed not null.
        p.next = afterp.next;
        beforep.next = afterp;
        afterp.next = p;
        }
