class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        
        # Base cases: 
        # 1) nothing -> return nothing
        if strs[0] == "":
            return ""
        # 2) only one word, return it
        if len(strs) < 2:
            return strs[0]
        # initiate an array to collect common prefixes
        results = []
        
        # get len of the shortest word, the prefix won't be longer than that
        len_words = [len(word) for word in strs]
        
        # get 1st string as base case, iterate for the same length as the shortest word
        for i in range(min(len_words) + 1):
            
            # if first _ chars of first string are same as first _ chars of all other strings,
            # append to list
            if (all(c[:i] == strs[0][:i] for c in strs[1:])):
                results.append(strs[0][:i])
                
        # choose the longest string from list
        return max(results, key = len)
        