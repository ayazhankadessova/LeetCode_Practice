## Daily (Numbers with same consecutive differences)

Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.

You may return the answer in any order.

* Example 1:

Input: n = 3, k = 7

Output: [181,292,707,818,929]

Explanation: Note that 070 is not a valid number, because it has leading zeroes.

* Example 2:

Input: n = 2, k = 1

Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]


## Task 1 (Reverse Words in a String III)

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

* Example 1:

Input: s = "Let's take LeetCode contest"

Output: "s'teL ekat edoCteeL tsetnoc"

* Example 2:

Input: s = "God Ding"

Output: "doG gniD"

## Task 2 (Design a Hash Set)

Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 

* Example 1:

Input

["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]

Output

[null, null, null, true, false, null, true, null, false]

Explanation

MyHashSet myHashSet = new MyHashSet();

myHashSet.add(1);      // set = [1]

myHashSet.add(2);      // set = [1, 2]

myHashSet.contains(1); // return True

myHashSet.contains(3); // return False, (not found)

myHashSet.add(2);      // set = [1, 2]

myHashSet.contains(2); // return True

myHashSet.remove(2);   // set = [1]

myHashSet.contains(2); // return False, (already removed)


## Task 3 (Design HashMap)

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.

void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already
 exists in the map, update the corresponding value.

int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.

void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 

* Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]

[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]

Output
[null, null, null, 1, -1, null, 1, null, -1]

* Explanation

MyHashMap myHashMap = new MyHashMap();

myHashMap.put(1, 1); // The map is now [[1,1]]

myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]

myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]

myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]

myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)

myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]

myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]

myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]


https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1140
https://leetcode.com/problems/numbers-with-same-consecutive-differences/