package interview.binarytree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a173 {
    class BSTIterator {
        List<Integer> list = new ArrayList<>();
        int point = 0,len = 0;

        public void genarateList(TreeNode root){
            if(root==null)return;
            genarateList(root.left);
            list.add(root.val);
            genarateList(root.right);
            point = 0;
        }

        public BSTIterator(TreeNode root) {
            genarateList(root);
            len = list.size();
        }

        public int next() {
            return list.get(point++);
        }

        public boolean hasNext() {
            return point<len;
        }
    }

}
