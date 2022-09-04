class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if k == 0:
            return nums

        for i in range(k):
            last = nums.pop()
            nums.insert(0, last)
        return nums
        
# TC: O(k)
    
            