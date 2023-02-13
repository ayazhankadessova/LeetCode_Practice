import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;


// compare the items:
// if same -> add one of them -> advance both iterators
// if first item is smaller -> there is no chance to find it anymore, so advance
// if first item is larger -> there is chance to find it in list2, advance second iterator
// whe one of the lists is done, the whole process will be over

public class findIntersect<Antype> {


    public static <AnyType extends Comparable<? super AnyType>> void union(List<AnyType> L1, List<AnyType> L2,List<AnyType> Result){

        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();

        AnyType itemL1=null, itemL2=null;
        // get first item in each list
        if ( iterL1.hasNext() && iterL2.hasNext() ) {
        itemL1 = iterL1.next();
        itemL2 = iterL2.next();

        // both need to be not null
        while ( itemL1 != null && itemL2 != null) {

            int compareResult = itemL1.compareTo(itemL2);

            if (compareResult == 0){

                Result.add(itemL1);
                itemL1 = iterL1.hasNext()?iterL1.next():null; 
                itemL2 = iterL2.hasNext()?iterL2.next():null;
                // smaller one advances
            } else if (compareResult < 0) {
                itemL1 = iterL1.hasNext()?iterL1.next():null;
            } else {
                itemL2 = iterL2.hasNext()?iterL2.next():null;
            }

        }

        }
}

    public static <AnyType> void main(String[] args) {
        findIntersect TryOne = new findIntersect();
        List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> Result = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(1);
		list2.add(3);
		list2.add(5);
		list2.add(6);

        TryOne.union(list1, list2, Result);
        ListIterator<Integer> resultIter = Result.listIterator();
		while(resultIter.hasNext()){
			Integer item = resultIter.next();
			System.out.println(item);
		}
    }
    
}
