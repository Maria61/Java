import java.util.Arrays;
public class JavaDaily0521{
	
	//交换方法
	public static void swap(int[] array,int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	//冒泡排序（减治算法）
	public static void bubbleSort(int[] array){
		for(int i=0;i<array.length;i++){
			boolean temp=false;
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					swap(array,j,j+1);
				}
				temp=true;
			}
			if(!temp){
				return;
			}
		}
	}
	
	public static void main(String[] args){
		int[] array={1, 5, 3, 5, 7,51,36};
		System.out.println(Arrays.toString(array));
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
	
}