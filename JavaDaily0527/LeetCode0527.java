import java.util.Arrays;
class LeetCode0527 {
	//判断是否是回文数！！！
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else if(x==0){
            return true;
        }else{
			int num=x;
            int reverseOrder=0;
            while(num!=0){
                int temp=num%10;
                num/=10;
                reverseOrder=reverseOrder*10+temp;
            }
			System.out.println(reverseOrder);
            if(reverseOrder==x){
                return true;
            }
            return false;
        }   
    }
	//排序数组，使数组元素所有偶数后跟所有奇数
    public static int[] sortArrayByParity(int[] A) {
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length-i-1;j++){
                if(A[j]%2!=0){
                    int temp=A[j+1];
                    A[j+1]=A[j];
                    A[j]=temp;
                }
            }
        }
        return A;
    }
	public static void main(String[] args){
		//System.out.println(isPalindrome(121));
		int[] A={3,1,2,4};
		sortArrayByParity(A);
		System.out.println(Arrays.toString(A));
	}
}