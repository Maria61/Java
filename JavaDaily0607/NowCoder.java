public class NowCoder{
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