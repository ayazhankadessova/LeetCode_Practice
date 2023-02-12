# from itertools import groupby
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        
        ## Approach:
        ## create a HashMap and map first string values to last string values and check their correspondance
        mapST, mapTS = {}, {}
        
        for c1, c2 in zip(s, t):
            if ((c1 in mapST and mapST[c1] != c2) or (c2 in mapTS and mapTS[c2] != c1)):
                return False
            
            mapST[c1] = c2
            mapTS[c2] = c1
        return True
        
        
        
    
        # s_list = list(s)
        # occurrences_s = collections.Counter(s_list)
        # values_s = list(occurrences_s.values())
        
        # t_list = list(t)
        # occurrences_t = collections.Counter(t_list)
        # values_t = list(occurrences_t.values())
        
        
        # if values_s == values_t:
        #     return True
        # return False
        