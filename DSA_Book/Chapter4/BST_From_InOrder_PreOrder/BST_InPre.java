package BST_From_InOrder_PreOrder;

import java.util.ArrayList;
import java.util.List;

class BST_InPre {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        List<TreeNode> Leftlist = new ArrayList();
        int i = 0;
        while(i < inorder.length) {
            Leftlist.add(new TreeNode(inorder(i)))
            i++;
        }
        root.left = constructLeft(Leftlist);

        List<TreeNode> Rightlist = new ArrayList();
        for (j = i; j < inorder.lenth; j++) {
            Rightlist.add(new TreeNode(inorder(j)))
        }
        root.right = constructRight(RightList);

    }
}