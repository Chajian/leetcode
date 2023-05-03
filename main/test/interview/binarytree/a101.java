package interview.binarytree;

import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * way:recursion
 */
public class a101 {
    LinkedList<TreeNode> list = new LinkedList<>();
    public boolean isSymmetric(TreeNode root) {
        if(root!=null)
            list.add(root);
        while(list.size()>0) {
            for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                if (list.get(i) == null && list.get(j) == null) continue;
                if (list.get(i) == null || list.get(j) == null) return false;
                if (list.get(i).val != list.get(j).val)
                    return false;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.poll();
                if (node == null) continue;
                list.add(node.left);
                list.add(node.right);
            }
        }
        return true;
    }


    @Test
    public void test(){
        Binary binary = new Binary();
        TreeNode root = binary.ganerateTreeByLevel(new Integer[]{1,2,2,3,4,4,3});
        System.out.println(isSymmetric(root));
    }

}
