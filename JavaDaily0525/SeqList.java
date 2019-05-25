import  java.util.Arrays;
public class SeqList{
	//属性
	private int[] array;
	private int size;
	//构造方法
	public SeqList(){
		//初始化部分
		array  = new int[7];
		size = 0;
	}
	
	
	//扩容
	private void ensureCapacity(){
		if(size<array.length){
			return;
		}
		int newCapacity=array.length+array.length/2;
		int[] newArray=new int[newCapacity];
		for(int i=0;i<array.length;i++){
			newArray[i]=array[i];
		}
		this.array=newArray;
		
	}
	
	//尾插	O(1)
	public void pushBack(int element){
		ensureCapacity();
		array[size++]=element;
	}
	
	//头插法	O(n)
	public void pushFront(int element){
		ensureCapacity();
		for(int i=size-1;i>=0;i--){
			array[i+1]=array[i];
		}
		array[0]=element;
		size++;
	}
	//中间插入	O(1)
	public void insert(int index,int element){
		ensureCapacity();
		if(index<0||index>size){
			System.out.println("index不合法");
			return;
		}
		for(int i=size-1;i>=index;i--){		//思考i的含义
			array[i+1]=array[i];
		}
		array[index]=element;
		size++;
	}
	//尾删
	public void popBack(){
		if(size==0){
			System.out.println("空表无法删除");
			return;
		}
		array[size-1]=0;
		size--;
	}
	//头删
	public void popFront(){
		if(size==0){
			System.out.println("空表无法删除");
			return;
		}
		for(int i=0;i<size-1;i++){
			array[i]=array[i+1];
		}
		array[size-1]=0;
		size--;	
	}
	//删除指定位置的元素
	public void erase(int index){
		if(size==0){
			System.out.println("空表无法删除");
			return;
		}
		for(int i=index;i<size-1;i++){
			array[i]=array[i+1];
		}
		size--;
	}
	//查找指定元素下标
	public int indexOf(int element){
		for(int i=0;i<size;i++){
			if(array[i]==element){
				return i;
			}
		}
		return -1;
	}
	
	//查找元素
	public int get(int index){
		if(index<0||index>size-1){
			System.out.println("index不合法");
			return -1;
		}
		return array[index];
	}
	//修改给定下标的值
	public void set(int index,int element){
		if(index<0||index>size-1){
			System.out.println("index 不合法");
		}
		array[index]=element;
	}
	//删除遇到的第一个elament       O(n)
	public void remove(int element){
		int index=indexOf(element);
		if(index!=-1){
			erase(index);
		}
	}
	//删除遇到的所有element
	public void removeAll(int element){
		//时间复杂度O(n^2)	空间复杂度O(1)
		/*for(int i=0;i<size;i++){
			if(array[i]==element){
				erase(i);
			}
		}*/
		//时间复杂度O(n^2)	空间复杂度O(1)
		/*int index;
		while((index=indexOf(element))!=-1){
				erase(index);
		}*/
		//时间复杂度O(n)	空间复杂度O(n)
		/*int[] newArray=new int[size];
		int j=0;
		for(int i=0;i<size;i++){
			if(array[i]!=element){
				newArray[j++]=array[i];
			}
		}
		for(int i=0;i<j;i++){
			array[i]=newArray[j];
		}
		size=j;
		*/
		//时间复杂度O(n)	空间复杂度O(1)
		int j=0;
		for(int i=0;i<size;i++){
			if(array[i]!=element){
				array[j++]=array[i];
			}
		}
		size=j;
		
	}
	//打印
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array,size));
	}
	
	public static void test1(String[] args){
		SeqList seqList=new SeqList();
		System.out.println(seqList.toString());
		
		seqList.pushFront(1);
		seqList.pushFront(2);
		seqList.pushFront(3);
		System.out.println(seqList.toString());
		
		seqList.pushBack(10);
		seqList.pushBack(20);
		seqList.pushBack(30);
		seqList.pushBack(300);
		seqList.pushBack(4000);
		System.out.println(seqList.toString());
		System.out.println(seqList.array.length);
		seqList.popBack();
		seqList.popBack();
		System.out.println(seqList.toString());
		
		seqList.popFront();
		seqList.popFront();
		System.out.println(seqList.toString());
		
		seqList.pushBack(3);
		seqList.pushBack(16);
		seqList.pushBack(56);
		System.out.println(seqList.toString());
		
		seqList.erase(3);
		System.out.println(seqList.toString());
		
		System.out.println(seqList.indexOf(56));
		System.out.println(seqList.indexOf(65));
		
		System.out.println(seqList.get(3));
		
		seqList.set(2,100);
		System.out.println(seqList.toString());
	}
	public static void test2(String[] args){
		SeqList s=new SeqList();
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		s.pushBack(5);
		System.out.println(s.toString());
		s.remove(3);
		System.out.println(s.toString());
		s.removeAll(4);
		System.out.println(s.toString());
		
	}
	public static void main(String[] args){
		//test1(args);
		test2(args);
		
	}

}