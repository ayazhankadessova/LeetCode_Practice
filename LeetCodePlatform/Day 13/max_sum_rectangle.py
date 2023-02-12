import bisect
import sys


class Solution:
    

    def maxSumSubmatrix(self, matrix, k):

        # Validation for corner case.
        if not matrix:
            return 0

        # Traditional kadane algorithm does not work 
        # here, as that algorithm always finds max sum
        # in a sub array and disregards intermediate sums
        # which needs to be considered for evaluating <=k criteria. 
        #
        # stores prefix sum values
        # in a sorted list and performs binary 
        # search on this list to get the closest
        # element whose difference with current element
        # does not exceed k. 
        
        def max_sum_array_no_larger_than_k(l, k):
            prefix_sums = [0]
            prefix_sum, max_sum = 0, -sys.maxsize
            for item in l:
                prefix_sum += item
                
                left = bisect.bisect_left(prefix_sums, prefix_sum - k)
                if left < len(prefix_sums):
                    max_sum = max(max_sum, prefix_sum - prefix_sums[left])
                   
               # This has a worst case complexity of O(n) 
                bisect.insort(prefix_sums, prefix_sum)
            return max_sum

        row_len = len(matrix)
        col_len = len(matrix[0])
        max_sum = -sys.maxsize
        
        # Below loops basically fold 2-d array into 
        # a single dimensional array, so that above 
        # function can be applied to it.
        # Here we iterate through all possible 2-d
        # arrays possible for every column. 
        for from_col in range(col_len):
            col_values = [0 for _ in range(row_len)]
            for to_col in range(from_col, col_len):
                for row in range(row_len):
                    col_values[row] = col_values[row] + matrix[row][to_col]
                curr_sum = max_sum_array_no_larger_than_k(col_values, k)
                max_sum = max(curr_sum, max_sum)
        return max_sum
        