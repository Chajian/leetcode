package interview.binarytree;

import entity.TreeNode;

public class a230 {
    int current = 1;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        int value = kthSmallest(root.left,k);
        if(value != -1)
            return value;
        if(current++==k)
            return root.val;
        return kthSmallest(root.right,k);
    }
}
