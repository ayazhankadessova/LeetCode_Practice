April, 17

https://leetcode.com/problems/two-sum/description/ Two Sum 
1. Iterate through every element, check if target - nums[i] is in the HashTable
2. If there, return curr index & that index
3. If not. set to HashTable with key and index as value

Linear 

April, 18

MergeStringsAlternatively

Hashtable Insert O(1) * (m+n) = O(m+n)

Look up O(1) * (m+n) = O(m+n)

2 * O(m+n) ~ O(m+n)

https://leetcode.com/problems/merge-strings-alternately/description/?q=hash&orderBy=most_relevant
[didnt have to use hash, could use two pointers, just for pratice]

1. hash based on add order.
2. Append array that is not exhausted
3. Search based on iter order

https://github.com/ayazhankadessova/LeetCode_Practice/tree/main/LeetCodePlatform/HashTable/MergeStringsAlternatively

April, 19

https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/
Gifts from the richest pile

1. Use max heap to insert every gift 
2. delmax and put back remaining from max -sqrt(max)
3. keep iterating for k , find max every time [logN]
4. add all that is left [logN]

O(n+k*logn+n*logn)

https://github.com/ayazhankadessova/LeetCode_Practice/tree/main/LeetCodePlatform/Heap/GiftsFromRichestPile


