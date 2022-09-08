from xmlrpc.client import Boolean


large_str = 'labaratory'
substring = 'labaratoryyyy'

class Solution:
    def substring(self, large_str: str, substring: str) -> Boolean:
        if len(substring) < 1:
            return False
        elif len(substring) > len(large_str):
            return False
        else:
            pointer1 = 0
            pointer2 = len(substring)
            stopping = len(large_str)+1

            while pointer2 != stopping:
                if large_str[pointer1:pointer2] == substring:
                    return True
                else:
                    pointer1 +=1
                    pointer2 +=1
            return False

def main():
    p = Solution()
    print(p.substring(large_str, substring))
  
  
if __name__ == '__main__':
    main()

# TC: O(n*m) iterate for m for every letter
# SC: O(1)


# CodePath solution:


# Loop through the first string for an initial match. If we find one, check that 
#     match for a full substring match.

# 1) Edge Check
# 2) Loop through the first string
# 3) Find a match to the first character of the second string
# 4) While there is a match, loop through both strings in parallel to ensure 
#     the match
# 5) If there is an entire match to the second string, return True (there is a 
#     substring)
# 6) If the match breaks, continue searching the first string for an initial 
#     character match
# 7) If we make it to the end of the first string without a full match, there 
#     is no substring match -- return False 


# def substring(large_str, potential_substr):
#     if len(potential_substr) < 1:
#         return True
#     for i in range(len(large_str)):
#         large_str_idx, j = i, 0
#         while j < len(potential_substr) and large_str_idx < len(large_str) and large_str[large_str_idx] == potential_substr[j]:
#             j += 1
#             large_str_idx += 1
#         if j + 1 == len(potential_substr):
#             return True
#     return False