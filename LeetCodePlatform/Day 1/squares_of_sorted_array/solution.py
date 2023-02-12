class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        # non decreasing -> asc
        result_array = []
        l, r = 0, len(nums) -1
        while l<=r: # while pointers haven't crossed each others
            if abs(nums[l]) > abs(nums[r]):
                result_array.append(nums[l] ** 2) # append integer to the beginning of the list
                l+=1
            else:
                result_array.append(nums[r] ** 2)
                r-=1
        return result_array[::-1]
    
# Approach 1: Find smallest (0), and start comparing what's one the left and write iteratively
# Approach 2 (USING): Find the biggest (beginning/end of array), initialize left/right pointers, start # filling from the end (right pointer). Till left & right pointers at the same value
# Built in in one path: through input array: O(n) time complexity

    
# Legacy:   
# Slow:

# import numpy as np
#     squared_nums = [number**2 for number in nums]
#     squared_nums = np.sort(squared_nums)
#     return squared_nums

# Improved:

# 1. Delete result_array,insert(0, nums[l] ** 2)
# To insert an element at the start of an Array, we'll need to shift all other elements in the Array to the right by one index to create space for the new element.
# This is a very costly operation, since each of the existing elements has to be shifted one step to the right. The need to shift everything implies that this is not a constant
# time operation. In fact, the time taken for insertion at the beginning of an Array will be proportional to the length of the Array. In terms of time complexity analysis, this is a linear time complexity: 
# O(N), where N is the length of the Array.

# 2. reverse like this: result_array[::-1]