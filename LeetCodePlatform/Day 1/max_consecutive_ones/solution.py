class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        start = 0
        max_list = []
        for index, number in enumerate(nums): 
            if number == 0:
                start = index + 1 # start changes to the next value
            result = index - start + 1
            max_list.append(result)
        return max(max_list) # return the maximum of results 
    
    
# Improve:
# compare results with each iteration by adding new variable result in the beginning 
# & initializing to 0
# if new res is better than old, it changes. Else, remains
# returning the variable