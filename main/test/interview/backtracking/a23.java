package interview.backtracking;

import entity.ListNode;
import org.junit.Test;
import tools.ListUtils;
import tools.StringUtils;

public class a23 {

    /**
     * 双指针实现
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        int start = 0,end = lists.length-1,i=end;
        while(i>0){
            if(start>=end){
                i = end;
                start = 0;
                continue;
            }
            lists[start] = merge(lists[start++],lists[end--]);
        }
        return lists[0];
    }

    /**
     * 合并
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(list1!=null&&list2!=null){
            if(list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1==null?list2:list1;
        return head.next;
    }

    @Test
    public void test(){
        String input = StringUtils.middleBracketToLarge("{{},{1,23,4,234,23,42,4,1},{},{-23,234,234,234,23,423,23}}");
        ListNode[] listNodes = ListUtils.toLists(new int[][]{{},{1,4,23,42},{},{},{-23,23,423,2223}});
        ListNode root = mergeKLists(listNodes);



    }

}
