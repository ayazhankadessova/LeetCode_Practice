import java.util.ListIterator;

import apple.laf.JRSUIConstants.Size;

// public class Main<AnyType> {
//     public java.util.Iterator<AnyType> iterator() {
//         return new ArrayListIterator();
//     }

//     public java.util.ListIterator<AnyType> listIterator() {
//         return new ArrayListIterator();
//     }
// }

public class ArrayListIterator<AnyType> implements ListIterator<AnyType> {

    private int current = 0;
    boolean backwards = false;

    @Override
    public void add(AnyType e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean hasNext() {
        return current < this.size();
    }

    private int size() {
        return this.size();
    }

    @Override
    public boolean hasPrevious() {
        return current > 0;
    }

    @Override
    public AnyType next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();
        backwards = false;
        return theItems[current++];
    }

    @Override
    public int nextIndex() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public AnyType previous() {
        if (!hasPrevious())
            throw new java.util.NoSuchElementException();
        backwards = true;
        return theItems[--current];
    }

    @Override
    public int previousIndex() {
        MyArrayList.this.add(current++, x);
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub

    }

    @Override
    public void set(AnyType e) {
        // TODO Auto-generated method stub

    }

}
