class Solution:
    def validMountainArray(self, arr):
        # Since middle value is max value of an array
        middle_value = max(arr)
        
        # If the first element is max element, return False
        if arr[0] == middle_value:
            return False
        # If last element is max element, return False
        if arr[-1] == middle_value:
            return False
        
        # status increasing = 0, status decreasing = 1
        status = 0
        
        for i in range(len(arr)):
            # When encountering max elen, change status to decreasing
            if arr[i] == middle_value:
                status = 1
            # Increasing status,
            if status == 0:
                # If element before is less than element ahead, continue
                if arr[i] < arr[i+1]:
                    continue
                # if when increasing it's not true, return False
                else:
                    return False
            
            # Decreasing status
            if status == 1:
                if i + 1 != len(arr):
                    # If element before is more than element ahead, continue
                    if arr[i] > arr[i+1]:
                        continue
                    else:
                        return False
        # if everything is ok
        return True


# Logic:

# Create status, default = 0 (increasing), iterate through array, when u see max, change status to 1, 
# iterate through array, checking if next value is smaller, if till the end of array everything is ok, 
# return True