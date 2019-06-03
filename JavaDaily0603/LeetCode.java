class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class LeetCode {
	//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
	/*思路：找到倒数第n个结点的前一个结点，让该节点的后继为倒数第n个结点的后继
		
		子问题：找到倒数第n个结点的前驱
			1.有两个引用，第一个引用指向首节点，然后走n步
			2.第二个结点指向首节点，此时两结点之间隔了n-1个结点，保持这样的距离，共同向后移动
			3.当第一个引用到达尾节点时，第二个引用离尾节点有n-1个结点，
			4.此时第二个结点为倒数第n+1个结点，即倒数第n个结点的前驱
		特殊情况：
			1.链表只有一个结点或者为空链表，直接返回空即可；
			2.链表的长度刚好等于n，即删除首节点，第一个引用从头结点开始移动n步后，
			第一个引用移动到了尾节点的下一个，即此时第一个引用为空，
			出现第一个在移动n步后为空的情况时，说明要删除的是首节点，直接将首节点定为首节点的下一个即可
	*/
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode cur=head;
        ListNode pre=head;
        for(int i=0;i<n;i++){
			cur=cur.next;
        }
		if(cur==null){
			head=head.next;
			return head;
		}
        while(cur.next!=null){
            cur=cur.next;
            pre=pre.next;
        }
        
        pre.next=pre.next.next;
        return head;
    }
	public static void print(ListNode head){
		for(ListNode cur=head;cur!=null;cur=cur.next){
			System.out.printf("%d-->",cur.val);
		}
		System.out.println("null");
	}
	public static void main(String[] args){
		ListNode head=new ListNode(1);
		//ListNode n2=new ListNode(2);
		//ListNode n3=new ListNode(3);
		//ListNode n4=new ListNode(4);
		//ListNode n5=new ListNode(5);
		//head.next=n2;
		//n2.next=n3;
		//n3.next=n4;
		//n4.next=n5;
		print(head);
		head=removeNthFromEnd(head,1);
		print(head);
		
		
	}
}