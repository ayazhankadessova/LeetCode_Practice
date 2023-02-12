class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        i = 0
        while i < len(arr):
            if arr[i] != 0:
                i+=1 # do nothing
            else:
                arr.insert(i+1, 0)
                i+=2 # skip added zero
                arr.pop() # remove one element from the end if we add smth, not to exceed limit
                
                
        