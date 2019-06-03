class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class NowCoder{
	public static ListNode FindKthToTail(ListNode head,int k) {
		//问题描述：输入一个链表，输出该链表中倒数第k个结点。
		/*遍历链表，求出链表长度
		  再从头遍历链表，直到遍历到第（长度-K+1）个结点，即倒数第K个结点
		*/
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        cur=head;
        int i=1;
        while(i!=len-k+1){
            i++;
            cur=cur.next;
        }
        return cur;
    }
	/*首先定义两个指向链表头的指针p,q;
	  先令一个指针指向第k+1节点，两指针之间隔k-1个结点，然后两个指针同时向后移动，
	  最后p指向null时，q的指向即为倒数第k个节点。*/
	public static ListNode FindKthToTail2(ListNode head,int k) { //5,{1,2,3,4,5}
        ListNode p, q;
        p = head;
		q = head;
        int i = 0;
		for(;i<k;i++){
			if(i<k&&cur==null){
                return null;
            }
			p = p.next;
		}
        while(p!=null) {
            p = p.next;
			q = q.next;
        }
        return q;
    }
	public static void print(ListNode head){
		for(ListNode cur=head;cur!=null;cur=cur.next){
			System.out.printf("%d-->",cur.val);
		}
		System.out.println("null");
	}
	public static void main(String[] args){
		ListNode head=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		print(head);
		
		System.out.println(FindKthToTail2(head,3).val);
	}
}