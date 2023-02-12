class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        d=len(set(nums))
        x=sorted(set(nums))
        if d==2:
            return x[-1]
        elif d==1:
            return nums[0]
        else:
            return x[-3]