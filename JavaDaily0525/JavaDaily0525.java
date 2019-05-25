import java.util.Arrays;
public class JavaDaily0525{
	//冒泡排序			时间复杂度为：O(n^2)
	public static void bubbleSort(int[] array){
		for(int i=0;i<array.length;i++){
			boolean tmp=false;
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					tmp=true;
				}
			}
			if(!tmp){
				break;
			}
		}	
	}
	//二分查找			时间复杂度为O(log(n))
	public static int binarySearch(int[] array,int key){
		int left=0;
		int right=array.length-1;
		int mid=0;
		while(left<=right){
			mid=left+(right-left)/2;
			if(array[mid]==key){
				return mid;
			}else if(array[mid]>key){
				right=mid-1;
			}else if(array[mid]<key){
				left=mid+1;
			}
		}
			return -1;
	}
	
	//
	
	public static void main(String[] args){
		int[] array={3,1,5,7,94,2,0};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(binarySearch(array,3));
		
	}
}