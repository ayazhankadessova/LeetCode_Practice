class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        # m - rowns, n - columns
        m, n = len(matrix), len(matrix[0])
        # initialize four pointers - top, bottom, right, left
        top, bottom = 0, m
        right, left = n, 0
        
        array = []
        
        while top < bottom and left < right:
            
            # get every ith element of the current top row
            for i in range(left, right):
                array.append(matrix[top][i])
            # top column shifts down
            top += 1
            
            # get every ith element of the rightest column
            for i in range(top, bottom):
                array.append(matrix[i][right-1]) # get leftest element of every row that was not visited
            # move right to left
            right -= 1
            
            if not(top < bottom and left < right): # both cond must be true
                break
            
            # get every ith element of the current bottom row
            for i in range(right-1, left-1, -1): # to get the leftest index, because not inclusive, !reverse
                array.append(matrix[bottom-1][i])
            # bottom column to up
            bottom -= 1
            
            # get every ith element of the current leftest row
            for i in range(bottom-1, top-1, -1): # to get the leftest index, because not inclusive, !reverse
                array.append(matrix[i][left])
            # bottom column to up
            left += 1
            
        return array