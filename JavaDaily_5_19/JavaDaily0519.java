import java.util.Arrays;
public class JavaDaily0519{
	//求最大值
	public static int max(int[] array){
		int maxNum=Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++){
			if(array[i]>maxNum){
				maxNum=array[i];
			}
		}
		
		/*for(int item:array){
			if(item>maxNum){
				maxNum=item;
			}
		}*/
		return maxNum;
	}
	//求最小值
	public static int min(int[] array){
		int minNum=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++){
			if(array[i]<minNum){
				minNum=array[i];
			}
		}
		return minNum;
	}
	//求某个值的下标
	public static int indexOf(int[] array,int key){
		int index=-1;
		for(int i=0;i<array.length;i++){
			if(array[i]==key){
				index=i;
				break;
			}
		}
		return index;
	}
	//去掉一个最大值，一个最小值，求平均值
	public static double average(int[] scores){
		int minNum=min(scores);
		int maxNum=max(scores);
		//System.out.println(maxNum);
		//System.out.println(minNum);
		//int x=indexOf(scores,minNum);
		//int y=indexOf(scores,maxNum);
		//System.out.println(x);
		//System.out.println(y);
		//scores[x]=0;
		//scores[y]=0;
		int sum=0;
		for(int i=0;i<scores.length;i++){
			sum+=scores[i];
		}
		int sum1=sum-maxNum-minNum;
		//System.out.println(sum1);
		double average=(double)sum1/(scores.length-2);
		return average;
	}
	//实现copyOf
	public static int[] copyOf(int[] src,int newlength){
		int[] newArray=new int[newlength];
		int minlength=(src.length<newlength)?src.length:newlength;
		for(int i=0;i<minlength;i++){
			newArray[i]=src[i];
		}
		return newArray;
	}
	//实现二分查找
	public static int binarySearch(int[] array,int key){
		int left=0;
		int right=array.length-1;
		while(left<=right){
			int mid=(left+(right-left))/2;
			if(key==array[mid]){
				return mid;
			}else if(key<array[mid]){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		return -1;
	}
	
	//交换array数组i和j下标位置的数
	public static void swap(int[] array,int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	//实现冒泡排序
	public static void bubbleSort(int[] array){
		for(int i=0;i<array.length;i++){//控制循环的次数，
			boolean isSwapped=false;
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){//相邻两数进行比较交换
					swap(array,j,j+1);
					isSwapped=true;
				}
			}
			if(!isSwapped){
				return;
			}
		}
	}
	
	public static void main(String[] agrs){
		int[] array={9,1,2,3,4,5};
		int[] array2={124,45,36787};
		int[] array3=new int[]{23,4,1,5,8,3};
		//System.out.println(max(array));
		//System.out.println(max(array2));

		//System.out.println(indexOf(array2,45));
		//System.out.println(indexOf(array,4));

		//System.out.println(average(array));
		//System.out.println(average(array2));
		
		//copyOf(array2,5);
		//System.out.println(Arrays.toString(copyOf(array2,5)));
		//System.out.println(Arrays.toString(copyOf(array,3)));
		
		//int index=binarySearch(array,0);
		//System.out.println(index);
		bubbleSort(array3);
		System.out.println(Arrays.toString(array3));
	
	}
}