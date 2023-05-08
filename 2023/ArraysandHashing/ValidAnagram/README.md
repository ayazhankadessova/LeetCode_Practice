Check length of two words
Make two hashmaps to keey track of number of occurences of each character in the string

Then, iterate through first string and see if the character occurence matches one of the second word.

If all match, since length is same, then anagram.

TC: O(S + t) -> iterate through both of the strings
SC: O(t + s) -> hashmaps can be a s big as length of both words.

Better SC if we use sort and check if sorted strings match.
but SC may be nlogn or n^2
