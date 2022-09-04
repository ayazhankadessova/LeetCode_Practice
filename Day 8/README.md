## Daily Challenge (Reduce Array Size to The Half)
    
You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

* Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]

Output: 2

Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).

Possible sets of size 2 are {3,5},{3,2},{5,2}.

Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.

* Example 2:

Input: arr = [7,7,7,7,7,7]

Output: 1

Explanation: The only possible set you can choose is {7}. This will make the new array empty.

    
## Task 1(Pascal's Triangle)

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

* Example 1:

Input: numRows = 5

Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

## Task 2 (Spiral Matrix)

Given an m x n matrix, return all elements of the matrix in spiral order.

* Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]

Output: [1,2,3,6,9,8,7,4,5]

* Links:
https://leetcode.com/problems/reduce-array-size-to-the-half/
https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/