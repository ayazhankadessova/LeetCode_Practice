class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # 1. get all adj neighbours of an island
        # 2. mark them as visited
        
        # Breadth-First Search is a recursive algorithm to search all the vertices of a graph or a tree. BFS in python can be               # implemented by using data structures like a dictionary and lists. Breadth-First Search in tree and graph is almost the same
        
        if not grid:
            return 0
        
        rows, cols = len(grid), len(grid[0])
        visit = set()
        islands = 0
        
        # not a recursive algo, but iterative. we need a data structure to use for memory -> queue 
        def bfs(r, c):
            
            # add cell we are going to visit to our queue
            q = collections.deque()
            visit.add((r, c)) # tuple
            q.append((r, c))
            
            # while queue isn't empty, expand the island
            while q: 
                row, col = q.pop()
                
                # pop from the queue. check the adj positions of the position that we just popped
                # dir righ [1,0]. dir to left [-1, 0]. dir above [0, 1]. dir below [0, -1]

                directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
                
                # move to diff directions
                for dr, dc in directions:
                    r, c = row + dr, col + dc
                    
                    # check if everything is in range & if the cell is 1. add to the queue, we can run bfs on the cell 
                    # mark it visited, so we don't visit it twice


                    if (r in range(rows) and c in range(cols) and grid[r][c] == '1' and (r, c) not in visit):
                        q.append((r, c))
                        visit.add((r,c))
                        
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1' and (r, c) not in visit:
                    bfs(r,c)
                    islands += 1
        return islands
                        
         
        # possible changes:
        
        # pop first element added -> depth-first search 
 
        
        # bugs:
        
        # set -> use add, not append