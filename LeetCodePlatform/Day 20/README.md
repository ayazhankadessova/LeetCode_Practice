## Task 1(Intersection of Two Arrays)

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]

Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]

Output: [9,4]

Explanation: [4,9] is also accepted.

## Task 2(Happy Number)

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

## Task 3(Two Sum)

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

* Example 1:

Input: nums = [2,7,11,15], target = 9

Output: [0,1]

Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

* Example 2:

Input: nums = [3,2,4], target = 6

Output: [1,2]


* Example 1:

Input: n = 19

Output: true

Explanation:

12 + 92 = 82

82 + 22 = 68

62 + 82 = 100

12 + 02 + 02 = 1

* Example 2:

Input: n = 2

Output: false


## Daily (N-ary Tree Level Order Traversal)

Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

* Example 1:

Input: root = [1,null,3,2,4,null,5,6]

Output: [[1],[3,2,4],[5,6]]

* Example 2:

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]

Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]

* Link:
https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1105/ 
https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1131 
https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1115
https://leetcode.com/problems/n-ary-tree-level-order-traversal/  