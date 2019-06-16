
//本地测试代码
/*
	1.将实现具体需求的方法放在一个专门的类里，这里是Solution，
	在测试方法中调用时，要创建一个对象，用  对象.方法  的形式调用
	
	2.将测试方法test...放在主类里，为主类的静态方法，
	然后在主方法main中调用主类的方法test...即可
*/

class Node{
	int val;
	Node next;
	Node(int val){
		this.val=val;
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode random;
	ListNode(int val){
		this.val=val;
	}
}
//存放具体方法的类
class Solution{
	//复制复杂链表
	public ListNode copyRandomList(ListNode head){
		if(head==null){
			return null;
		}
		//1.复制结点值和next;
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
			}
			cur=cur.next.next;
		}
		//3.拆分新老链表
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
	//反转链表
	public Node reverseList(Node head){
		Node cur=head;
		Node newList=null;
		while(cur!=null){
			Node next=cur.next;
			cur.next=newList;
			newList=cur;
			cur=next;
		}
		return newList;
	}
	//删除值为val的结点
	public Node removeAll1(Node head,int val){
		if(head==null){
			return null;
		}
		Node pre=head;
		//跳过第一个，最后处理
		Node cur=head.next;
		while(cur!=null){
			//如果相等，就删除
			if(cur.val==val){
				pre.next=cur.next;
			}else{
				pre=cur;
			}
			cur=cur.next;
		}
		if(head.val==val){
			return head.next;
		}
		return head;
	}
	public Node removeAll2(Node head,int val){
		Node newList=null;
		Node last=null;
		Node cur=head;
		while(cur!=null){
			Node next=cur.next;
			//如果不等于val就尾插到新链表中
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
	//合并有序链表
	public Node merge(Node head1,Node head2){
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		Node cur1=head1;
		Node cur2=head2;
		Node newList=null;
		Node last=null;
		while(cur1!=null&&cur2!=null){
			if(cur1.val<=cur2.val){
				Node next=cur1.next;
				if(newList==null){
					cur1.next=newList;
					newList=cur1;
				}else{
					last.next=cur1;
				}
				last=cur1;
				cur1=next;
			}else{
				Node next=cur2.next;
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
		if(cur1==null){
			last.next=cur2;
		}
		if(cur2==null){
			last.next=cur1;
		}
		return newList;
	}
	//删除重复结点
	public Node deleteDuplicate(Node head){
		Node cur1=head;
		Node cur2=head.next;
		Node pre=null;
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
	//打印
	public void print(Node head){
		Node cur=head;
		while(cur!=null){
			System.out.printf("%d-->",cur.val);
			cur=cur.next;
		}
		System.out.println("null");
	}
	public void print2(ListNode head){
		ListNode cur=head;
		while(cur!=null){
			System.out.printf("%s,%d,%s%n",
			cur,cur.val,cur.random);

			cur=cur.next;
			System.out.println();
			
		}
		System.out.println();
		System.out.println();
	}
	
	
}
public class LeetCode{
	//用来测试某个方法的方法
	static void testRemoveAll1(){
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		//通过    对象.方法   这种形式调用类Solution中的普通方法
		new Solution().print(n1);
		new Solution().print(new Solution().removeAll1(n1,2));
	}
	static void testRemoveAll2(){
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		new Solution().print(n1);
		new Solution().removeAll2(n1,4);
		new Solution().print(n1);
	}
	static void testDeleteDuplicate(){
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(2);
		Node n4=new Node(4);
		Node n5=new Node(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		new Solution().print(n1);
		new Solution().deleteDuplicate(n1);
		new Solution().print(n1);
	}
	static void testReverseList(){
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(2);
		Node n4=new Node(4);
		Node n5=new Node(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		new Solution().print(n1);
		Node newList=new Solution().reverseList(n1);
		new Solution().print(newList);
	}
	static void testMerge(){
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(2);
		Node n4=new Node(4);
		Node n5=new Node(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		Node m1=new Node(1);
		Node m2=new Node(20);
		Node m3=new Node(20);
		m1.next=m2;
		m2.next=m3;
		new Solution().print(n1);
		new Solution().print(m1);
		new Solution().print(new Solution().merge(n1,m1));
	}
	static void testCopyRandomList(){
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n1.random=n2;
		n2.random=n1;
		n3.random=n3;
		n4.random=n3;
		new Solution().print2(n1);
		ListNode head=new Solution().copyRandomList(n1);
		new Solution().print2(head);
		
	}
	public static void main(String[] args){
		//testRemoveAll1();
		//testRemoveAll2();
		//testDeleteDuplicate();
		//testReverseList();
		//testMerge();
		testCopyRandomList();
	}
}