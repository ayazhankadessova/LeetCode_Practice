package CheckCompletness;

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

    public boolean isLeaf(TreeNode node) {
        if (node.right == null && node.left == null) {
            return true;
        }
        return false;
    }

    public boolean isCompleteTree(TreeNode node) {

        if (node.left == null && node.right != null) {
            return false;
        }
        if (node.right == null && node.left != null && (!isLeaf(node.left))) {
            return false;
        } else if (node.left == null && node.right != null && (!isLeaf(node.right))) {
            return false;
        } else if (node.right != null && node.left != null) {
            // boolean flag = false;
            // if (node.left.left == null) {
            // flag = true;
            // }
            // if (node.left.right != null && flag) {
            // return false;
            // }
            // if (node.left.right == null) {
            // flag = true;
            // }
            // if (node.right.left != null && flag) {
            // flag = true;
            // return false;
            // }
            // if (node.right.left == null) {
            // flag = true;
            // }
            // if (node.right.right != null && flag) {
            // flag = true;
            // return false;
            // }
            if (!(isCompleteTree(node.left) && isCompleteTree(node.right))) {
                return false;
            }
        }

        if (node.left != null) {
            isCompleteTree(node.left);
        } else if (node.right != null) {
            isCompleteTree(node.right);
        }

        return true;

    }
}