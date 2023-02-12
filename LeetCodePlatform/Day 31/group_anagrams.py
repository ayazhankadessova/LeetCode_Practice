class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        new_arr  = []
        for i in range(len(strs)):
            new_arr.append("".join(sorted(strs[i]))) 
        
        hashMap = {}
        for unique in list(set((new_arr))):
            hashMap[unique] = []
        
        for i in range(len(strs)):
            hashMap["".join(sorted(strs[i]))].append(strs[i])
            # if "".join(sorted(strs[i])) == 
            # new_arr.append("".join(sorted(strs[i]))) 
        
            
        return [*hashMap.values()]


# class Solution(object):
#     def groupAnagrams(self, strs):
#         ans = collections.defaultdict(list)
#         for s in strs:
#             ans[tuple(sorted(s))].append(s)
#         return ans.values()

# Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs. The outer loop has complexity 
# O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time.
# Space Complexity: O(NK), the total information content stored in ans. 