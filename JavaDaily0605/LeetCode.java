class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LeetCode{
	/**问题描述：合并有序链表
	将两个有序链表合并为一个新的有序链表并返回。
	新链表是通过拼接给定的两个链表的所有节点组成的
	**/
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       if(l1==null){
           return l2;
       }
        if(l2==null){
            return l1;
        }
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode newList=null;
        ListNode lastNode=newList;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
                ListNode next=cur1.next;
                if(newList==null){
                    cur1.next=newList;
                    newList=cur1;
                }else{
                    lastNode.next=cur1;
                }
                lastNode=cur1;
                cur1=next;
            }else{
                ListNode next=cur2.next;
                if(newList==null){
                    cur2.next=newList;
                    newList=cur2;
                }else{
                    lastNode.next=cur2;
                }
                lastNode=cur2;
                cur2=next;
            }
        }
        if(cur1==null&&lastNode!=null){
            lastNode.next=cur2;
        }
        if(cur2==null&&lastNode!=null){
            lastNode.next=cur1;
        }
        return newList;
    }
	/**问题描述：链表的中间节点
	给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
	如果有两个中间结点，则返回第二个中间结点。
	**/
	public static ListNode middleNode(ListNode head) {
        ListNode cur=head;
        ListNode pre=head;
        while(cur!=null){
            cur=cur.next;
            if(cur==null){
                return pre;
            }
            pre=pre.next;
            cur=cur.next;
        }
        return pre;
    }
	/**问题描述：反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
	**/
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        int len=0;
        ListNode cur=head;
        ListNode newList=null;
        ListNode last=head;
        ListNode last1=head;
		
        while(cur!=null){
            len++;
            if(len<m){
				last=cur;
				cur=cur.next;
				last1=cur;
            }
			if(len>=m&&len<=n){
				ListNode next=cur.next;
				cur.next=newList;
				newList=cur;
				cur=next;
			}
			if(len>n){
				last.next=newList;
				break;
			}
        }
		last1.next=cur;
        return head;
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
		ListNode head2=new ListNode(0);
		ListNode m2=new ListNode(2);
		ListNode m3=new ListNode(3);
		ListNode m4=new ListNode(4);
		head2.next=m2;
		m2.next=m3;
		m3.next=m4;
		print(head2);
		head=mergeTwoLists(head,head2);
		print(head);
		//System.out.println(middleNode(head).val);
		head=reverseBetween(head,2,7);
		print(head);
	}
}
