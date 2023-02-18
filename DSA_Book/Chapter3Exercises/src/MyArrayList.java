import java.util.ListIterator;

/*
 * Approach:
 * 
 * 1. Create private class withing MyArrayList names ArrayListIterator and make it implement ListIterator interface.
 * 2. Complete given methods using current, ArrayList and functions in array list OR throw UnsupportedOperationException.
 * 3. Add, so that listIterator method to returns a newly constructed ListIterator. Further, the existing iterator method can 
 * return a newly constructed ListIterator:
 * 
 * ```
 *  public java.util.Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    public java.util.ListIterator<AnyType> listIterator() {
        return new ArrayListIterator();
    }
 * ```
 */

public class MyArrayList<AnyType> implements Iterable<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;

    private AnyType[] theItems;
    private int theSize;

    /**
     * Construct an empty ArrayList.
     */
    public MyArrayList() {
        clear();
    }

    /**
     * Returns the number of items in this collection.
     * 
     * @return the number of items in this collection.
     */
    public int size() {
        return theSize;
    }

    /**
     * Returns true if this collection is empty.
     * 
     * @return true if this collection is empty.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the item at position idx.
     * 
     * @param idx the index to search in.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public AnyType get(int idx) {
        if (idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException("Index " + idx + "; size " + size());
        return theItems[idx];
    }

    /**
     * Changes the item at position idx.
     * 
     * @param idx    the index to change.
     * @param newVal the new value.
     * @return the old value.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public AnyType set(int idx, AnyType newVal) {
        if (idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException("Index " + idx + "; size " + size());
        AnyType old = theItems[idx];
        theItems[idx] = newVal;

        return old;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize)
            return;

        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++)
            theItems[i] = old[i];
    }

    /**
     * Adds an item to this collection, at the end.
     * Using function which adds an item to this collection, at the specified index.
     * 
     * @param x any object.
     * @return true.
     */
    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    /**
     * Adds an item to this collection, at the specified index.
     * Iterativerly mobe items while we reach index.
     * 
     * @param e any object.
     * @return true.
     */

    public void add(int idx, AnyType e) {
        if (theItems.length == size())
            ensureCapacity(size() * 2 + 1);

        for (int i = theSize; i > idx; i--)
            theItems[i] = theItems[i - 1];

        theItems[idx] = e;
        theSize++;
    }

    /**
     * Removes an item from this collection.
     * 
     * @param idx the index of the object.
     * @return the item was removed from the collection.
     */
    public AnyType remove(int idx) {
        AnyType removedItem = theItems[idx];

        for (int i = idx; i < size() - 1; i++)
            theItems[i] = theItems[i + 1];
        theSize--;

        return removedItem;
    }

    /**
     * Change the size of this collection to zero.
     */
    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * Obtains an Iterator object used to traverse the collection.
     * 
     * @return an iterator positioned prior to the first element.
     */
    public java.util.Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    public java.util.ListIterator<AnyType> listIterator() {
        return new ArrayListIterator();
    }

    /**
     * Returns a String representation of this collection.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");

        for (AnyType x : this)
            sb.append(x + " ");
        sb.append("]");

        return new String(sb);
    }

    /**
     * This is the implementation of the ArrayListIterator.
     * It maintains a notion of a current position and of
     * course the implicit reference to the MyArrayList.
     */

    private class ArrayListIterator implements ListIterator<AnyType> {

        private int current = 0;
        boolean backwards = false;

        @Override
        public void add(AnyType e) {
            MyArrayList.this.add(current++, e);

        }

        @Override
        public boolean hasNext() {
            return current < size();
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
            return (AnyType) theItems[current++];
        }

        @Override
        public int nextIndex() {
            throw new java.lang.UnsupportedOperationException();
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
            throw new java.lang.UnsupportedOperationException();
        }

        @Override
        public void remove() {
            if (backwards)
                MyArrayList.this.remove(current--);
            else
                MyArrayList.this.remove(--current);

        }

        @Override
        public void set(AnyType e) {
            MyArrayList.this.set(current, e);

        }

    }

    public static void main(String[] args) {
        MyArrayList<Integer> lst = new MyArrayList<Integer>();

        System.out.println("Adding to ArrayList: ");
        for (int i = 0; i < 10; i++)
            lst.add(i);

        System.out.println(lst);

        System.out.println("Adding at the front, as the specified index is 0 : ");

        for (int i = 20; i < 30; i++)
            lst.add(0, i);

        System.out.println(lst);

        System.out.println("Removing the first element : ");
        lst.remove(0);
        System.out.println(lst);

        System.out.println("Removing the last element : ");
        lst.remove(lst.size() - 1);

        System.out.println(lst);
    }
}
