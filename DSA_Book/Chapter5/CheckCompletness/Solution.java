package CheckCompletness;

import java.util.LinkedList;
import java.util.Queue;

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