public class NowCoder{
	//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    public static int NumberOf1(int n) {
        int count=0;
        while(n!=0){
                count++;
                n=n&(n-1);//一个整数与上该整数减一，会使该数最右边的一变为0，
						  //那么该数有多少1，就进行多少次这个操作
        }
        return count;
    }
	public static int NumberOf2(int n) {
        int count=0;
        while(n!=0){
            if((n&1)==1){
                count++;
                
            }
			n=n>>>1;//必须用>>>无符号右移，否则当参数为负数时会出错！！
        }
        return count;
    }
	public static void main(String[] args){
		System.out.println(NumberOf1(-1101));
		System.out.println(NumberOf2(-1101));//耗时更长
	}
}