import java.util.Arrays;
//迭代器接口
interface Iterator{
	boolean hasNext();	//判断当前位置数据是否为最后一个数据
	int next();	//返回当前数据，后移一位
}
//线性表接口
interface List{		
	void pushFront(int val);
	void pushBack(int val);
	void insert(int index,int val);
	int getSize();
	void display();		//不在抽象类里实现，在抽象类的子类实现
	Iterator iterator();	//？
}
interface RandomAccess{
	
}
abstract class AbstractList implements List{	//抽象类:线性表
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
	
	abstract void insertInternal(int index,int val);
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
}
class ArrayListIterator implements Iterator{	//实现 线性表 迭代器
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

class ArrayList extends AbstractList implements List,RandomAccess{	//顺序表的其他实现
	int[] array=new int[10];
	
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
	
	private void ensureCapacity(){
		if(getSize()<array.length){
			return;
		}
		array=Arrays.copyOf(array,2*array.length);
	}
}

public class ListByInterface{
	private static void testList(List list){
		list.pushBack(1);
		list.pushBack(2);
		list.pushFront(3);
		list.insert(3,10);
		list.display();
		
		Iterator it1=list.iterator();
		Iterator it2=list.iterator();
		System.out.println(it1.next());
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
	}
	public static void main(String[] args){
		testList(new ArrayList());
	}
}







