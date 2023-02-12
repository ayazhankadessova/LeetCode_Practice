## Task 1 (Check if N and its Double Exist)

Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

i != j

0 <= i, j < arr.length

arr[i] == 2 * arr[j]
 

* Example 1:

Input: arr = [10,2,5,3]

Output: true

Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.

* Link:

https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/ 


## Task 2 (Valid mountain Array)

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3

There exists some i with 0 < i < arr.length - 1 such that:

arr[0] < arr[1] < ... < arr[i - 1] < arr[i]

arr[i] > arr[i + 1] > ... > arr[arr.length - 1]


* Example 1:

Input: arr = [2,1]

Output: false

* Link:

https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/

## Task 3 (Replace Elements with Greatest Element on Right Side)

Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

 


Example 1:

Input: arr = [17,18,5,4,6,1]

Output: [18,6,6,6,1,-1]

* Explanation: 

- index 0 --> the greatest element to the right of index 0 is index 1 (18).

- index 1 --> the greatest element to the right of index 1 is index 4 (6).

- index 2 --> the greatest element to the right of index 2 is index 4 (6).

- index 3 --> the greatest element to the right of index 3 is index 4 (6).

- index 4 --> the greatest element to the right of index 4 is index 5 (1).

- index 5 --> there are no elements to the right of index 5, so we put -1.

* Link:

https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/