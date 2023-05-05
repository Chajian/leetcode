package interview.binarytree;

import com.sun.source.tree.Tree;
import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class a114 {


    Queue<TreeNode> queue = new LinkedList();
    public void flatten(TreeNode root) {
        if(root==null)return;

        addQueue(root);
        TreeNode pre = null;
        while(queue.size()>0){
            TreeNode cur = queue.poll();
            if(pre!=null) {
                pre.right = cur;
                pre.left = null;
            }
            pre = cur;
        }
    }

    public void addQueue(TreeNode root) {
        queue.add(root);
        if(root.left!=null)
            addQueue(root.left);
        if(root.right!=null)
            addQueue(root.right);
    }

    @Test
    public void test(){
        Binary binary = new Binary();
        TreeNode root = binary.ganerateTreeByLevel(new Integer[]{1,2,5,3,4,null,6});
        flatten(root);
        System.out.println();

    }

}
