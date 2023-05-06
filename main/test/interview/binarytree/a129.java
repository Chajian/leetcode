package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

public class a129 {

    public int sumNumbers(TreeNode root) {
        if(root.left==null&&root.right==null){
            return root.val;
        }
        int value = 0;
        if(root.left!=null) {
            root.left.val = root.val*10+root.left.val;
            value = sumNumbers(root.left);
        }
        if(root.right!=null) {
            root.right.val = root.val*10+root.right.val;
            value += sumNumbers(root.right);
        }
        return value;
    }

    @Test
    public void test(){
        Binary binary = new Binary();
        TreeNode root = binary.ganerateTreeByLevel(new Integer[]{5,0});
        System.out.println(sumNumbers(root));
    }
}
