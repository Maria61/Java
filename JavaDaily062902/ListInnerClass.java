/**
 *通过内部类实现迭代器
**/
//接口自带abstract
//迭代器接口
interface Iterator{
	boolean hasNext();//判断是否有下一个
	int next();//返回当前值，后移一位
}
//线性表接口
interface List{
	//插入
	void pushBack(int val);
	void pushFront(int val);
	void insert(int index,int val);
	//删除
	void popBack();
	void popFront();
	void erase(int index);
	//根据下标访问或者修改
	int get(int index);
	void set(int index,int val);
	//返回个数
	int getSize();
	//统一的遍历方式
	Iterator iterator(); 
	
}
interface RandomAccess{
}
//抽象类：线性表
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
			return;
		}
		insertInternal(index,val);
	}
	@Override
	public void popBack(){
		erase(size-1);
	}
	@Override
	public void popFront(){
		erase(0);
	}
	@Override
	public void erase(int index){
		if(index<0||index>=size){
			System.out.println("下标错误");
			return;
		}
		eraseInternal(index);
	}
	abstract void insertInternal(int index,int val);
	abstract void eraseInternal(int index);
	@Override
	public int getSize(){
		return size;
	}
	
	protected void increaseSize(){
		size++;
	}
	protected void decreaseSize(){
		size--;
	}
}
//子类：顺序表
class ArrayList extends AbstractList implements List,RandomAccess{
	private class ArrayListIterator implements Iterator{
		private int currentIndex=0;
		
		@Override
		public boolean hasNext(){
			return currentIndex<getSize();
		}
		@Override
		public int next(){
			int val=array[currentIndex];
			currentIndex++;
			return val;
		}
	}
	private int[] array=new int[10];
	
	@Override
	public void insertInternal(int index,int val){
		for(int i=getSize();i>index;i--){
			array[i]=array[i-1];
		}
		array[index]=val;
		increaseSize();
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
		if(index<0||index>getSize()-1){
			System.out.println("下标错误");
			return -1;
		}
		return array[index];
	}
	@Override
	public void set(int index,int val){
		if(index<0||index>getSize()-1){
			System.out.println("下标错误");
			return;
		}
		array[index]=val;
	}
	@Override 
	public Iterator iterator(){
		return new ArrayListIterator();
	}
}
class LinkedList extends AbstractList implements List,RandomAccess{
	private class Node{
		private int val;
		private Node next;
		
		Node(int val,Node next){
			this.val=val;
			this.next=next;
		}
		
		Node(int val){
			this(val,null);
		}
	}
	private class LinkedListIterator implements Iterator{
		private Node cur=head;
		
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
	public void insertInternal(int index,int val){
		if(index==0){
			head=Node(val,head);
		}else{
			Node cur=head;
			for(int i=0;i<index-1;i++){
				cur=cur.next;
			}
			cur.next=Node(val,cur.next);
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
	@Override 
	public Iterator iterator(){
		return new LinkedListIterator();
	}
	
}
public class ListInnerClass{
	public static void testList(List list){
		list.pushBack(1);
		list.pushFront(3);
		list.pushBack(4);
		list.insert(2,10);
		
		Iterator it1=list.iterator();
		while(it1.hasNext()){
			System.out.printf("%d ,",it1.next());
		}
	}
	public static void main(String[] args){
		testList(new ArrayList());
	}
}
