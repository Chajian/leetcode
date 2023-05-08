package interview.binarytree;

import entity.TreeNode;

public class a530 {

    int last = Integer.MAX_VALUE,min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)return -1;
        getMinimumDifference(root.left);
        if(last!=Integer.MAX_VALUE&&(root.val-last)<min)
            min = root.val-last;
        last = root.val;
        getMinimumDifference(root.right);
        return min;
    }
}
