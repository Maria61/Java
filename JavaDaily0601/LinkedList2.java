class Node{
	public int value;
	public Node next;
	
	public Node(int value){
		this.value=value;
		this.next=null;
	}
}
public class LinkedList2{
	//逆置
	public static Node reverseList(Node head){
		//遍历取出每一个结点，将该结点头插到新链表中，返回新链表
		Node cur=head;
		Node newList=null;
		while(cur!=null){
			Node next=cur.next;
			cur.next=newList;	//此过程会改变cur.next，要注意将cur.next提前保存一份
			newList=cur;
			cur=next;
		}
		return newList;
	}
	//删除所有值为val的结点
	public static Node popAll(Node head,int value){
		/*将结点值不等于value的结点尾插到一个新链表中，返回新链表
			1.创建新链表
			2.遍历链表，找到值不等于value的结点
			3.将找到的结点尾插到新链表中
				1.新链表若为空，转换为头插；
				2.若不为空，记录最后一个结点,尾插
		*/
		Node newList=null;
		Node cur=head;
		Node newLast=null;
		while(cur!=null){
			Node next=cur.next;
			if(cur.value!=value){
				if(newList==null){
					cur.next=newList;
					newList=cur;
					newLast=cur;
				}else{
					newLast.next=cur;
					newLast=cur;
				}
			}
			cur=next;
		}if(newLast!=null){
			newLast.next=null;
		}
		return newList;
	}
	//打印
	public static void display(Node head){
		for(Node cur=head;cur!=null;cur=cur.next){
			System.out.printf("%d-->",cur.value);
		}
		System.out.println("null");
	} 
	
	public static void main(String[] args){
		Node n1=new Node(1);
		Node n2=new Node(1);
		Node n3=new Node(2);
		Node n4=new Node(5);
		Node n5=new Node(1);
		Node n6=new Node(3);
		Node n7=new Node(4);
		Node n8=new Node(1);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=n8;
		
		Node head=n1;
		display(head);
		head=reverseList(head);
		display(head);
		head=popAll(head,1);
		display(head);
		
		Node head2=null;
		head2=popAll(head2,1);
		display(head2);
	}
}