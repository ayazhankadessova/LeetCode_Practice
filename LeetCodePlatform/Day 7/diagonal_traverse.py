class Solution:
    def findDiagonalOrder(self, mat):
        # if matrix is empty or no col, return empty array
        if not mat or not mat[0]:
            return []
        array = []
        m, n = len(mat), len(mat[0])
        # column - len of one row
        # move form top to bottom till lingest diagonal, then bottom to top
        # number of diagonals = num_rows + num_columns - 1
        diagonals = [[] for _ in range(m + n -1)]
        for i in range(m):
            for j in range(n):
                # based on coordinates, add to corresponding array 
                diagonals[i+j].append(mat[i][j])
        # start with the first array
        array_new = diagonals[0]
        
        for x in range(1, len(diagonals)):
            # if aray number is odd - add as it is, going to bottom
            if x % 2 == 1:
                array_new.extend(diagonals[x]) # extend means adding elemns, not an array.
            # even number - going up
            else:
                array_new.extend(diagonals[x][::-1]) # reverse 
                
        return array_new