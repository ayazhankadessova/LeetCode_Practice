from array import array

# Approach:
# 1. Sort the array
# * Keep track of current length count (current) and longest length count (longest). Both starting at 0.
# * Loop through the sorted array with index a in ascending order
# 	* If (array[a] == array[a-1]), continue // duplicates do not count
# 	* If (array[a] - array[a - 1]) == 1, currentStreak += 1
# 	* Else:
# 		* longestStreak = Math.max(longestStreak, currentStreak)
# 		* currentStreak = 1 //Reset
# * Return Math.max(longestStreak, currentStreak)

# Time Complexity: O(n log n)
# Space Complexity: O(1)

# Brute Force:

# def longest_subsequence(data: array, right: int, left: int, counter) -> array:

#     counter_new = 1

#     # while right < len(data):
#     while data[left] - data[right] == 1:
#         counter_new += 1
#         left +=1
#         right += 1
#         if counter_new > counter:
#             counter = counter_new
#     if data[left] - data[right] == 1:
#         if right + 1 < len(data) -1:
#             longest_subsequence(data, right, right+1, counter)

#     print(counter)

class Solution:
    def longest_subsequence(self, array: array) -> int:
        # sort array
        array.sort()

        currentStreak = 1
        longestStreak = 0

        for i in range(1, len(array) -1 ):
            if  (array[i] == array[i-1]):
                continue # duplicates do not count
            if (array[i] - array[i - 1]) == 1:
                currentStreak += 1
            else:
                longestStreak = max(longestStreak, currentStreak)
                currentStreak = 1 #Reset
        return max(longestStreak, currentStreak)

    
d = Solution()
print(d.longest_subsequence([1, 9, 3, 10, 4, 20 , 2])) # 4
print(d.longest_subsequence([3, 9, 50, 2, 8, 4, 1])) # 4
print(d.longest_subsequence([1, 5, 29, 4, 3, 2, 1])) # 5 
