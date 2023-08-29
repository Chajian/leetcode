package interview.binarytree;

import entity.Node;
import entity.TreeNode;
import org.junit.Test;
import tools.Binary;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class a117 {

    public Node connect(Node root) {
        if(root==null)return null;
        Node cur = root;
        while(cur!=null){
            Node dump = new Node(0);
            Node pre = dump;
            while(cur!=null){
                if(cur.left!=null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right!=null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dump.next;
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
