
class Solution(object):
    def moveZeroes(self, nums):
        n = len(nums)
        pointer1 = 0
        pointer2 = 0
        while pointer2<n:
            if nums[pointer2] == 0:
                pointer2 = pointer2+1
            else:
                temp = nums[pointer1]
                nums[pointer1] = nums[pointer2]
                nums[pointer2] = temp
                pointer1 = pointer1+1
                pointer2 = pointer2+1
                    
# Logic:

# 2 pointer technique:
# 1. Take two pointers, pointing to the start of an array.
# 2. If 0, increment pointer1, pointer2 stays.  
# 3. if != 0, swap values at two ponters and increment both.
# 4. Swapping till 0 squeezes to the end.

# SLow:
# if len(nums) < 2:
#    pass
# else:
#    for i in range(len(nums)):
#        if nums[i] == 0:
#            nums.remove(0)
#            nums.append(0)