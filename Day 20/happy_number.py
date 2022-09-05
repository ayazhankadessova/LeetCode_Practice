class Solution:
    def isHappy(self, num: int) -> bool:
        # Approach 2: using set
        seen = set()
        while int(num)!=1 and int(num) not in seen:
            # add number to seen
            seen.add(int(num))
            # initialze to 0
            sum_square = 0
            # get sum of squares
            for x in str(num):
                sum_square += int(x)**2
            num = str(sum_square)

            print(seen)
        return int(num) == 1

# As another example, let's start with 
# 116. By repeatedly applying the squaring and adding process, we eventually get to 
# 58, and then a bit after that, we get back to 58. Because we are back at a number we've already 
# seen, we know there is a cycle, and therefore it is impossible to ever reach 1. So for  116 the function should return false.

# Based on our exploration so far, we'd expect continually following links to end in one of three ways.

# It eventually gets to 
# 1.
# It eventually gets stuck in a cycle.
# It keeps going higher and higher, up towards infinity.

# def isHappy(self, n: int) -> bool:

#     def get_next(n):
#         total_sum = 0
#         while n > 0:
#             n, digit = divmod(n, 10)
#             total_sum += digit ** 2
#         return total_sum

#     seen = set()
#     while n != 1 and n not in seen:
#         seen.add(n)
#         n = get_next(n)

#     return n == 1

# TC: O(1)
# SC: ?

        
        
        
        # Approach 1: Brute force
        # give 10 iters, iterate through cases
        # adding = 0
        # allow = 0
        # while adding != 1 and allow !=10:
        #     my_list = [int(x) for x in str(n)]
        #     print(my_list)
        #     adding = sum([x**2 for x in my_list])
        #     n = adding
        #     allow +=1
        #     if allow == 10:
        #         break
        #     if adding == 1:
        #         return True
        # return False
            
        