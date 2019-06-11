/**给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
**/
public class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public void reorderList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode mid=null;
        ListNode fast=head;
        ListNode slow=head;
        ListNode cur1=head;
        while(fast!=null){
            fast=fast.next;
            if(fast==null){
                mid=slow;
                break;
            }
            slow=slow.next;
            fast=fast.next;
        }
        ListNode reseveLatterHalf=null;
        while(mid!=null){
            ListNode next=mid.next;
            mid.next=reseveLatterHalf;
            reveseLatterHalf=mid;
            mid=next;
        }
        ListNode newList=cur1;
        ListNode cur2=reveseLatterHalf;
        while(cur2!=null){
            ListNode temp1=cur1.next;
            ListNode temp2=cur2.next;
            cur1.next=cur2;
            cur2.next=temp1;
            cur1=temp1;
            cur2=temp2;
        }
        return newList;
    }
}