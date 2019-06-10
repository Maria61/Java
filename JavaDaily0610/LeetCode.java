class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LeetCode {
	/**问题描述：给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
	**/
	/*思路：旋转链表之后链表只改变了首结点和尾结点，
			因此只要旋转一次，原来的尾结点变为现在的头结点，原来的尾节点的前一个结点变为现在的尾节点，
			k为几，就这样改变几次，用一个循环即可。
	 注意：如果k大于链表长度，是链表的长度的整数倍，经k次旋转后，链表与原来一样。
		   如果不是链表的整数倍，减去链表长度的整数倍（减去重复的部分），只需要移动小于长度次
	*/
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode headNode=head;
        ListNode LastNode=head;
        ListNode pre=null;
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        if(k%len==0){
            return head;
        }
        if(k>len){
            k=k%len;
        }
        while(k>0){
            cur=headNode;
            while(cur.next!=null){
                pre=cur;
                cur=cur.next; 
            }
            LastNode=cur;
            LastNode.next=headNode;
            headNode=LastNode;
            pre.next=null;
            k--;
        }
        return headNode;
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
		print(rotateRight(head,10));
	}
}