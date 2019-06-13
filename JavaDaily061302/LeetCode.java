class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val=val;
	}
}
public class LeetCode{
	public static void print(ListNode head){
		ListNode cur=head;
		while(cur!=null){
			System.out.printf("%d-->",cur.val);
			cur=cur.next;
		}
		System.out.println("null");
	}
	//反转链表
	public static ListNode reverse1(ListNode head){		//非递归法
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
	public static ListNode reverse2(ListNode head){		//递归法
		if(head==null||head.next==null){
			return head;
		}else{
			ListNode newList=reverse2(head.next);//5	5-->4     5-->4-->3    5-->4-->3-->2
			head.next.next=head;				//4		3	      2			   1
			head.next=null;
			return newList;						//5-->4	5-->4-->3 5-->4-->3-->2 5-->4-->3-->2-->1
		}
		
	}
	//删除值重复的结点
	public static ListNode deleteRepeatNode(ListNode head){
		ListNode pre=null;
		ListNode cur1=head;
		ListNode cur2=head;
		while(cur2!=null){
			if(cur1.val!=cur2.val){
				pre=cur1;
				cur1=cur2;
				cur2=cur2.next;
			}else{
				while(cur2!=null){
					if(cur2.val!=cur1.val){
						break;
					}
					cur2=cur2.next;
				}
				if(pre!=null){
					pre.next=cur2;
				}else{		//应对链表前几个结点值重复情况
					head=cur2;
				}
				cur1=cur2;
				if(cur2!=null){
					cur2=cur2.next;
				}
			}
		}
		return head;
	}
	//合并有序单链表
	public static ListNode mergerOrderList(ListNode head1,ListNode head2){
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
			ListNode next1=cur1.next;
			ListNode next2=cur2.next;
			if(cur1.val<=cur2.val){
				if(newList==null){
					cur1.next=newList;
					newList=cur1;
				}else{
					last.next=cur1;
				}
				last=cur1;
				cur1=next1;		//cur的更新必须放在里面，不可以放在循环体的最后
			}else{
				if(newList==null){
					cur2.next=newList;
					newList=cur2;
				}else{
					last.next=cur2;
				}
				last=cur2;
				cur2=next2;
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
	//删除所有值为val的结点
	public static ListNode deleteRepeatVal(ListNode head,int val){
		ListNode cur=head;
		ListNode newList=null;
		ListNode last=null;
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
		return newList;
	}
	public static void main(String[] args){
		ListNode head=new ListNode(1);
		ListNode n2=new ListNode(1);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(3);
		ListNode n5=new ListNode(4);
		ListNode n6=new ListNode(5);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		print(head);
		ListNode head2=new ListNode(2);
		ListNode m2=new ListNode(4);
		ListNode m3=new ListNode(6);
		ListNode m4=new ListNode(8);
		head2.next=m2;
		m2.next=m3;
		m3.next=m4;
		print(head2);
		//head=reverse2(head);
		//print(head);
		//head=deleteRepeatNode(head);
		//print(head);
		head=mergerOrderList(head,head2);
		print(head);
		head=deleteRepeatVal(head,3);
		print(head);
	}
}