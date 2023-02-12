class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums = sorted(nums)
        count = 0
        i = 0
        while i < len(nums):
            # skip two
            count += nums[i]
            i += 2
        return count