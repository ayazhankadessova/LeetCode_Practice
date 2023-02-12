class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        pointer = 0
        
        for i in range(len(nums)):
            if nums[i] != val:
                nums[pointer] = nums[i]
                pointer += 1
        return pointer
                    
        
        
# if number is val:
# put it in the beginning of an array where there are no vals
# pointer helps show the last index of non-val array part