## Exercise 3.1

You are given a list, L, and another list, P, containing integers sorted in ascending order. The operation printLots(L,P) will print the elements in L that are in positions specified by P. For instance, if P = 1, 3, 4, 6, the elements in positions 1, 3, 4, and 6 in L are printed. Write the procedure printLots(L,P). You may use only the public Collections API container operations. What is the running time of your procedure?

## Exercise 3.2 Swap two given nodes of a linked list

1. if x and y are the same -> no change
2. Search for X, keep track of prevX and currX
3. Search for X, keep track of prevX and currX
4. Check if either x or y don't exist
5. If x not head -> prevX.next = currY. If head -> Y
6. Same for y
7. Swap next pointers

## Exercise 3.4 Find Intersection

Given two sorted lists, L1 and L2, write a procedure to compute L1 ∩ L2 using only the basic list operations.

Logic:

1. Initialize iterators for two lists
2. Get the first element of the list
3. While both of the items is not null, iterate through the list and compare values
4. If values are the same, add them to the Result list
5. If compareTo returns negative, value1 is less, and there is no chance to meet it in the sort array, so advance iter1
6. If compareTo return positive, value1 is more, we can still meet it in list2, so advance iter2
7. When advancing check if we can advance with hasNext. If no next -> return null and while loop will stop
8. Iter through result list

## Exercise 3.5 Find Union

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
