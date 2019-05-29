import java.util.Arrays;
public class LeetCode{
	/**
	给定一个非负整数数组 A，
	返回一个数组，
	在该数组中,A的所有偶数元素之后跟着所有奇数元素。
	**/
    public static int[] sortArrayByParity(int[] A) {
        int j=0;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                int temp=A[i];
                A[i]=A[j];
                A[j]=temp;
                j++;
            }
        }
        return A;
    }
	/**
	给定一个数组 nums 和一个值 val，
	你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
	注意：不要使用额外的数组空间，
		  你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
		  元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
	**/
	public static int removeElement(int[] nums, int val) {
        int len=nums.length;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }else{
                len--;
            }
        }
        return len;
    }
	public static void main(String[] args){
		int[] A={9,7,5,43,2,1,66,2,2,288,78,65};
		System.out.println(Arrays.toString(sortArrayByParity(A)));
		int len=removeElement(A,2);
		System.out.println(Arrays.toString(Arrays.copyOf(A,len)));
	}
}