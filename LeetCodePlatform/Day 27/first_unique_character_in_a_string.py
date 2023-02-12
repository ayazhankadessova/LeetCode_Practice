# Brute Force Approach:
# 1. Create a HashMap to store the number of occurences for every character in a string
# 2. If any character appears only once, return its index in the string
# 3. If no such cases, return -1

# we don't have to sort HashMap, but I did it to make iterations less, since if we meet 1, return it.

# TC: O(N)
# SC: O(1) - algo is iterating through const 26 bins, 26 English alpahbet letter


### LeetCode SOlution ###
# 1. Create a HashMap like mine to keep track of number of occurences
# 2. Instead of iterating throigh dict, iterate through string again & check num of occurence
# 3. If value is 1, return index
# 4. Else, return -1

# Two iterations w/ O(N) complexities each

class Solution:
    def firstUniqChar(self, s: str) -> int:
        HashMap = {}
        
        for i in range(len(s)):
            if s[i] in HashMap:
                HashMap[s[i]] +=1
            else:
                HashMap[s[i]] =1
                
        for i in range(len(s)):
            if HashMap[s[i]] == 1:
                return i
            
        return -1
        
                
        # print(HashMap)
        # sorted_dict = sorted(HashMap.items(), key=lambda x: x[1], reverse=True)
        # for key, value in sorted_dict:
        #     if value == 1:
        #         return s.index(key)
        # return -1
                
        # return next((k for k, v in input_dict.items() if v == value), None)
            
        