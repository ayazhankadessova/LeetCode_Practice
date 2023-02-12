class Solution:
    def permute(self, nums):
        ans = []
        
        def backtrack(cur, shown):
            if len(cur) == len(nums):
                ans.append(cur.copy())
            
            for n in nums:
                if n not in shown:
                    cur.append(n)
                    shown.add(n)
                    backtrack(cur, shown)
                    cur.pop()
                    shown.remove(n)
        
        backtrack([], set())
        return ans