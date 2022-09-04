class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        for i in range(len(arr)-1):
            
            max_value = max(arr[i+1:])
            arr[i] = max_value

        arr[len(arr) - 1] = -1
        return arr


# Iterate through each elem and check for max number on right