public class NowCoder0526 {
	//递归法
    public static int Fibonacci(int n) {
        if(n<2){
            if(n==0){
                return 0;
            }else{
                return 1;
            }
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
	//非递归法
	public static int Fibonacci2(int n){
		int a=1;
		int b=1;
		int c=0;
		if(n==1||n==2){
			return 1;
		}
		if(n<=0){
			return 0;
		}
		int i=3;
		while(i<=n){
			c=a+b;
			a=b;
			b=c;
			i++;
		}
		return c;
	}
	public static void main(String[] args){
		System.out.println(Fibonacci2(39));
	}
}