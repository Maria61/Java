import java.util.Arrays;
class List{		//父类：线性表
	protected int size;	//protected 子类有权限访问，其他类没有
	
	public int getSize(){
		return size;
	}
}

class Node{
	protected int val;
	protected Node next;
	
	public Node(int val){
		this.val=val;
	}
}

//子类：顺序表
class ArrayList extends List{
	private int[] array;
	private int size;
	
	public ArrayList(int len){
		array=new int[len];
	}
	//用于查看访问权限
	public void setSize(int size){
		size=66;		//形参/局部变量
		this.size=66;	//本身属性
		super.size=66;	//父类属性
	}
	//尾插
	public void pushBack(int val){
		ensureCapacity();
		array[size++]=val;
	}
	//头插
	public void pushFront(int val){
		ensureCapacity();
		for(int i=size-1;i>=0;i--){
			array[i+1]=array[i];
		}
		array[0]=val;
		size++;
	}
	//尾删
	public void popBack(){
		if(size==0){
			System.out.println("异常处理");
		}else{
			array[size--]=0;
		}
	}
	//头删
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
	//扩容
	public void ensureCapacity(){
		if(size<array.length){
			return;
		}else{
			int newCapacity=array.length+array.length/2;
			int[] newArray=new int[newCapacity];
			for(int i=0;i<size;i++){
				newArray[i]=array[i];
			}
			this.array=newArray;
		}
	}
	//打印
	public String print(){
		return Arrays.toString(Arrays.copyOf(array,size));
	}
}
//子类：链表
class LinkedList extends List{
	private Node head;
	private int size;
	//头插
	public void pushFront(int val){
		Node node=new Node(val);
		node.next=head;
		head=node;
		size++;
	}
	//尾插
	public void pushBack(int val){
		if(head==null){
			pushFront(val);
		}else{
			Node node=new Node(val);
			Node cur=head;
			while(cur.next!=null){
				cur=cur.next;
			}
			cur.next=node;
			size++;
		}
	}
	//尾删
	public void popBack(){
		if(head==null){
			return;
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
	//头删
	public void popFront(){
		if(head==null){
			return;
		}else{
			head=head.next;
			size--;
		}
	}
	//打印
	public void print(){
		Node cur=head;
		while(cur!=null){
			System.out.printf("%d-->",cur.val);
			cur=cur.next;
		}
		System.out.println("null");
	}
}
public class Inherit{
	public static void main(String[] args){
		/*ArrayList arrayList=new ArrayList(10);
		arrayList.pushBack(1);
		arrayList.pushBack(2);
		arrayList.pushBack(3);
		arrayList.pushFront(3);
		System.out.println(arrayList.print());
		arrayList.popBack();
		arrayList.popFront();
		System.out.println(arrayList.print());
		*/
		LinkedList.linkedList=new LinkedList();
		linkedList.pushBack(1);
		linkedList.pushBack(2);
		linkedList.pushBack(3);
		linkedList.pushFront(3);
		linkedList.print();
		
	}
}
