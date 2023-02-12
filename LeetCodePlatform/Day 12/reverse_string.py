class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        
        # if list has none or 1 string:
        # return w/o changes
        if len(s) < 2:
            return s
        
        # otherwise, use two-pointer technique 
        else:
            beginning = 0
            end = len(s) - 1
            
            # iterate through array while beginning and end don't meet
            while beginning < end:
                 
                # use temp to store value of left-er char
                temp = s[beginning] 
                
                # sawp
                s[beginning] = s[end]
                s[end] = temp
                
                beginning +=1
                end -=1
            return s
    
        # T(C): N/2 iterate for half an array
        # S(C): N + 1, created temp
    
        # Using built-in function:
        # return s.reverse()
        