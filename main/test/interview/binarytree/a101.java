package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * way:recursion,MRL,MLR
 */
public class a101 {
    LinkedList<TreeNode> list = new LinkedList<>();
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null)return true;
        if(left==null||right==null)
            return false;
        if(left.val!=right.val)
            return false;
        return isSymmetric(left.right,right.left)&&isSymmetric(left.left,right.right);
    }


    @Test
    public void test(){
        Binary binary = new Binary();
        TreeNode root = binary.ganerateTreeByLevel(new Integer[]{1,2,2,null,3,null,3});
        System.out.println(isSymmetric(root));
    }

}
