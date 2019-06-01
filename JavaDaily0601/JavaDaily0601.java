import java.util.Arrays;
public class JavaDaily0601{
	private int size=0;
	private int[] array;
	
	public JavaDaily0601(){
		array=new int[10];
	}
	
	public JavaDaily0601(int[] array){
		//this.array指的是该属性！
		this.array=new int[array.length*2];
		for(int i=0;i<array.length;i++){
			this.array[i]=array[i];
		}
		size=array.length;
	}
	//扩容
	private void ensureCapacity(){
		if(size<array.length){
			return;
		}
		int oldCapacity=array.length;
		int newCapacity=oldCapacity+oldCapacity/2;
		int[] newArray=new int[newCapacity];
		for(int i=0;i<array.length;i++){
			newArray[i]=array[i];
		}
		array=newArray;
	}
	//插入
	public void insert(int index,int element){
		if(index<0||index>size){
			System.out.println("下标不合法！");
			return;
		}
		for(int i=size-1;i>=index;i--){
			array[i+1]=array[i];
		}
		array[index]=element;
		size++;
	}
	//删除
	public void erase(int index){
		if(index<0||index>=size){
			System.out.println("下标不合法！");
			return;
		}
		for(int i=index;i<size-1;i++){
			array[i]=array[i+1];
		}
		size--;
		array[size]=0;
	}
	//打印
	public String print(){
		return Arrays.toString(Arrays.copyOf(array,size));
	}
	
	public static void main(String[] args){
		int[] array={1,2,3,4,5};
		JavaDaily0601 array2=new JavaDaily0601(array);
		System.out.println(array2.print());
		array2.insert(1,6);
		array2.insert(3,6);
		array2.insert(5,6);
		array2.insert(7,6);
		array2.insert(9,6);
		System.out.println(array2.print());
		array2.erase(3);
		array2.erase(5);
		array2.erase(0);
		array2.erase(6);
		System.out.println(array2.print());
	}
}