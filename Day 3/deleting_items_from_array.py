class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums)<2:
            return len(nums)
        
        pre = 0
        for cur in range(1,len(nums)):
            if nums[cur]!=nums[pre]:
                pre+=1
                nums[pre]=nums[cur]

        return pre+1

# # Next time:
# 1. Read all the elements like we did before, to identify the duplicates. We call this our readPointer.
# 2. Keep track of the next position in the front to write the next unique element we've found. We call this our writePointer.