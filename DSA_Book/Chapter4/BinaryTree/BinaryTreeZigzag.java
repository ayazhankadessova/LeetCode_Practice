package LeetCodePlatform.Topics.BinaryTree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class BinaryTreeZigzag {
    // Aproach: 1. Add root to the queue. 2. While queue is not empty, poll and add
    // right and left children to the queue -> now the queue has right and left of
    // the previous node. 3. Repeat the process while queue is not empty. 4. For
    // every level, reverse/dont reverse alternatively. 4. Add every level to result
    // list.

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        List<List<Integer>> result = new ArrayList();

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        boolean flag = false;

        while (!q.isEmpty()) {
            int size = q.size();
            System.out.print(size);
            List<Integer> level = new ArrayList();
            while (size-- > 0) {
                root = q.poll();
                System.out.print(root.val);
                level.add(root.val);
                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
            }

            if (flag) {
                Collections.reverse(level);
            }
            if (flag == false) {
                flag = true;
            } else {
                flag = false;
            }
            result.add(level);
        }

        return result;
    }
}