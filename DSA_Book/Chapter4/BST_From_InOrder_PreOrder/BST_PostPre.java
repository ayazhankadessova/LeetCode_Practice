package BST_From_InOrder_PreOrder;

import java.util.Arrays;

// Approach:

// 1. Last element of preorder is always root
// 2. Use index or root to partition inorder & postorder array into left and right subtrees recursively

public class BST_PostPre {
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

        public int getIndex(int number, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == number) {
                    return i;
                }
            }
            return -1;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
                return null;
            TreeNode root = new TreeNode(postorder[postorder.length - 1]);

            // Get index of root in inorder array
            int mid = getIndex(postorder[postorder.length - 1], inorder);

            // Partition inorder array into left and right subtree with the help of mid
            int[] newPostOrderLeft = Arrays.copyOfRange(postorder, 0, mid);
            int[] newInOrderLeft = Arrays.copyOfRange(inorder, 0, mid);

            // Assignt to left
            root.left = buildTree(newInOrderLeft, newPostOrderLeft);
            // System.out.print(mid);
            int[] newPostOrderRight = null;
            int[] newInOrderRight = null;

            newPostOrderRight = Arrays.copyOfRange(postorder, mid, postorder.length - 1);
       
            newInOrderRight = Arrays.copyOfRange(inorder, mid + 1, postorder.length);

            // Assign to right
            root.right = buildTree(newInOrderRight, newPostOrderRight);
            return root;

        }
    
}
