public class NowCoder{
	/**问题描述：
	写一个方法，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
	**/
	/*思路：1.两个数异或：相当于每一位相加，而不考虑进位；
			2.两个数相与，并左移一位：相当于求得进位；
			3.将上述两步的结果相加；
	*/
	public static int Add(int num1,int num2) {
        while (num2!=0) {//不考虑进位的结果加上进位即最后结果，一直循环，直到进位为0 ，循环结束
            int temp = num1^num2;//异或相当于加，但不考虑进位
            num2 = (num1&num2)<<1;//按位与再左移一位用来计算进位
            num1 = temp;
        }
        return num1;
    }
	public static int Add2(int num1,int num2) {//递归版本！
        if(num2==0){
            return num1;
        }else{
            return Add(num1^num2,(num1&num2)<<1);
        }
    }
	public static void main(String[] args){
		int a=2;
		int b=19;
		System.out.println(Add(a,b));
		System.out.println(Add2(a,b));
	}
}