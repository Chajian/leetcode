package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

public class a124 {
    int max = Integer.MAX_VALUE+1;
    public int maxPathSum(TreeNode root) {
        calcul(root);
        return max;
    }

    public int calcul(TreeNode root){
        if(root==null)return 0;
        int left = calcul(root.left),right = calcul(root.right),mostexcellent = root.val;
        mostexcellent+=left;
        mostexcellent+=right;
        if(mostexcellent>max)
            max = mostexcellent;
        if(left>0||right>0)
            root.val=left>right?root.val+left:root.val+right;
        if(root.val>max)
            max = root.val;
        return root.val;
    }

    @Test
    public void test(){
        Binary binary = new Binary();
        TreeNode root = binary.ganerateTreeByLevel(new Integer[]{9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6});
        System.out.println(maxPathSum(root));
    }


}
