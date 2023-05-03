package interview.binarytree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class a226 {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        Queue<TreeNode> leafs = new LinkedList<>();
        while(nodes.size()>0) {
            TreeNode node = nodes.poll();
            if(node==null) continue;
            if(node.left!=null||node.right!=null){
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
        return root;
    }
}
