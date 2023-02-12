class Solution:
    def plusOne(self, digits):
        for i in range(len(digits)):
            # check starting from last
            if digits[~i] < 9:
                digits[~i] += 1
                return digits
            # if last int was 9, make everything 0
            digits[~i] = 0
            
        return [1] + digits 