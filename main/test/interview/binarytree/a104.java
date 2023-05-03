package interview.binarytree;


import com.sun.source.tree.Tree;
import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * way: iteration
 */
public class a104 {
    public int maxDepth(TreeNode root) {
        int level = 0;
        Queue<TreeNode> queue = new LinkedList();
        if(root!=null)
            queue.add(root);
        while(queue.size()>0){
            int num = queue.size();
            while(num-->0){
                TreeNode treeNode = queue.poll();
                if(treeNode.left!=null)
                    queue.add(treeNode.left);
                if(treeNode.right!=null)
                    queue.add(treeNode.right);
            }
            level++;
        }
        return level;
    }
}
