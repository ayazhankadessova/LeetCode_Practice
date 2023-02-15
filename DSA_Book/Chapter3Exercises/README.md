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

## [Exercise 3.6 Josephus Problem (Feb, 15)](https://github.com/ayazhankadessova/LeetCode_Practice/blob/main/DSA_Book/Chapter3Exercises/src/JosephusIterableList.java)

The Josephus problem is the following game: N people, numbered 1 to N, are sitting in a circle. Starting at person 1, a hot potato is passed. After M passes, the person holding the hot potato is eliminated, the circle closes ranks, and the game continues with the person who was sitting after the eliminated person picking up the hot potato. The last remaining person wins. Thus, if M = 0 and N = 5, players are eliminated in order, and player 5 wins. If M = 1 and N = 5, the order of elimination is 2, 4, 1, 5.

- Josephus Problem Approach:

1. Create a Doubly Linked List
2. Start with head, iterate while only one element is left
3. skip specified number of times
4. If while skipping we reach a tail, then we start from the head.next
5. Delete element -> reassign next/prev
6. When only one element is left, then return head.next

## Exercise 3.9/ 3.10: Collections addAll() and removeAll()

Provide an implementation of an addAll method for the MyArrayList class. Method addAll adds all items in the specified collection given by items to the end of the MyArrayList. Also provide the running time of your implementation. The method signature for you to use is slightly different than the one in the Java Collections API, and is as follows:

```
 public void addAll( Iterable<? extends AnyType> items )
```

- Approach:

1. Given iterable items list, get the iterator and add while hasNext()

- This runs in O(N) time, where N is the size of the items collection.

Provide an implementation of a removeAll method for the MyLinkedList class. Method removeAll removes all items in the specified collection given by items from the MyLinkedList. Also provide the running time of your implementation. The method signature for you to use is slightly different than the one in the Java Collections API, and is as follows:

```
public void removeAll( Iterable<? extends AnyType> items )
```

- Approach:

1. Given iterable items list, get the iterator and check everything in the specified collection
2. Get the iterator for original list and iterate through it to check if this elements exists there too. If yes, remove it from the original collection.

- This runs in O(MN), where M is the size of the items, and N is the size of the list.
