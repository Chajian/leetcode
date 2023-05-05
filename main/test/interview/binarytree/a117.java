package interview.binarytree;

import com.sun.source.tree.Tree;
import entity.Node;
import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class a117 {

    Deque<Node> deque = new ArrayDeque();
    public Node connect(Node root) {
        if(root==null) return null;
        deque.add(root);
        while(deque.size()>0) {
            int size = deque.size();
            Node preNode = null;

            for (int i = 0; i < size; i++) {
                Node treeNode = deque.pop();
                if (preNode != null)
                    preNode.next = treeNode;
                preNode = treeNode;
                if (treeNode.left != null) deque.add(treeNode.left);
                if (treeNode.right != null) deque.add(treeNode.right);
            }
        }
        return root;
    }




    @Test
    public void test(){
        Binary binary = new Binary();
        Node root = binary.ganerateNodeByLevel(new Integer[]{1,2,3,4,5,null,7});
        Node result = connect(root);
        System.out.println();
    }

}
