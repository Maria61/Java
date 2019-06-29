import java.util.Arrays;
//迭代器接口
interface Iterator{
	boolean hasNext();	//判断当前位置数据是否为最后一个数据
	int next();	//返回当前数据，后移一位
}
//线性表接口	相当于合同，列出需求操作
interface List{		
	//插入
	void pushFront(int val);
	void pushBack(int val);
	void insert(int index,int val);
	//返回数据个数
	int getSize();
	//打印
	void display();		//不在抽象类里实现，在抽象类的子类实现
	//统一遍历方式
	Iterator iterator();	//Iterator 类型？
	//删除
	void popFront();
	void popBack();
	void erase(int index);
	//按下标访问或修改
	int get(int index);
	void set(int index,int val);
	
}
interface RandomAccess{
	
}
//抽象类:线性表		接口中这一类（线性表类）动作相同的操作
abstract class AbstractList implements List{	
	private int size;
	
	@Override
	public void pushBack(int val){
		insertInternal(size,val);
	}
	
	@Override 
	public void pushFront(int val){
		insertInternal(0,val);
	}
	
	@Override
	public void insert(int index,int val){
		if(index<0||index>size){
			System.out.println("下标错误");
		}else{
			insertInternal(index,val);
		}
	}
	
	abstract void insertInternal(int index,int val);//抽象方法
	protected void increaseSize(){
		size++;
	}
	
	protected void decreaseSize(){
		size--;
	}
	@Override
	public int getSize(){
		return size;
	}
	
	@Override
	public void popFront(){
		eraseInternal(0);
	}
	
	@Override
	public void popBack(){
		eraseInternal(size-1);
	}
	
	@Override
	public void erase(int index){
		if(index<0||index>=size){
			System.out.println("下标错误");
			return;
		}
		eraseInternal(index);
	}
	
	abstract void eraseInternal(int index); 

}
//实现 顺序表 迭代器   //具体操作与链表不同，单独用一个类实现
class ArrayListIterator implements Iterator{	
	private ArrayList arrayList;
	private int currentIndex;
	
	ArrayListIterator(ArrayList arrayList){
		this.arrayList=arrayList;
		this.currentIndex=0;
	}
	
	@Override 
	public boolean hasNext(){
		return currentIndex<arrayList.getSize();
	}
	
	@Override
	public int next(){
		int val=arrayList.array[currentIndex];
		currentIndex++;
		return val;
	} 
	
}
class Node{
	int val;
	Node next;
	
	Node(int val,Node next){
		this.val=val;
		this.next=next;
	}
	
	Node(int val){
		this(val,null);
	}
}


//顺序表的其他实现	//实现 顺序表 在 线性表 中 特有的操作
class ArrayList extends AbstractList implements List,RandomAccess{	
	int[] array=new int[5];
	
	@Override
	public Iterator iterator(){
		return new ArrayListIterator(this);//this？
	}
	@Override
	public void insertInternal(int index,int val){
		ensureCapacity();
		for(int i=getSize();i>index;i--){
			array[i]=array[i-1];
		}
		array[index]=val;
		increaseSize();
	}
	@Override
	public void display(){
		for(int i=0;i<getSize();i++){
			System.out.printf("%d,",array[i]);
		}
		System.out.println();
	}
	
	private void ensureCapacity(){	//扩容
		if(getSize()<array.length){
			return;
		}
		array=Arrays.copyOf(array,2*array.length);
	}
	
	@Override
	public void eraseInternal(int index){
		for(int i=index;i<getSize()-1;i++){
			array[i]=array[i+1];
		}
		decreaseSize();
	}
	@Override
	public int get(int index){
		if(index<0||index>=getSize()){
			System.out.println("下标错误");
			return -1;
		}
		return array[index];
	}
	@Override
	public void set(int index,int val){
		if(index<0||index>=getSize()){
			System.out.println("下标错误");
			return;
		}
		array[index]=val;
	}
}

//链表 的其他实现	//实现 链表 在 线性表 中特有的操作
class LinkedList extends AbstractList implements List,RandomAccess{
	Node head=null;
	
	@Override
	public void insertInternal(int index,int val){
		if(index==0){
			head=new Node(val,head);
		}else{
			Node cur=head;
			for(int i=0;i<index-1;i++){
				cur=cur.next;
			}
			cur.next=new Node(val,cur.next);
		}
		increaseSize();
	}
	
	@Override
	public void eraseInternal(int index){
		if(index==0){
			head=head.next;
		}else{
			Node cur=head;
			for(int i=0;i<index-1;i++){
				cur=cur.next;
			}
			cur.next=cur.next.next;
		}
		decreaseSize();
	}
	
	@Override
	public int get(int index){
		if(index<0||index>getSize()-1){
			System.out.println("下标错误");
			return -1;
		}
		Node cur=head;
		for(int i=0;i<index;i++){
			cur=cur.next;
		}
		return cur.val;
	}
	@Override
	public void set(int index,int val){
		if(index<0||index>getSize()-1){
			System.out.println("下标错误");
			return;
		}
		Node cur=head;
		for(int i=0;i<index;i++){
			cur=cur.next;
		}
		cur.val=val;
	}
	//实现 链表 迭代器
	class LinkedListIterator implements Iterator{
		private Node cur=head;	//?
		
		
		@Override
		public boolean hasNext(){
			return cur!=null;
		}
		
		@Override
		public int next(){
			int val=cur.val;
			cur=cur.next;
			return val;
		}
	}
	@Override
	public Iterator iterator(){
		return new LinkedListIterator();
	}
	
	@Override
	public void display(){
		Node cur=head;
		while(cur!=null){
			System.out.printf("%d-->",cur.val);
			cur=cur.next;
		}
		System.out.println();
	}
}

public class ListByInterface{
	private static void testList(List list){
		list.pushBack(1);
		list.pushBack(2);
		list.pushFront(3);
		list.pushFront(4);
		list.pushFront(5);
		list.insert(3,10);
		list.display();
		
		list.popBack();
		list.popFront();
		list.erase(2);
		list.display();
		
		list.set(1,10);
		list.display();
		//System.out.println(list.get(2));
		
		Iterator it1=list.iterator();
		Iterator it2=list.iterator();
		System.out.println(it1.next());
		while(it1.hasNext()){
			System.out.printf("%d,",it1.next());
		}
		System.out.println();
		while(it2.hasNext()){
			System.out.printf("%d,",it2.next());
		}
		System.out.println();
	}
	public static void main(String[] args){
		testList(new ArrayList());
		testList(new LinkedList());
	}
}







