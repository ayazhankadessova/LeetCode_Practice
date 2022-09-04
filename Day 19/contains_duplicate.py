# Approach:
# 1. Iterate each value & insert the value into the set
# 2. If the value has already been in the hash set, there is a duplicate

# one liner : check if set(nums) has less elements that just nums: 
# return len(nums) != len(set(nums))

# T(C): O(N)
# S(C): O(N)

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        check = set()
        for num in nums:
            if num not in check:
                check.add(num)
            else:
                return True
        return False

        