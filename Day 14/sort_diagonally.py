class Solution:
    def diagonalSort(self, A):
        m, n = len(A), len(A[0])
        def sort(i, j):
            vals = []
            while i < m and j < n:
                vals.append(A[i][j])
                i += 1
                j += 1
            vals.sort()
            while i and j:
                j -= 1
                i -= 1
                A[i][j] = vals.pop()
        for i in range(m): sort(i, 0)
        for j in range(n): sort(0, j)
        return A
#         rows = len(mat)
#         cols = len(mat[0])
        
        
#         for i in range(rows, 0, -1):
#             # print(i)
#             start = i
#             leftest = 0
#             subarray = []
#             for x in range(1, rows-i+1):
#                 print(x)
#                 subarray.append(mat[start][leftest])
#                 start+=1
#                 leftest+=1
#                 print(subarray)
                
                
        
        