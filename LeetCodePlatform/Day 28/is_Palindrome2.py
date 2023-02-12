from operator import index
import string


# Approach:

# 1. Iterate through string by comparing characters at left and right index
# 2. If we see inconsistency, check whether a string is palindrome by deleting either the character present at left or right index. (only delete one char)
# 3. If no inconsistency -> True

# TC: O(N)
# SC: O(1)

class Solution:
    def is_Palindrome(self, s: str) -> bool:

        def is_palindrome(left, right, count):

            # can't delete more than one character
            if count > 1: 
                return False
            
            # iterate through string, if we see inconsistency, try skipping and checking, but not more than once
            while left < right:
                if s[left] != s[right]:
                    return is_palindrome(left+1, right, count +1) or is_palindrome(left, right-1, count+1)

                left += 1
                right -= 1

            return True

        return is_palindrome(0, len(s) -1, 0)

p = Solution()
print(p.is_Palindrome("aba"))