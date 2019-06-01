class Node{
	public int value;
	public Node next;
	public Node(int value){
		this.value=value;
		this.next=null;
	}
	
}
public class LinkedList{
	//链表初始化
	public static Node creatLinkedList(){
		Node n1=new Node(100);
		Node n2=new Node(200);
		Node n3=new Node(300);
		Node n4=new Node(400);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		return n1;
	}
	
	//头插
	public static Node pushFront(Node head,int value){
		//1.创建一个新的节点
		Node newNode=new Node(value);
		//2.新结点的next指向首结点
		newNode.next=head;
		//此时，首节点已经发生变化，为插入的新节点，返回该节点，更新首节点
		return newNode;
	}
	
	//尾插
	public static Node pushBack(Node head,int value){
		//判断链表是否为空，若为空，转化为头插法
		if(head==null){
			return pushFront(head,value);
		}else{
			//若不为空：
			//1.创建新结点
			Node newNode=new Node(value);
			//2.找到最后一个节点
			Node last=getLast(head);
			//最后的节点指向新结点，即完成尾插
			last.next=newNode;
			return head;
		}
		
	}
	
	//头删
	public static Node popFront(Node head){
		return head.next;
	}
	
	//尾删
	public static Node popBack(Node head){
		if(head.next==null){
			return null;
		}else{
			Node cur=head;
			while(cur.next.next!=null){
				cur=cur.next;
			}
			cur.next=null;
			return head;
		}
	}
	
	//找最后一个节点
	public static Node getLast(Node head){
		Node cur=head;
		while(cur.next!=null){
			cur=cur.next;
		}
		return cur;
	}
	
	//打印
	public static void display(Node head){
		for(Node cur=head;cur!=null;cur=cur.next){
			System.out.printf("%d-->",cur.value);
		}
		System.out.println("null");
	}
	
	//逆序链表
	public static Node reverseList1(Node head){	//遍历每个节点，头插到一个新链表中
		Node list=null;
		Node cur=head;
		while(cur!=null){
			Node next=cur.next;
			cur.next=list;
			list=cur;
			cur=next;
		}
		return list;
	}
	public static Node reverseList2(Node head){	//三变量法
	/*思路：将所有结点的next指向反过来（即将next指向后继变为指向它的前驱），
	n2指向首节点，n1为空结点（尾随n2），n3为n2的next
		1.先保存n2的next（后序n2的next指向会发生变化，若不提前保存，n2的next就会丢失）
		2.将n2的next指向n1
		3.n1和n2前移，改变下一个next的指向
			1.先移动n1,n1=n2;
			2.再移动n2,n2=n3;
	
	*/
		Node n1=null;
		Node n2=head;
		
		while(n2!=null){
			Node n3=n2.next;
			n2.next=n1;
			n1=n2;
			n2=n3;
		}
		return n1;
	}
	
	// 删除链表中等于给定值 val 的所有节点
	public static Node popAll(Node head,int value){
		if(head==null){
			return null;
		}
		Node prev=head;
		Node cur=head.next;
		while(cur!=null){
			if(cur.value==value){
				prev.next=cur.next;
			}else{	//如果有删除，cur的前驱暂时不用改变！因为删除后,新的cur的前驱还是被删除的结点的前驱
				prev=cur;
			}
			cur=cur.next;
		}
		if(head.value==value){
			head=head.next;
		}
		return head;
	}
	public static Node popAll2(Node head,int value){
		Node newList=null;
		Node cur=head;
		while(cur!=null){
			if(cur.value!=value){
				//尾插到newList
				newList=pushBack(newList,cur.value);
			}
			cur=cur.next;
		}
		return newList;
	}
	public static Node popAll3(Node head,int value){
		Node newList=null;
		Node newLast=null;
		Node cur=head;
		while(cur!=null){
			Node next=cur.next;
			if(cur.value!=value){
				//尾插到newList
				if(newList==null){
					cur.next=newList;
					newList=cur;
				}else{
					/*Node last=newList;
					while(last.next!=null){
						last=last.next;
					}
					last.next=cur;
					cur.next=null*/
					System.out.println(newLast.value);
					newLast.next=cur;
				}
				newLast=cur;
			}
			cur=next;
		}
		if(newLast!=null){
			newLast.next=null;
		}
		
		return newList;
	}
	
	public static void main(String[] args){
		Node head=null;//首节点   表示head 指向空链表
		
		head=pushBack(head,1);
		head=pushBack(head,30);
		display(head);
		
		head=pushFront(head,30);
		head=pushFront(head,20);
		head=pushFront(head,20);
		head=pushFront(head,30);
		head=pushFront(head,30);
		display(head);
		
		/*Node head2=creatLinkedList();
		display(head2);
		
		head2=popBack(head2);
		display(head2);*/
		
		head=reverseList1(head);
		display(head);
		head=reverseList2(head);
		display(head);
		
		head=popAll3(head,30);
		display(head);
	}
}
