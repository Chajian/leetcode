package interview.binarytree;

import entity.Node;
import org.junit.Test;
import tools.Binary;

import java.util.ArrayList;
import java.util.List;

//k个节点的组内逆排序
public class kNodeReverse {
    public ListNode verseNode(ListNode head,int k){
        ListNode next=head.next,cur=head.next;
        int i=k;
        while(--i>=0&&next!=null){
            if(i==0){
                //逆转,接着再来
                verse(cur,k);
                cur.next=next;
                cur=next;
                i=k;
            }
            next=next.next;
        }
        return head;
    }

    public ListNode verse(ListNode node,int k){
        if(k==1)
            return node.next;
        ListNode next = verse(node.next,k-1);
        next.next=node;
        return node;
    }



    @Test
    public void test(){
        ListNode head = new ListNode();
        head.next =  generateListFromIntegers(new int[]{1,2,3,4,5,6,7,8});
        ListNode context = verseNode(head.next,4);
        printNode(context);
    }

    public ListNode generateListFromIntegers(int ...arrays){
        ListNode head = new ListNode();
        ListNode cur = new ListNode(arrays[0]);
        head.next = cur;
        for(int i = 1 ; i < arrays.length;i++){
            cur.next = new ListNode(arrays[i]);
            cur = cur.next;
        }
        return head;
    }


    public void printNode(ListNode node){
        while(node!=null){
            System.out.print(node.val);
            node = node.next;
        }
    }

}


class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}