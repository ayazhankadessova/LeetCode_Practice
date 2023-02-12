class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        maximum=max(nums)
        for num in nums:
            if num!=maximum:
                # If for some number, 2* num>maximum then we return -1 because the condition fails.
                if (2*num)>maximum:
                    return -1
        return nums.index(maximum)

# TC : O(n)
# SC : O(1)