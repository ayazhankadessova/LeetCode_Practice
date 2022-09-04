## Daily (Vertical Order Traversal of a Binary Tree)

Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

* Example 1:

Input: root = [3,9,20,null,null,15,7]

Output: [[9],[3,15],[20],[7]]

Explanation:

Column -1: Only node 9 is in this column.

Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.

Column 1: Only node 20 is in this column.

Column 2: Only node 7 is in this column.


## Task 1(Contains Duplicate)

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

* Example 1:

Input: nums = [1,2,3,1]
Output: true


# Task 2(Single Number)

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]

Output: 1

* Link:

https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1112 
https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1176