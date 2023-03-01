package BST_From_InOrder_PreOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        // Base case: preorder is empty of inorder is empty
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // Create TreeNode root, which is the first value in the preorder array
        TreeNode root = new TreeNode(preorder[0]);
        // Get index of root in preorder array
        int mid = getIndex(preorder[0], inorder);
        int[] newPreOrderLeft = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] newInOrderLeft = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(newPreOrderLeft, newInOrderLeft);
        int[] newPreOrderRight = Arrays.copyOfRange(preorder, mid+1, preorder.length - 1);
        int[] newInOrderRight = Arrays.copyOfRange(inorder, mid+1, inorder.length - 1);
        root.right = buildTree(newPreOrderRight, newInOrderRight);

        return root;


        root.left()


        TreeNode root = new TreeNode(preorder[0]);

        List<TreeNode> Leftlist = new ArrayList();
        // count how many in left
        int i = 0;
        while(i < inorder.length) {
            if(inorder[i] == root.val) {
                // Leftlist.add(new TreeNode(inorder(i)))
                i++;
            }
        }
        root.left = constructLeft(Leftlist);

         // count how many in right
        List<TreeNode> Rightlist = new ArrayList();
        int j = i;
        while(j < inorder.length) {
                // Leftlist.add(new TreeNode(inorder(i)))
                j++;
            
        }
        for ( int j = i; j < inorder.lenth; j++) {
            Rightlist.add(new TreeNode(inorder(j)))
        }
        root.right = constructRight(RightList);

    }
}