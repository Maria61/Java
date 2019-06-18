
//封装：将链表用一个类封装起来，使用时用该类创建对象再通过  对象.方法   进行调用
//定义链表类时，属性为链表的关键性特征（结点）

class Node{
	int val;
	Node next;
	Node(int val){
		this.val=val;
	}
}
class LinkedList{
	private int size;
	private Node head;
	//size是private型的，本类以外不可访问和修改
	//通过size()方法可以间接访问对象的size,
	//同时避免了用户私自改动size，只能通过一些操作（如头删，尾删，...）来间接修改对象的size
	public int size(){
		return size;
	}
	
	public void pushFront(int val){
		Node node=new Node(val);
		node.next=head;
		this.head=node;
		//head=node;也可以
		size++;
	}
	
	public void pushBack(int val){
		if(head==null){
			pushFront(val);
		}else{
			Node cur=head;
			while(cur.next!=null){
				cur=cur.next;
			}
			cur.next=new Node(val);
			size++;	
		}
	}
	
	public void popFront(){
		if(head==null){
			System.out.println("异常处理");
		}else{
			head=head.next;
			size--;
		}
	}
	
	public void popBack(){
		if(head==null){
			System.out.println("异常处理");
		}else if(head.next==null){
			head=null;
			size=0;
		}else{
			Node cur=head;
			while(cur.next.next!=null){
				cur=cur.next;
			}
			cur.next=null;
			size--;
		}
	}
	
	public void print(){
		Node cur=head;
		while(cur!=null){
			System.out.printf("%d-->",cur.val);
			cur=cur.next;
		}
		System.out.println("null");
	}
}
class ArrayList{
	private int size;
	private int[] array;
	
	public ArrayList(){
		this(5);//调用其他构造方法
	}
	public ArrayList(int len){
		array=new int[len]; 
	}
	
	public int size(){
		return size;
	}
	
	public void pushBack(int val){
		ensureCapacity();
		array[size++]=val;
	}
	
	public void pushFront(int val){
		ensureCapacity();
		for(int i=size;i>0;i--){
			array[i]=array[i-1];
		}
		array[0]=val;
		size++;
	}
	
	public void popBack(){
		if(size==0){
			System.out.println("异常处理");
		}else{
			size--;
		}
	}
	
	public void popFront(){
		if(size==0){
			System.out.println("异常处理");
		}else{
			for(int i=0;i<size-1;i++){
				array[i]=array[i+1];
			}
			size--;
		}
		
	}
	
	private void ensureCapacity(){	//扩容
		if(size<array.length){
			return;
		}
		//1.申请“新房子”
		int newCapacity=array.length+array.length/2;
		int[] newArray=new int[newCapacity];
		//2.“搬家”
		for(int i=0;i<size;i++){
			newArray[i]=array[i];
		}
		//3.“通知大家新地址”
		this.array=newArray;
		//4.“退房”
		
	}
}
public class List{
	public static void main(String[] args){
		LinkedList linkedList=new LinkedList();
		linkedList.pushBack(1);
		linkedList.pushBack(2);
		linkedList.pushBack(3);
		linkedList.pushFront(10);
		linkedList.print();
		
		ArrayList arrayList=new ArrayList();
		arrayList.pushBack(1);
		arrayList.pushBack(2);
		arrayList.pushBack(3);
		arrayList.pushBack(30);
		arrayList.pushBack(60);
		arrayList.pushBack(70);
		
		System.out.println(arrayList.size());
		
	}
}
