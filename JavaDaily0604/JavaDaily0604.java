class ListNode{
	public int val;
	public ListNode next=null;
	ListNode(int val){
		this.val=val;
	}
}
public class JavaDaily0604{
	/**头插**/
	public static ListNode pushFront(ListNode head,int val){
		ListNode newNode=new ListNode(val);
		newNode.next=head;
		//head=newNode;
		//return head;
		return newNode;
	}
	/**头删**/
	public static ListNode popFront(ListNode head){
		if(head==null){
			return null;
		}
		return head.next;
	}
	/**尾删**/
	public static ListNode popBack(ListNode head){
		if(head==null||head.next==null){
			return null;
		}
		ListNode cur=head;
		while(cur.next.next!=null){
			cur=cur.next;
		}
		cur.next=null;
		return head;
	}
	/**打印**/
	public static void print(ListNode head){
		ListNode cur=head;
		while(cur!=null){
			System.out.printf("%d-->",cur.val);
			cur=cur.next;
		}
		System.out.println("null");
	}
	/**输出倒数第k个结点**/
	//思路：遍历链表求出长度L，倒数第k个就是第L-k+1个，从头向后移动L-K次就指向了倒数第k个
	public static ListNode FindKthToTail(ListNode head,int k){
		int len=0;
		ListNode cur=head;
		while(cur!=null){
			len++;
			cur=cur.next;
		}
		if(len==k){
			return head;
		}
		if(len<k){
			System.out.println("k不合法！");
			return null;
		}
		cur=head;
		for(int i=0;i<len-k;i++){
			cur=cur.next;
		}
		return cur;
	}
	/*思路：定义两个指向首结点的结点，
	*/
	public static ListNode FindKthToTail2(ListNode head,int k){
		ListNode cur=head;
		ListNode pre=head;
		for(int i=0;i<k;i++){
			if(cur==null){
				System.out.println("k不合法！");
				return null;
			}
			cur=cur.next;
		}
		while(cur!=null){
			cur=cur.next;
			pre=pre.next;
		}
		return pre;
	}
	/**查找链表的中间结点**/
	/*思路：定义两个指向首结点的结点，
	第一个结点先走一步，第二个结点再走一步，第一个结点再走一步为一个周期！
	直到第一个结点为空，第二个结点即为链表的中间结点！
	走一步要判断第一个结点是否为空。
	*/
	public static ListNode FindMinNode(ListNode head){
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
	/**合并有序链表！**/
	/*思路：
	1.定义一个新的链表，为合并后的链表
	2.比较两个链表的结点值，小的那个尾插到新链表中，再比较下一个
		子问题（尾插）：1.如果新链表为空，尾插即头插
						2.如果非空，尾节点的next为要插入的结点
	*/
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		ListNode cur1=l1;
		ListNode cur2=l2;
		ListNode result=null;
		ListNode last=null;
		while(cur1!=null&&cur2!=null){
			if(cur1.val<=cur2.val){
				ListNode next1=cur1.next;
				if(result==null){
					cur1.next=result;
					result=cur1;					
				}else{
					last.next=cur1;
				}
				last=cur1;
				cur1=next1;
			}else{
				ListNode next2=cur2.next;
				if(result==null){
					cur1.next=result;
					result=cur2;					
				}else{
					last.next=cur2;
				}
				last=cur2;
				cur2=next2;
			}	
		}
		if(cur1==null){
			last.next=cur2;
		}
		if(cur2==null){
			last.next=cur1;
		}
		return result;
	}
	//编写一个程序，找到两个单链表相交的起始节点。注：两单链表相交，相交后面的部分要相同
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
		ListNode cur1=headA;
		ListNode cur2=headB;
		int len1=0;
		int len2=0;
		while(cur1!=null){
			len1++;
			cur1=cur1.next;
		}
		while(cur2!=null){
			len2++;
			cur2=cur2.next;
		}
		cur1=headA;
		cur2=headB;
		if(len1>len2){
			for(int i=0;i<(len1-len2);i++){
				cur1=cur1.next;
			}
		}else{
			for(int i=0;i<(len2-len1);i++){
				cur2=cur2.next;
			}
		}
		while(cur1!=null){
			//System.out.println("cur1:"+cur1.val+"  cur2:"+cur2.val);
			if(cur1==cur2){
				return cur1;
			}else{
				cur1=cur1.next;
				cur2=cur2.next;
			}	
		}
		return cur1;
	}
	
	
	
	public static void main(String[] args){
		ListNode head=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(8);
		ListNode n4=new ListNode(30);
		ListNode n5=new ListNode(40);
		ListNode n6=new ListNode(60);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		print(head);
		ListNode head2=new ListNode(2);
		ListNode m2=new ListNode(8);
		head2.next=m2;
		m2.next=n3;
		print(head2);
		
		/*head=pushFront(head,0);
		print(head);
		head=popBack(head);
		print(head);
		*/
		
		//System.out.println((FindKthToTail2(head,5)).val);
		
		//System.out.println((FindMinNode(head)).val);
		
		//print(mergeTwoLists(head,head2));
		System.out.println(getIntersectionNode(head,head2).val);
		
	}
}