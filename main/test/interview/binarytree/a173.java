package interview.binarytree;

import entity.TreeNode;



public class a173 {
    class BSTIterator {
        TreeNode root = new TreeNode(-1);

        public TreeNode next(TreeNode root,TreeNode pre){
            if(root.left!=null)
                return next(root.left,root);
            else {
                pre.left = root.right;
                return root;
            }
        }
        public BSTIterator(TreeNode root) {
            this.root.left = root;
        }

        public int next() {
            return next(root.left,root).val;
        }

        public boolean hasNext() {
            return root.left!=null;
        }
    }

}
