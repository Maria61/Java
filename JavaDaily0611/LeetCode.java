class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class LeetCode {
	/**给定一个单链表 L：L0→L1→…→Ln-1→Ln ，将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
	你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
	**/
	/*思路：1.找到链表中点
			2.逆置链表后半部分
			3.将逆置后的链表与前半部分合并
	*/
    public static void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
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
		mid=slow;
        ListNode reveseLatterHalf=null;
        while(mid!=null){
            ListNode next=mid.next;
            mid.next=reveseLatterHalf;
            reveseLatterHalf=mid;
            mid=next;
			
        }
        ListNode cur2=reveseLatterHalf;
        while(cur2.next!=null){
            ListNode temp1=cur1.next;
            ListNode temp2=cur2.next;
			
            cur1.next=cur2;
            cur2.next=temp1;
            cur1=temp1;
            cur2=temp2;
        }
		
    }
	public static void print(ListNode head){
		ListNode cur=head;
		while(cur!=null){
			System.out.printf("%d-->",cur.val);
			cur=cur.next;
		}
		System.out.println("null");
	}
	public static void main(String[] args){
		ListNode head=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		print(head);
		reorderList(head);
		print(head);
	}
}