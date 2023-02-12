class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        even_len = 0 # keep count of numbers who have even number of digits
        for number in nums:
            length = len(str(number)) # make it str to know length
            if length % 2 == 0:
                even_len += 1 # add to the count
        return even_len