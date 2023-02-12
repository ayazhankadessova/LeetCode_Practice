class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        
        # get the total sum of the array elems to reduce calculations
        total = sum(nums)
        sum_left = 0
        for i in range(len(nums)):
            sum_right = total - sum_left - nums[i]
            if sum_left == sum_right:
                return i
            sum_left += nums[i]
        
        return -1
        
        
# Long:

# sum_left = 0
# sum_right = 0
# for i in range(len(nums)):
#    if i == 0:                
#        sum_left = 0
#        sum_right = total - sum_left - nums[i]
#    elif i == len(nums) - 1:
#        sum_right = 0
#        sum_left += nums[i-1]
#    else: 
#        # use previous calculations
#        sum_left += nums[i-1]
        # right sum = total - left - current num
#        sum_right = total - sum_left - nums[i]
#    print(sum_left, sum_right)
#    if sum_left == sum_right:
#        return i
# return -1