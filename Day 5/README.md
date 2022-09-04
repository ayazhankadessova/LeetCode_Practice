## Task 1 (Move Zeroes)

Given an integer array nums, move all 0's to the end of it while maintaining the relative order

of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 
* Example 1:

Input: nums = [0,1,0,3,12]

Output: [1,3,12,0,0]

* Links:

https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/ 

## Task 2 (Sort Array By Parity)

Given an integer array nums, move all the even integers at the beginning of the array followed by 

all the odd integers.

Return any array that satisfies this condition.

* Example 1:

Input: nums = [3,1,2,4]

Output: [2,4,3,1]

Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

## Task 3 (Third Max Number)

Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

* Example 1:

Input: nums = [3,2,1]

Output: 1

Explanation:

The first distinct maximum is 3.

The second distinct maximum is 2.

The third distinct maximum is 1.

* Link:

https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/ 


## Tas 4 (Word Ladder II):

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.

Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord

Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists.
 
Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]

Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]

Explanation: There are 2 shortest transformation sequences:

"hit" -> "hot" -> "dot" -> "dog" -> "cog"

"hit" -> "hot" -> "lot" -> "log" -> "cog"

* Link:

https://leetcode.com/problems/word-ladder-ii/