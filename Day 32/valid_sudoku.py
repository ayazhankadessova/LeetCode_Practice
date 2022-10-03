class Solution:   
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        box = {}
        for i in range(len(board)):
            vertical = {}
            horizontal = {}
            for j in range(len(board)):
                if board[i][j] not in horizontal and board[i][j] != ".":
                    horizontal[board[i][j]] = j
                elif board[i][j] in horizontal:
                    return False

                if board[j][i] not in vertical and board[j][i] != ".":
                    vertical[board[j][i]] = i
                elif board[j][i] in vertical:
                    return False
                

                # Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
                if (board[i][j], i//3, j//3) not in box and board[i][j] != ".":
                    box[(board[i][j], i//3, j//3)] = 1
                elif (board[i][j], i//3, j//3) in box:
                    return False
        return True

p = Solution()
print(p.isValidSudoku([["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]))