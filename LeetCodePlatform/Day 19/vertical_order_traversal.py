# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    # Approach:
    # 1. Create dictionary: column: (row, value)
    # 2. sort based on keys
    # 3. sort based on rows
    # same row + same col: sort by value
    
    def verticalOrder(self, root, horizontal, vertical, values):
        if not root:
            return
        elif horizontal in values:
            values[horizontal].append((vertical, root.val))
        else:
            values[horizontal] = [(vertical, root.val)]
            
        self.verticalOrder(root.left, horizontal-1, vertical+1, values)
        self.verticalOrder(root.right, horizontal+1, vertical+1, values)
            
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        vertical = 0
        horizontal = 0
        values = {}
        result = []
        
        self.verticalOrder(root, horizontal, vertical, values)
        
        for x in sorted(values.keys()):
            column = [i[1] for i in sorted(values[x])]
            result.append(column)
            
        return result
        
        