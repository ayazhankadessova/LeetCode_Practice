class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        
        new_arr = set() # create new set
        
        # Sets are used to store multiple items in a single variable (integer, string, float)
        
        for num in arr:
            if num * 2.0 in new_arr or num / 2.0 in new_arr:
                return True
            new_arr.add(num)
        return False
    
# TC: O(N), N is length of an array
# SC: O(N), N is length of the set
    
#TC is high:
        
        #for i in range(len(arr)):
            #for j in range(len(arr)):
                #if arr[i] == arr[j] * 2 and i != j:
                    #return True   
        
                
        #return False