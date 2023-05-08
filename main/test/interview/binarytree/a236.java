package interview.binarytree;

import entity.TreeNode;

public class a236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(root==q||root==p||(left!=null&&right!=null))
            return root;
        if(left!=null)
            return left;
        if(right!=null)
            return right;
        return null;
    }
}
