package interview.binarytree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * way: iteration
 */
public class a100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(p);
        Queue<TreeNode> queue2 = new LinkedList();
        queue2.add(q);
        while(queue.size()>0){
            if(queue.size()!=queue2.size())return false;
            int num = queue.size();
            while(num-->0){
                TreeNode pp = queue.poll();
                TreeNode qq = queue2.poll();
                if(pp==null&&qq==null)
                    continue;
                if(pp==null||qq==null)return false;

                if(pp.val!=qq.val)return false;
                queue.add(pp.left);
                queue.add(pp.right);

                queue2.add(qq.left);
                queue2.add(qq.right);
            }
        }
        return true;
    }
}
