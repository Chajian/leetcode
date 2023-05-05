package interview.binarytree;

import com.sun.source.tree.Tree;
import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

import java.util.*;

public class a114 {

    Stack<TreeNode> stack = new Stack<>();
    public void flatten(TreeNode root) {

        TreeNode cur = root;
        while(cur!=null) {
            while (cur != null) {
                if (cur.left != null) {
                    if(cur.right!=null)
                        stack.push(cur.right);
                    cur.right = cur.left;
                    cur.left = null;
                }
                if(cur.right==null&&stack.size()>0) {
                    cur.right = stack.pop();
                }
                cur = cur.right;
            }
        }
    }

    @Test
    public void test(){
        Binary binary = new Binary();
        TreeNode root = binary.ganerateTreeByLevel(new Integer[]{1,2,5,3,4,null,6});
        flatten(root);
        System.out.println();

    }

}
