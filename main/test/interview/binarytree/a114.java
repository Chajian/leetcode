package interview.binarytree;

import com.sun.source.tree.Tree;
import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

import java.util.*;

public class a114 {

    Stack<TreeNode> stack = new Stack<>();
    public void flatten(TreeNode root) {

        TreeNode cur = root,temp = null;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode rightest = cur.right;
                while(rightest!=null&&rightest.right!=null){
                    rightest = rightest.right;
                }
                if(rightest!=null) {
                    rightest.right = temp;
                    temp = cur.right;
                }
                cur.right = cur.left;
                cur.left = null;
            }
            if(cur.right==null&&temp!=null) {
                cur.right = temp;
                temp = null;
            }
            cur = cur.right;
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
