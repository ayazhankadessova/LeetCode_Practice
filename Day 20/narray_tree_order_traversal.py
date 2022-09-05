"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def levelOrder(self, root):
        dict1 = defaultdict(list)

        def dfs(node, level):
            if not node:
                return None

            dict1[level].append(node.val)

            for child in node.children:
                dfs(child, level+1)

        dfs(root, 0)

        return [dict1[key] for key in sorted(dict1.keys())]
        