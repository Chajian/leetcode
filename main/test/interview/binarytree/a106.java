package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * way: recursion
 */
public class a106 {
    Deque<TreeNode> deque = new ArrayDeque();
    int in = 0,po = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        po = postorder.length-1;
        in = inorder.length-1;
        TreeNode root = new TreeNode(postorder[po--]);
        deque.push(root);
        while(po>=0){
            TreeNode node = new TreeNode(postorder[po--]);
            if(deque.size()>0&&deque.peek().val!=inorder[in]) {
                deque.peek().right = node;
                deque.push(node);
            }
            else{
                TreeNode treeNode = null;
                while(deque.size()>0&&deque.peek().val==inorder[in]) {
                    treeNode = deque.pop();
                    in--;
                }
                treeNode.left = node;
                deque.push(node);
            }
        }
        return root;
    }

    @Test
    public void test(){
        TreeNode treeNode = buildTree(new int[]{1,2,3,4},new int[]{3,2,4,1});
        System.out.println();
    }
}
