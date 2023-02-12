## Daily Challenge (Unique Morse Code Words)

International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

'a' maps to ".-",

'b' maps to "-...",

'c' maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]

Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.

Return the number of different transformations among all words we have.

 
* Example 1:

Input: words = ["gin","zen","gig","msg"]

Output: 2

Explanation: The transformation of each word is:

"gin" -> "--...-."

"zen" -> "--...-."

"gig" -> "--...--."

"msg" -> "--...--."

There are 2 different transformations: "--...-." and "--...--.".

* Example 2:

Input: words = ["a"]

Output: 1

## Task 2 ( Largest Number At Least Twice of Others)

You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.

* Example 1:

Input: nums = [3,6,1,0]

Output: 1

Explanation: 6 is the largest integer.

For every other number in the array x, 6 is at least twice as big as x.

The index of value 6 is 1, so we return 1.

* Example 2:

Input: nums = [1,2,3,4]

Output: -1

Explanation: 4 is less than twice the value of 3, so we return -1.


## Task 3(Plus One)

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

* Example 1:

Input: digits = [1,2,3]

Output: [1,2,4]

Explanation: The array represents the integer 123.

Incrementing by one gives 123 + 1 = 124.

Thus, the result should be [1,2,4].

* Example 2:

Input: digits = [4,3,2,1]

Output: [4,3,2,2]

Explanation: The array represents the integer 4321.

Incrementing by one gives 4321 + 1 = 4322.

Thus, the result should be [4,3,2,2].

## Task 4(Diagonal TRaverse)

Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

![Screnshot](/Users/ayazhan/Desktop/aug apply/LeetCode[Daily]/Day 7/Screenshot.png)

* Example 1:


Input: mat = [[1,2,3],[4,5,6],[7,8,9]]

Output: [1,2,4,7,5,3,6,8,9]

Example 2:

Input: mat = [[1,2],[3,4]]

Output: [1,2,3,4]

Longest

Based on coordinate points sum add to array of that index.

1) till longest diagonal - add as it is

2) after longest diagonal - reverse ass

number_of_diagonals = m + n - 1


https://www.youtube.com/watch?v=0DnG0Kc9M2E
