package interview.binarytree;

public class a100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;

        if(p.val != q.val) return false;
        return true&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
