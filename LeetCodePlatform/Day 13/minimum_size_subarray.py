class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        if sum(nums) < target:
            return 0
        left, total = 0, 0
        
        # base value. 
        
        # res - min length
        res = float("inf")
        
        for right in range(len(nums)):
            # each time we add a new value to the pointer, add it to total
            total += nums[right]
            
            # if total more or same as target, get size of the window
            while total>=target:
                
                # size of the window is eaither current window or res (whichever smaller) 
                res = min(right-left+1, res)
                
                # decrement total by left value
                # nums 
                total -= nums[left]
                # incr left pointer
                left +=1
        # if res doesnt change, return 0        
        return 0 if res == float("inf") else res
            
    
        
    
                    
        