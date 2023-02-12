import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/* 

3.1 You are given a list, L, and another list, P, containing integers sorted in ascending order. 
The operation printLots(L,P) will print the elements in L that are in positions specified by P. 
For instance, if P = 1, 3, 4, 6, the elements in positions 1, 3, 4, and 6 in L are printed. Write the procedure printLots(L,P). 

1. Initialize iterators
2. Initialize count, initialize positionP
3. For every position, iter array and check if position=index
4. print
*/

public class printLots {

    public static void main(String args[]) {
        System.out.println("Chapter_3_1");
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.add("E");
        list1.add("F");
        list1.add("G");
        list1.add("H");

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(3);
        list2.add(7);
        list2.add(8);
        list2.add(9);

        printLots(list1, list2);
    }

    public static <AnyType> void printLots(List<AnyType> L, List<Integer> P) {

        Iterator<AnyType> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();

        AnyType itemL= null;
        Integer Pposition;
        int count = 0;

        while(iterP.hasNext()) {
            Pposition = iterP.next();
            System.out.println("Looking for " + Pposition);

            while(count < Pposition && iterL.hasNext()) {
                count++;
                itemL = iterL.next();;
            }
            if (count == Pposition) {
                System.out.println(itemL);
            }
            else {
                System.out.println(Pposition + "is excess length");
            }
        }
    }
    }