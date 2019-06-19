
//继承：父类的属性在子类中可以使用
//但如果子类与父类有同名属性/方法（参数列表也相同），在子类中优先子类的属性和列表

/*在子类中，有属性size ,普通方法中，有形参size,父类中有属性size,此时：
size表示形参/局部变量
this.size表示子类属性
super.size表示父类属性
*/

import java.util.Arrays;
class List{		//父类：线性表
	protected int size;	//protected 子类有权限访问，其他类没有
	
	public int getSize(){//在子类中如果有同名同样参数列表的方法，用 super. 调用
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
	
	public int getSize(){
		return size;
	}
	//用于查看访问权限
	public void setSize(int size){
		size=66;		//形参/局部变量
		this.size=36;	//本身属性
		super.size=10;	//父类属性
		System.out.println(getSize());//子类方法   打印36
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
		//System.out.println(super.getSize());	//打印结果为0,因为该方法改变的是子类中的size，而父类中的size并没有改变
		//System.out.println(getSize());	//子类方法
		
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
		ArrayList arrayList=new ArrayList(10);
		arrayList.pushBack(1);
		arrayList.pushBack(2);
		arrayList.pushBack(3);
		arrayList.pushFront(3);
		System.out.println(arrayList.print());
		arrayList.popBack();
		arrayList.popFront();
		System.out.println(arrayList.print());
		System.out.println(arrayList.getSize());//优先子类的方法/属性，其次是父类
		arrayList.setSize(33);	
		
		
		//*/
		/*LinkedList linkedList=new LinkedList();
		linkedList.pushBack(1);
		linkedList.pushBack(2);
		linkedList.pushBack(3);
		linkedList.pushFront(3);
		linkedList.print();
		linkedList.popBack();
		linkedList.popFront();
		linkedList.print();
		*/
		
		
	}
}
