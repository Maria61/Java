import java.util.Arrays;
public class NowCoder {
	/**
	输入一个整数数组，
	实现一个函数来调整该数组中数字的顺序，
	使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
	并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	**/
    public static void reOrderArray(int [] array) {
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]%2==0&&array[j+1]%2==1){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
	public static void main(String[] args){
		int[] array={1,2,3,4,5,6,6,7};
		reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
}