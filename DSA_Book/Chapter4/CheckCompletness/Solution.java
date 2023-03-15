package CheckCompletness;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Approach: BFS - check level by level
 * 1. Put the root node into the queue
 * 2. Poll the node from the queue
 * 3. If the node is null, set the flag to true
 * 4. If the node is not null, check the flag
 * 5. If the flag is true, return false
 * 6. If the flag is false, put the left and right child into the queue
 * 7. If the queue is empty, return true
 * 
 * Time Complexity: O(n)
 * 
 * Idea: if we are still iterating the tree and we encounter a null node, then the tree is not complete
 * 
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    // public boolean isLeaf(TreeNode node) {
    // if (node.right == null && node.left == null) {
    // return true;
    // }
    // return false;
    // }

    public boolean isCompleteTree(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);

        boolean flag = false;

        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp == null) {
                flag = true;
            } else {
                if (flag) {
                    return false;
                }
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
        }

        return true;

    }
}