package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * way: recursion
 */
public class a106 {
    int in = 0,po = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder.length-1;
        po = postorder.length-1;
        return buildTree(inorder,postorder,Integer.MAX_VALUE-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder,int stop) {
        if(po<0)return null;
        if(inorder[in]==stop){
            in--;
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[po--]);
        treeNode.right = buildTree(inorder,postorder,treeNode.val);
        treeNode.left = buildTree(inorder,postorder,stop);
        return treeNode;
    }

    @Test
    public void test(){
        TreeNode treeNode = buildTree(new int[]{1,2,3,4},new int[]{3,2,4,1});
        System.out.println();
    }
}
