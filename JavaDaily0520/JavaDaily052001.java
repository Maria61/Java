import java.util.Arrays;

public class JavaDaily052001{
	//数组初始化方法
	public static void initArray(){
		//静态初始化
		int[] array={1,2,3,4,5};
		int[] array2=new int[]{23,5464,75};
		//匿名数组
		printArray(new int[]{2,4,6,8,0});
		System.out.println();
		printArray(array);
		System.out.println();
		printArray(array2);
		System.out.println();
		
		//动态初始化
		//int[] array1=new int[10];
		int[] array1=null;
		array1=new int[10];
		
		printArray(array1);
		System.out.println();		
		for(int i=0;i<10;i++){
			array1[i]=i;
		}
		printArray(array1);
		System.out.println();
		
	}
	public static void printArray(int[] array){
		//foreach形式
		for(int item:array){
			System.out.print(item+" ,");
		}
	}
	//更改array不会影响到实参
	public static void method1(int[] array){
		//通过new将array指向一个新开辟的空间
		array=new int[]{0,0,1,4,6};
		//array=new int[10];同效
		System.out.println(Arrays.toString(array));
	}
	
	//通过引用，更改实际的数组（堆）中的值
	public static void method2(int[] array){
		array[2]=999;
		
	}
	
	//数组被复制一份，修改互不影响
	public static void testCopyArray(){
		int[] srcArray={1,2,3,4};
		int[] destArray=Arrays.copyOf(srcArray,srcArray.length);
		destArray[2]=520;
		System.out.println(destArray[2]);
	}
	//只是修改了引用，指向相同的数组，修改的是相同的数组
	public static void testCopyArray(){
		int[] srcArray={1,2,3,4};
		int[] destArray=srcArray;
		destArray[2]=5299;
		System.out.println(destArray[2]);
	}
	
	public static void main(String[] args){
		//initArray();
		int[] array={1,3,5,7,9};
		System.out.println(Arrays.toString(array));
		method1(array);
		System.out.println(Arrays.toString(array));
		method2(array);
		System.out.println(Arrays.toString(array));
		
	}
}