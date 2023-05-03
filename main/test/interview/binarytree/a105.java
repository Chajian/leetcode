package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * way: recursion
 */
public class a105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<TreeNode> deque = new ArrayDeque();
        TreeNode root = new TreeNode(preorder[0]);
        deque.push(root);
        for(int i = 1 ,j=0; i < preorder.length ;i++){
            TreeNode node = new TreeNode(preorder[i]);
            if(deque.size()<1||inorder[j]!=deque.peek().val){
                deque.peek().left = node;
            }
            else{
                TreeNode treeNode = null;
                while(deque.size()>0&&deque.peek().val==inorder[j]){
                    treeNode = deque.pop();
                    j++;
                }
                treeNode.right = node;
            }
            deque.push(node);
        }
        return root;
    }

    @Test
    public void test(){
        TreeNode treeNode = buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        System.out.println();
    }
}
