class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        
        # special cases 
        if numRows == 1:
            return [[1]]
        elif numRows == 2:
            return [[1],[1,1]]
        else:
            # initialize array
            array = [[1],[1,1]]
            for i in range(2, numRows):
                array.append([1])
                # getting the sum of pair values from before array
                array[i].extend([array[i-1][x-1] + array[i-1][x] for x in range(1, i)])
                array[i].extend([1])
        return array