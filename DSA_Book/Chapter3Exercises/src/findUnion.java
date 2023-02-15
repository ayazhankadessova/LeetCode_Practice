import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;

```
Given two sorted lists, L1 and L2, write a procedure to compute L1 ∪ L2 using only the basic list operations.

1. Initialize iterators for two lists
2. Get the first element of the list
3. While at least of the elements are not null, continue.

- different from intersection because union means all the elems in both, no duplicates tho

4. if one of the elements is null, get everything from the other list

- eg: elem1 is null -> collect all elements that are left in list2

5. if both are not null: compare them

- if elem1 is smaller -> advance it, because we will not meet it again and there is no danger we will add it twice
- if elem1 is bigger -> advance iter2, because there is a change that we meet elem1 duplicate is list2 later

6. Iterate through res
```

public class findUnion<Antype> {


    public static <AnyType extends Comparable<? super AnyType>> void union(List<AnyType> L1, List<AnyType> L2,List<AnyType> Result){

        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();

        AnyType itemL1=null, itemL2=null;
        // get first item in each list
        if ( iterL1.hasNext() && iterL2.hasNext() ) {
        itemL1 = iterL1.next();
        itemL2 = iterL2.next();

        // while at least in one list there is smth left
        while ( itemL1 != null || itemL2 != null) {

            // if List one is done, get everything from List2 now
            if (itemL1 == null) {
                Result.add(itemL2);
                itemL2 = iterL2.hasNext()?iterL2.next():null;

            } else if (itemL2 == null) {
                Result.add(itemL1);
                itemL2 = iterL2.hasNext()?iterL2.next():null;
            } else {

            int compareResult = itemL1.compareTo(itemL2);

            if (compareResult == 0){
                Result.add(itemL1);
                itemL1 = iterL1.hasNext()?iterL1.next():null; 
                itemL2 = iterL2.hasNext()?iterL2.next():null;
                // smaller one advances
            } else if (compareResult < 0) {
                Result.add(itemL1);
                itemL1 = iterL1.hasNext()?iterL1.next():null;
            } else {
                Result.add(itemL2);
                itemL2 = iterL2.hasNext()?iterL2.next():null;
            }

        }

        }
}

}

    public static <AnyType> void main(String[] args) {
        findUnion TryOne = new findUnion();
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
