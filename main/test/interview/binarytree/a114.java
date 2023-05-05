package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

import java.util.ArrayDeque;
import java.util.Deque;

public class a114 {

    TreeNode cur;
    public void flatten(TreeNode root) {
        if(root==null)return;
        TreeNode temp = root.right;
        if(root.left!=null) {
            root.right = root.left;
            cur = root.left;
            flatten(root.left);
        }
        root.left = null;
        if(cur==null)cur = root;
        if(temp!=null) {
            cur.right = temp;
            cur = temp;
            flatten(temp);
        }
    }

    @Test
    public void test(){
        Binary binary = new Binary();
        TreeNode root = binary.ganerateTreeByLevel(new Integer[]{1,null,2,null,null,3});
        flatten(root);
        System.out.println();

    }

}
