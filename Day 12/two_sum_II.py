class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:

        # initialize left, right pointers
        # Check if the sum of the contents of the pointers are more or less than the target.
        left, right = 0, len(numbers) - 1
        while left < right:
        # If more than, decrement the right pointer.
            if (numbers[left] + numbers[right] < target):
                left += 1
            # If less than, increment the left pointer.
            if (numbers[left] + numbers[right] > target):
                right -= 1
            # If they are equal, return the indexes, which would be 1 plus the left and the right poiner for this particular question.
            if (numbers[left] + numbers[right] == target):
                return [left + 1, right + 1]     
            
        