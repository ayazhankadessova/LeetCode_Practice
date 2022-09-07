# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pruneTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        
        root.left = self.pruneTree(root.left)
        root.right = self.pruneTree(root.right)
        
        if root.val or root.left or root.right:
            return root
        
        return None
    
    
    # class Solution:
    # def pruneTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
    #     def dfs(node):
    #         if not node:
    #             return None
    #         node.left = dfs(node.left)
    #         node.right = dfs(node.right)            
    #         if node.val == 1 or node.right or node.left:
    #             return node
    #         return None
    #     return dfs(root)