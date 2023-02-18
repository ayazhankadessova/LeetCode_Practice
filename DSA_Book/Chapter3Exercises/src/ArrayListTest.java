import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

private class ArrayListTest<AnyType> {

    /*
     * O(N)
     */
    public void addAll( Iterable<? extends AnyType> items ) {
        Iterator<? extends AnyType> iter = items.iterator(); 
        while ( iter.hasNext() ){
        this.add(iter.next());
      }
}

    /*
     * O(NM)
     */

    public void removeAll( Iterable<? extends AnyType> items ) {
        AnyType item, element;
        Iterator<? extends AnyType> iterItems = items.iterator();
            while ( iterItems.hasNext ( ) )
            {
        item = iterItems.next();
        Iterator<? extends AnyType> iterList = iterator(); 
        while ( iterList.hasNext ( ) )
        {
                element = iterList.next();
                if ( element.equals(item) )
                    iterList.remove();
                }
        } }

    private Iterator<? extends AnyType> iterator() {
        return this.iterator();
    }

    private void add(AnyType next) {
        this.add(next);
    }

    public static void main(String[] args) {

        ArrayList<String> colorlist = new ArrayList<>();
        colorlist.add("red");
        colorlist.add("green");
        colorlist.add("blue");
        colorlist.add("yellow");


        ArrayList<String> colorlist2 = new ArrayList<>();


        String[] colorlist3 = {"purple", "white"};
        for (String elem: colorlist3) {
            colorlist2.add(elem);
        }
        Collection<? extends String> colorlist4 = colorlist2;

        System.out.println("--------Color List 1: ----------");

        for (String color : colorlist) {
            System.out.println(color);
        }

        System.out.println("--------Color List 2: ----------");

        for (String color : colorlist2) {
            System.out.println(color);
        }

        colorlist.addAll(colorlist4);

        System.out.println("--------Color List 1 After AdAll: ----------");

        for (String color : colorlist) {
            System.out.println(color);
        }

        colorlist.removeAll(colorlist4);

        System.out.println("--------Color List 1 After RemoveAll: ----------");

        for (String color : colorlist) {
            System.out.println(color);
        }

    }
    
}
