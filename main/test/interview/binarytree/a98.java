package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

import java.util.LinkedList;

public class a98 {
    long lastVal = Long.MIN_VALUE;
    boolean lastResult = true;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return lastResult &= true;
        isValidBST(root.left);
        if(lastVal>=root.val)
            return lastResult &= false;
        lastVal = root.val;
        isValidBST(root.right);
        return lastResult;
    }

    @Test
    public void test(){
        Binary binary = new Binary();
        TreeNode root = binary.ganerateTreeByLevel(new Integer[]{2,1,3});
        System.out.println(isValidBST(root));
    }

}
