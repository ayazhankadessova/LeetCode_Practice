class Solution:
    def numsSameConsecDiff(self, N: int, K: int) -> List[int]:
        # START W list 1-10
        if N == 1:
            return range(0, 10)
        result = []
        
        def dfs(prev, number):
            if len(number) == N:
                result.append(int(number))
                return
            for digit in range(0, 10):
                if prev is None and digit == 0: continue
                if prev is None or abs(digit-prev) == K:
                    dfs(digit, number+str(digit))
        dfs(None, '')
        
        return result

#         # -------------------------------------------------
#         def dfs( N, K, cur_num):
            
#             if N == 0:
#                 # it is of n digits now, add current number to result
#                 result.append( cur_num )
#                 print(cur_num)
#                 return
            
#             last_digit = cur_num % 10
#             print(last_digit)
            
#             if last_digit + K < 10:
                
#                 # next digit = last digit + K
#                 next_num = 10 * cur_num + last_digit + K
#                 dfs( N-1, K, next_num)
            
#             if last_digit - K >= 0 and K != 0:
                
#                 # next digit = last digit - K
#                 next_num = 10 * cur_num + last_digit - K
#                 dfs( N-1, K, next_num)
#         # -------------------------------------------------        
        
#         result = []
        
#         if N == 1:
#             # special handle for corner case with N = 1
#             result.append( 0 )
        
#         for digit in range(1, 10):
#             dfs( N-1, K, cur_num=digit)
        
#         return result