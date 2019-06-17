
//封装：将链表的各种头插，尾插...等方法写在一个类里，
//用户只需创建对象，用 对象.属性 调用即可

class DNode{
	int val;
	DNode next;
	DNode prev;
	
	DNode(int val){
		this.val=val;
	}
}
//双向链表
class DLinkedList{
	private DNode head;
	private DNode last;
	private int size;
	
	public int size(){
		return size;
	}
	
	public void pushFront(int val){
		DNode node=new DNode(val);
		node.next=head;
		if(head!=null){
			head.prev=node;
		}
		head=node;
		if(last==null){
			last=node;
		}
		size++;
	}
	
	public void pushBack(int val){
		DNode node=new DNode(val);
		if(head==null){
			pushFront(val);
		}else{
			last.next=node;
			node.prev=last;
			last=node;
			size++;
		}
	}
	
	public void popFront(){
		if(head==null){
			return;
		}else{
			head=head.next;
			head.prev=null;
			if(head==null){
				last=null;
			}
			size--;
		}
	}
	
	public void popBack(){
		if(head==null){
			return;
		}else if(head.next==null){
			popFront();
		}else{
			last=last.prev;
			last.next=null;
			size--;
		}
	}
	public void print(){
		DNode cur=head;
		while(cur!=null){
			System.out.printf("(%14s,  %2d(%s),  %14s)",cur.prev,cur.val,cur,cur.next);
			cur=cur.next;
			System.out.println();
		}
		System.out.println();
	}
}
public class DList{
	public static void main(String[] args){
		DLinkedList doubleLinkedList=new DLinkedList();
		doubleLinkedList.print();
		doubleLinkedList.pushBack(1);
		doubleLinkedList.pushBack(2);
		doubleLinkedList.pushBack(3);
		doubleLinkedList.pushFront(10);
		doubleLinkedList.print();
	}
}
