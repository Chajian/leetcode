package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

public class a112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        if(root.val==targetSum&&root.left==null&&root.right==null)return true;

        if(root.left!=null)root.left.val+=root.val;
        if(root.right!=null)root.right.val+=root.val;
        return hasPathSum(root.left,targetSum)||hasPathSum(root.right,targetSum);
    }


    @Test
    public void test(){
        Binary binary = new Binary();
        TreeNode root = binary.ganerateTreeByLevel(new Integer[]{1,2});
        boolean result = hasPathSum(root,1);
        System.out.println(result);
    }
}
