class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # Use XOR sum
        # number XOR number = 0
        # number XOR 0 = number
        
        # TC: O(N)
        # SC: O(1)
        
        # 4 ^ 1 ^ 2 ^ 1 ^ 2
        # =   4 ^ 1 ^ 1 ^ 2 ^ 2      (commutativity)
        # =   4 ^ (1 ^ 1) ^ (2 ^ 2)  (associativity)
        # =   4 ^ 0 ^ 0
        # =   4
        standard = 0
        for number in nums:
            standard = number ^ standard
            
        return standard
    
        # # check = set(nums)
        # from collections import Counter
        # counts = dict(Counter(nums))
        # for num in counts:
        #     if counts[num] == 1:
        #         return num
            