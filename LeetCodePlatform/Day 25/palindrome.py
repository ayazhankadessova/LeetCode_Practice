class Solution:
    def isPolindrome(self, text: str) -> bool:
        chars_list = [char for char in text.lower()]
        chars_list = [c for c in chars_list if c.isalpha()]

        if len(chars_list) < 1:
            return True
        if len(chars_list) == 1:
            return True

        # using two pointers to check till middle of the list
        x = len(chars_list) - 1
        for i in range((len(chars_list) // 2) + 1):
            if chars_list[i] != chars_list[x]:
                return False
            x -= 1
        return True

# Time Complexity: O(n): Traversing is done for almost every character, untill the pointers meet in the middle or if the required condition is not true we return early. Time complexity will be O(n) (where n is the length of the given string).

# Space Complexity: O(1): We do not need any extra memory here.

        # Another approach but creates extra memory
        # reversed_chars = chars_list[::-1]
        # if reversed_chars == chars_list:
        #     print('True')
        # else:
        #     print('False')

# Testing
# Expected, met
# True, True, False
P = Solution()
print(P.isPolindrome("A man, a plan, a canal: Panama"))
print(P.isPolindrome("  "))
print(P.isPolindrome("HELLO"))
