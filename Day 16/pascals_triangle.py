class Solution:
    def getRow(self, rowIndex: int) -> List[int]:

        if rowIndex == 0: return [1]
        
        # start the triangle
        res = [[1]] 
        
        for i in range(rowIndex):
            temp = [0] + res[-1] + [0] # contact 0's & previous row
            row = []
            for j in range(len(res[-1]) + 1):
                row.append(temp[j] + temp[j + 1]) # add two consec 
            res.append(row)
        return res[rowIndex]
        
#         triangle =[[1]]

#         for i in range(1,rowIndex+1):

#             new_arr = [1]
#             new_arr.extend([triangle[i-1][x] + triangle[i-1][x+1] for x in range(i-1)])
#             new_arr.append(1)
#             triangle.append(new_arr)


#         return triangle[rowIndex]
            
        