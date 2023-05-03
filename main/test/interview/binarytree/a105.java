package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * way: unknow
 * author: StefanPochmann
 */
public class a105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,  inorder, (long)Integer.MAX_VALUE + 1);
    }

    int pre = 0,in = 0;
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder,long stop){
        if(pre>=preorder.length) return null;
        if(inorder[in] == stop){
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = buildTreeHelper(preorder,inorder,node.val);
        node.right = buildTreeHelper(preorder,inorder,stop);
        return node;
    }


    @Test
    public void test(){
        TreeNode treeNode = buildTree(new int[]{3,2,1,4},new int[]{1,2,3,4});
        System.out.println();
    }
}
