class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        
    # Approach (backwards, not checking every node): DEPTH FIRST SEARCH. start from oceans!
    # 1. see which nodes can reach pacific ocean -> 1st rows, 1st column
    # 2. see which nodes can reach atlantic ocean -> last row, last column
    # 3. get the common ones
    # 4. Dont visit cells twice
    # 5. GO to cells of => heights bc going backwards
    # O(n*m)  

        m, n = len(heights), len(heights[0])
        
        # get two hash sets to maintain the position of atlantic & pacific oceans
        pacific, atlantic = set(), set()
        
        
        # dfs function marks all nodes that can visit atlantic OR pacific
        def dfs(r,c,visited, prevHeight):
            # if visited or out of bounds or less than prev height
            
            if((r,c) in visited or r == m or c == n or r<0 or c<0 or heights[r][c] < prevHeight):
                return 
            # else
            visited.add((r,c))
            
            # run dfs on neighbours
            dfs(r+1,c,visited, heights[r][c])
            dfs(r-1,c,visited, heights[r][c])
            dfs(r,c-1,visited, heights[r][c])
            dfs(r,c+1,visited, heights[r][c])
            
        # for first row & last row
        for column in range(n):
            # first row - pacific
            dfs(0, column, pacific, heights[0][column])
            # last row - atlantic
            dfs(m-1, column, atlantic, heights[m-1][column])
        
        # for first column & last column 
        for row in range(m):
            # leftest column - pacific
            dfs(row, 0, pacific, heights[row][0])
            # rightest column - atlantic
            dfs(row, n-1, atlantic, heights[row][n-1])
            
        # check for every cell, if it is both in pacific & atlantic
        return pacific & atlantic
#         res = []
#         for row in range(m):
#             for column in range(n):
#                 if (row,column) in pacific and (row,column) in atlantic:
#                     res.append([row, column])
                    
#         return res
        
#         # for 
#         m, n = len(matrix), len(matrix[0])
        
#         pacific_coord = []
#         for i in range(0, n):
#             coord = [0]
#             coord.append(i)
#             pacific_coord.append(coord)  
            
#         for x in range(0, m):
#             coord = [x]
#             coord.append(0)
#             pacific_coord.append(coord)
            
            
#         print(pacific_coord)
            
#         atlantic_coord = []
#         for y in range(0, n):
#             coord = [m-1]
#             coord.append(y)
#             atlantic_coord.append(coord)  
            
#         for z in range(0, m):
#             coord = [n-1]
#             coord.append(z)
#             atlantic_coord.append(coord)
            
#         print(atlantic_coord)
        
#         def check(coord_x, coord_y):
#             if matrix[coord_x][coord_y-1] < matrix[coord_x][coord_y]:
#                 coord_x, coord_y = coord_x, coord_y-1
#                 check(coord_x, coord_y)
#             elif matrix[coord_x][coord_y+1] < matrix[coord_x][coord_y]:
#                 coord_x, coord_y = coord_x, coord_y+1
#                 check(coord_x, coord_y)
#             elif matrix[coord_x-1][coord_y] < matrix[coord_x][coord_y]:
#                 coord_x, coord_y = coord_x-1, coord_y
#                 check(coord_x, coord_y)
#             elif matrix[coord_x+1][coord_y] < matrix[coord_x][coord_y]:
#                 coord_x, coord_y = coord_x+1, coord_y
#                 check(coord_x, coord_y)
#             if [coord_x, coord_y] in atlantic_coord or pacific_coord:
#                 return True
            
#         for i in range(2, m-2):
#             for j in range(2, n-2):
#                 print(check(i, m))
                
                

        
    
        