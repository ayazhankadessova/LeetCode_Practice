class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        
        if len(nums) < 2:
            return nums
        else:
            pointer1 = 0
            # pointer2 = 0
            
            for i in range(len(nums)):
                if nums[i] % 2 == 0:
                    temp = nums[pointer1]
                    nums[pointer1] = nums[i]
                    nums[i] = temp
                    pointer1 += 1
            return nums
        
# TC: O(N) - length of an array
# SC: O(1) - didnt create anything news except temp

# Logic:

# 1. Iterate through array.
# 2. When even number, put it in the rightest index (index starts with 0, +=1 when swaps)

# Leetcode Solutions:

# Method 1 (Sort):
# class Solution(object):
#     def sortArrayByParity(self, A):
#         A.sort(key = lambda x: x % 2)
#         return A

# Method 2 (Two pass): Write all the even elements, then all odd elements

# class Solution(object):
#     def sortArrayByParity(self, A):
#         return ([x for x in A if x % 2 == 0] +
#                 [x for x in A if x % 2 == 1])

