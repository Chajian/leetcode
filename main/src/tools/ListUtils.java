package tools;

import entity.ListNode;

public class ListUtils {


    /**
     * int[][]转List[]
     * @param a
     * @return
     */
    public static ListNode[] toLists(int[][] a){
        ListNode[] listNodes = new ListNode[a.length];
        for(int i = 0 ; i < a.length ;i++){
            ListNode head = new ListNode(-1);
            ListNode node = head;
            for(int j = 0 ; j < a[i].length ;j++) {
                node.next = new ListNode(a[i][j]);
                node = node.next;
            }
            listNodes[i] = head.next;
        }
        return listNodes;
    }

    public static void printListNode(ListNode root){

    }
}
