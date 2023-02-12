from array import array


# Btrute force solution using is_palindrome for every every iteration unless we need a palindrome

def is_Polindrome(text):
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


class Solution:
    def is_palindrome(self, s: str) -> bool:
        if is_Polindrome(s) == True:
            return True
        else:
            for i in range(len(s)):
                result_1 = s[:i] + s[i+1:]
                if is_Polindrome(result_1) == True:
                    return True
        return False
                # return check(i, left, right, s)


p = Solution()
print(p.is_palindrome("abc"))

# left, right = 0, len(s) - 1 
# return check(i, left, right, s)
# def check(index_del, left, right, s):

#     if left == index_del:
#         left+=1
#     elif right == index_del:
#         right-=1

#     if s[left] != s[right]:
#         print(s[left], s[right])
#         return False

#     if (left - right !=2):
#         check(index_del, left+1, right-1, s)
#     return True

        