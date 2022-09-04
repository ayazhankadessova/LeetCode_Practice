class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        
        """
        
        # approach:
        # 1. reverse matrix
        # 2. transpose: change rows & cols
        
        # it's square -> # rows, cols -> same
        
        N = len(matrix)
        # can do for loop, but this is easier
        new_matrix = matrix.reverse()
        print(new_matrix)
        
        for row in range(N):
            for column in range( row):
                matrix[row][column], matrix[column][row] = matrix[column][row], matrix[row][column]
        
        
        # wont work bc values change
#         rows, columns = len(matrix), len(matrix[0])
        
#         for x in range(len(matrix)):
#             for i in range(len(matrix[0])):
#                 matrix[x][i] = matrix[rows-1-i][x]
                
#                 matrix[2][0] = matrix[2][3]
#                 matrix[2][1] = matrix[1][3]
#                 matrix[2][2] = matrix[0][3]
                
    
        