class ListNode{
	int val;
	ListNode next;
	ListNode random;
	ListNode(int val){
		this.val=val;
	}
}
public class LeetCode{
	//删除值为val的结点
	public static ListNode deleteRepeatVal(ListNode head,int val){
		ListNode cur=head;
		ListNode newList=null;ListNode last=null;
		while(cur!=null){
			ListNode next=cur.next;
			
			if(cur.val!=val){
				if(newList==null){
					cur.next=newList;
					newList=cur;
				}else{
					last.next=cur;
				}
				last=cur;
			}
			cur=next;
		}
		if(last!=null){
			last.next=null;
		}
		return newList;
	}
	//复制复杂链表
	public static ListNode copyRandomList(ListNode head){
		if(head==null){
			return null;
		}
		//1.复制结点，插入到老结点后
		ListNode cur=head;
		while(cur!=null){
			ListNode node=new ListNode(cur.val);
			node.next=cur.next;
			cur.next=node;
			cur=cur.next.next;
		}
		//2.复制random
		cur=head;
		while(cur!=null){
			if(cur.random!=null){
				cur.next.random=cur.random.next;
			}else{
				cur.next.random=null;
			}
			cur=cur.next.next;
		}
		//3.拆分链表
		ListNode newHead=head.next;
		cur=head;
		while(cur!=null){
			ListNode node=cur.next;
			cur.next=node.next;
			if(node.next!=null){
				node.next=node.next.next;
			}
			cur=cur.next;
		}
		return newHead;
	}
	//删除有序链表的重复结点（不保留重复结点）
	public static ListNode deleteDuplicated(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
		ListNode cur1=head;
		ListNode cur2=head.next;
		ListNode pre=null;
		while(cur2!=null){
			if(cur1.val!=cur2.val){
				pre=cur1;
				cur1=cur2;
				cur2=cur2.next;
			}else{
				while(cur2!=null&&cur2.val==cur1.val){
					cur2=cur2.next;
				}
				if(pre==null){
					head=cur2;
				}else{
					pre.next=cur2;
				}
				cur1=cur2;
				if(cur2!=null){
					cur2=cur2.next;
				}
			}
		}
		return head;
		
	}
	//逆置单链表
	public static ListNode reverse1(ListNode head){		//非递归版
		if(head==null||head.next==null){
			return head;
		}
		ListNode cur=head;
		ListNode newList=null;
		while(cur!=null){
			ListNode next=cur.next;
			cur.next=newList;
			newList=cur;
			cur=next;
		}
		return newList;
	}
	public static ListNode reverse2(ListNode head){		//递归版
		if(head==null||head.next==null){
			return head;
		}else{
			ListNode newList=reverse2(head.next);//newList代表逆置后的链表	
			head.next.next=head;
			head.next=null;
			return newList;
		}
		
	}
	//合并两个有序链表
	public static ListNode mergeTwoList(ListNode head1,ListNode head2){
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		ListNode cur1=head1;
		ListNode cur2=head2;
		ListNode newList=null;
		ListNode last=null;
		while(cur1!=null&&cur2!=null){
			if(cur1.val<=cur2.val){
				ListNode next=cur1.next;
				if(newList==null){
					cur1.next=newList;
					newList=cur1;
				}else{
					last.next=cur1;
				}
				last=cur1;
				cur1=next;
			}else{
				ListNode next=cur2.next;
				if(newList==null){
					cur2.next=newList;
					newList=cur2;
				}else{
					last.next=cur2;
				}
				last=cur2;
				cur2=next;
			}
		}
		if(cur1==null&&cur2!=null){
			last.next=cur2;
		}
		if(cur2==null&&cur1!=null){
			last.next=cur1;
		}
		return newList;
	}
	//打印
	public static void print(ListNode head){
		ListNode cur=head;
		while(cur!=null){
			System.out.printf("%d-->",cur.val);
			cur=cur.next;
		}
		System.out.println("null");
	}
	public static void main(String[] args){
		/*ListNode head=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		head.random=n2;
		n2.random=head;
		n3.random=n3;
		n4.random=n4;
		print(head);
		*/
		//head=deleteRepeatVal(head,1);
		//print(head);
		
		//ListNode head2=copyRandomList(head);
		//print(head2);
		
		ListNode head=new ListNode(1);
		ListNode n2=new ListNode(1);
		ListNode n3=new ListNode(2);
		ListNode n4=new ListNode(3);
		ListNode n5=new ListNode(4);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		print(head);
		
		//head=deleteDuplicated(head);
		//print(head);
		
		//head=reverse2(head);
		//print(head);
		
		ListNode head2=new ListNode(1);
		ListNode m2=new ListNode(2);
		ListNode m3=new ListNode(2);
		ListNode m4=new ListNode(3);
		ListNode m5=new ListNode(4);
		head2.next=m2;
		m2.next=m3;
		m3.next=m4;
		m4.next=m5;
		print(head2);
		head=mergeTwoList(head,head2);
		print(head);
	}
}
