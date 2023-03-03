package BST_From_InOrder_PreOrder;

import java.util.Arrays;

// Approach:
// 1. Get root -> first in preorder
// 2. Find left and right subtree with inorder -> root divides it -> Right ST | Root | Left ST
// 3. Count number of elements in left and right -> Get length of right ST & left ST -> tells how to partition pre-order traversal
// 4. get that many elements from preorder -> first is root
// 5. Proceed to right ST: do the same
// Repeat

class BST_InPre {

    public int getIndex(int number, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Base case: preorder is empty or inorder is empty
        if (preorder == null || inorder.length == 0) {
            return null;
        }

        // Create TreeNode root, which is the first value in the preorder array
        TreeNode root = new TreeNode(preorder[0]);

        // Get index of root in inorder array
        int mid = getIndex(preorder[0], inorder);

        // Partition inorder & pre order array into left and right subtree with the help of mid
        int[] newPreOrderLeft = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] newInOrderLeft = Arrays.copyOfRange(inorder, 0, mid);

        // Assignt to left
        root.left = buildTree(newPreOrderLeft, newInOrderLeft);
        // System.out.print(mid);
        int[] newPreOrderRight = null;
        int[] newInOrderRight = null;
        if ((mid + 1) < preorder.length) {
            newPreOrderRight = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        } else {
            newPreOrderRight = null;
        }
        if ((mid + 1) < inorder.length) {
            newInOrderRight = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        } else {
            newInOrderRight = null;
        }

        // Assign to right
        root.right = buildTree(newPreOrderRight, newInOrderRight);

        // do recursive calls & return root

        return root;

    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val);
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        BST_InPre obj = new BST_InPre();
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = obj.buildTree(preorder, inorder);
        obj.inorderTraversal(root);
    }
}