package interview.binarytree;

import entity.Node;
import org.junit.Test;
import tools.Binary;

import java.util.ArrayList;
import java.util.List;

//k个节点的组内逆排序
public class kNodeReverse {

    //hh存放逆序后的头，tail存放一次逆序的wei尾
 ListNode tail = null,hh = null;
    //k个节点逆序
    public void verseNode(ListNode head,int k){
        ListNode left =head.next,right = head.next,stack = null;
        int i = k;
        while(right!=null){
            if (--i == 0) {
                right = right.next;
                ListNode temp = verse(left,k);
                if(stack != null){
                    stack.next = tail;
                }
                stack=temp;
                i=k;
                left=right;
                continue;
            }
            right = right.next;
        }
        if(i!=0){
            stack.next = left;
        }

    }

    public ListNode verse(ListNode node,int k){
        if (k==1) {
            if(hh==null){
                hh=node;
            }
            tail = node;
            return node;
        }
        else{
            ListNode temp = verse(node.next,k-1);
            temp.next=node;
            node.next=null;
            return node;
        }
    }



    @Test
    public void test(){
        ListNode head = new ListNode();
        //自动生存List单节点链表
        head.next =  generateListFromIntegers(new int[]{1,2,3,4,5});
        verseNode(head.next,2);
        printNode(hh);
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
