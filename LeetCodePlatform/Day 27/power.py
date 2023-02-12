# Approach:
# Recursively multiply number by itself, keeping track or multiplication that happened
# + Consider case when num is negative & then gets multiplied -> becomes positive
# + Consider when power is negative, then multiply by 1/X
# + COnsider edge cases with 0 and 1

# TC: O(power)
# SC: O(1)

class Solution:
    def pow(self, x, n):

        if x == 0 or x == 1:
            return x
        elif n == 0:
            return 1
        def recursion(number, power):
            if power < n:
                if number < 0:
                    number = abs(number)
                number *= x
                power += 1
                
                return recursion(number, power)
            
            else:
                return number
        
        if n < 0:
            n = abs(n)
            x = 1/x
            print(x)

        return recursion(x, 1)

p = Solution()
print(p.pow(2.00000, -2))


## CodePath Solution:
# Break into base case where n = 0 or n = 1 and recurrent relations where n is even or odd numbers.
# def myPow(self, x, n):
#    if n == 0:
#        return 1

#    if n == 1:
#        return x

#    if n == -1:
#        return 1 / x

#    result = self.myPow(x, n // 2)

#    return result * result * (x if n % 2 else 1)
