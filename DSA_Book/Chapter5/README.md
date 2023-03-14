| Exercise  | Problem | Approach | Solution | Day | 
| ------------- | ------------- | ------------- | ------------- | ------------- | 
| ![#c5f015](https://placehold.co/15x15/c5f015/c5f015.png) 5.3 | Write a program to compute the number of collisions required in a long random sequence of insertions using linear probing, quadratic probing, and double hashing. [Linear Probing: done; Quadratic Probing: done; Double Hashing: done; Separate Chaining: done] | Linear Probing:</br> 1. Iterate through every item </br> 2. Initialize notplaced to be true </br>3. If the slot is empty, place item, make notplaced false </br>4. If the item is not placed, place it in the next available slot while notplaced is true </br>5. If the item is not placed, increment the number of collisions. </br> Quadratic Probing: same, but add `place+=Math.pow(i,2)`.</br> Double Hashing: When collision, find next slot using `place = Initialplace + i * HashFunction2(number)`. HashFunction2 can be specified in the method. Separate Chaining: </br>2. If the slot is empty, create a new LinkedList </br> `SepChainHashTable[Initialplace % HashTable.length] = new LinkedList<Integer>();`</br>3. Add the item to the LinkedList </br>4. If the slot is not empty, add the item to the LinkedList </br>5. The LinkedList will be created in the HashTable array| [Solution](https://github.com/ayazhankadessova/LeetCode_Practice/blob/main/DSA_Book/Chapter5/HashTable.java) | March, 12 / 13 / 14 | 

- ![#c5f015](https://placehold.co/15x15/c5f015/c5f015.png) `Easy`
- ![#1589F0](https://placehold.co/15x15/1589F0/1589F0.png) `Medium`
- ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) `Hard`

- Resources 
1. HashTables: https://www.youtube.com/watch?v=KyUTuwz_b7Q
