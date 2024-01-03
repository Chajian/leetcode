package everyday;

import entity.ListNode;

public class a2487 {
    public ListNode removeNodes(ListNode head) {
        ListNode pre = head,cur = head.next,result = head;
        int max =head.val;
        while(cur!=null){
            if(cur.val > max){
                result=cur;
                max=cur.val;
                pre=result;
                cur=pre.next;
                continue;
            }
            if(cur.val>pre.val&&pre!=result) {
                ListNode temp = result;
                while(temp!=null&&temp.next!=pre)
                    temp = temp.next;
                temp.next = cur;
                pre = temp;
            }
            else if(cur.val>pre.val&&pre==result){
                result = cur;
                pre=result;
                cur=pre.next;
                continue;
            }
            pre=pre.next;
            cur = cur.next;
        }
        return result;
    }
}
