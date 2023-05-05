package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

public class a112 {
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        haspathSum(root,targetSum);
        return result;
    }

    public void haspathSum(TreeNode root,int targetSum){
        if(root.val==targetSum&&root.left==null&&root.right==null){
            result = true;
            return;
        }
        if(root.left!=null) {
            root.left.val += root.val;
            haspathSum(root.left, targetSum);
        }
        if(root.right!=null){
            root.right.val+=root.val;
            haspathSum(root.right, targetSum);
        }

    }


    @Test
    public void test(){
        Binary binary = new Binary();
        TreeNode root = binary.ganerateTreeByLevel(new Integer[]{1,2});
        boolean result = hasPathSum(root,1);
        System.out.println(result);
    }
}
