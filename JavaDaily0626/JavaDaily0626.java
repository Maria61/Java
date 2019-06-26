import java.util.Arrays;
//抽象类：关键字abstract
//线性表

abstract class List{
	private int size;
	
	public void pushFront(int val){	//头插
		insertInternal(0,val);
	}
	
	public void pushBack(int val){	//尾插
		insertInternal(size,val);
	}
	
	public void insert(int index,int val){
		if(index<0||index>size){
			System.out.println("index 越界");
		}else{
			insertInternal(index,val);
		}	
	}
	
	public void popFront(){	//头删
		delete(0);
	}
	
	public void popBack(){	//尾删
		delete(size-1);
	}
	
	public void delete(int index){
		if(index<0||index>=size){
			System.out.println("index 越界");
		}else{
			delectInternal(index);
		}
	}
	//抽象方法 只能出现在抽象类里，且子类必须实现所有出现在继承抽象类中的抽象方法
	protected abstract void insertInternal(int index,int val);
	
	protected abstract void delectInternal(int index);
	
	public abstract void display();
	
	protected void  increaseSize(){
		size++;
	}
	
	protected void decreaseSize(){
		size--;
	}
	
	public int getSize(){
		return size;
	}
	
}

class ArrayList extends List{
	int[] array=new int[10];
	
	@Override
	public void insertInternal(int index,int val){
		ensureCapacity();
		
		for(int i=getSize();i>index;i--){
			array[i]=array[i-1];
		}
		array[index]=val;
		
		increaseSize();
	}
	
	private void ensureCapacity(){
		if(getSize()<array.length){
			return;
		}
		array=Arrays.copyOf(array,array.length+array.length/2);
	}
	
	@Override
	public void delectInternal(int index){
		for(int i=index;i<getSize()-1;i++){
			array[i]=array[i+1];
		}
		decreaseSize();
	}
	
	@Override
	public void display(){
		for(int i=0;i<getSize();i++){
			System.out.printf("%d,",array[i]);
		}
		System.out.println();
	}
}

public class JavaDaily0626{
	public static void testList(List list){
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		list.pushBack(4);
		list.pushFront(4);
		list.pushFront(5);
		list.display();
		list.popBack();
		list.popFront();
		list.delete(3);
		list.display();
	}
	public static void main(String[] args){
		testList(new ArrayList());
		//List list=new List();//错误用法，抽象类无法实例化
		//List list=new ArrayList();// 多态的用法，向下转型
	}
}