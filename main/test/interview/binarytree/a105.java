package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;

public class a105 {

    int on = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,on);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,int left,int right,int target) {
        if(left>=preorder.length||right>=preorder.length||left>right) {
            on--;
            return null;
        }
        else if(left==right)return new TreeNode(preorder[target]);
        else{
            TreeNode treeNode = new TreeNode(preorder[target]);
            int index = left;
            for(int i = left ; i <= right;i++){
                if(inorder[i]==preorder[target]) {
                    index = i;
                    break;
                }
            }
            treeNode.left=buildTree(preorder,inorder,left,index-1,++on);
            treeNode.right=buildTree(preorder,inorder,index+1,right,++on);
            return treeNode;
        }
    }

    @Test
    public void test(){
        TreeNode treeNode = buildTree(new int[]{3,2,1,4},new int[]{1,2,3,4});
        System.out.println();
    }
}
