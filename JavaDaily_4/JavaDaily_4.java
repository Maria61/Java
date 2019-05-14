public class JavaDaily_4{
	//求n的位数
	public static int calcDigitNum(long n){
		int count=0;
		while(n!=0){
			n=n/10;
			count++;
		}
		return count;
	}
	//求n的阶乘
	public static long factorial(int n){
		while(n>=0){
			if(n==1||n==0){
				return 1;
			}
			else{
				return factorial(n-1)*n;
			}
		}
		return -1;
	}
	public static long factorial2(int n){
		long fact=1;
		for(int i=1;i<=n;i++){
			fact=fact*i;
		}
		return fact;
	}
	
	
	//**************求e
	public static double cala(int n){
		double  e=0;
		for(int i=0;i<n;i++){
			e=e+(1.0/factorial(i));
		}
		return e;
	}
	//public static double calaE();
	//*********求π  
	public static double calapi(int n){
		double pi4=0;
		for(int i=0;i<n;i++){
			int m=2*i+1;
			if(i%2==0){
				pi4=pi4+1.0/m;
			}
			else{
				pi4=pi4-1.0/m;
			}
		}
		return pi4*4;
	}
	
	//反转字符串
	public static String reverse(String s){
		int length=s.length();
		String r="";
		for(int i=length-1;i>=0;i--){
			char ch=s.charAt(i);
			r=r+ch;
		}
		return r;
	}
	
	//将十进制转换为十六进制
	public static String decToHex(int dec){
		String hex="";
		while(dec>=16){
			int remainder=dec%16;
			dec=dec/16;
			if(remainder<10){
				hex+=remainder;
			}else{
				char ch=(char)('A'+remainder-10);
				hex+=ch;
			}
			
		}
		if(dec!=0){
			hex+=dec;
		}
		return reverse(hex);
	}
	
	
	public static void main(String[] args){
		//System.out.println("5_14");
		/*int n=193824;
		long a=Long.parseLong(args[0]);
		System.out.println(calcDigitNum(n));
		System.out.println(calcDigitNum(a));*/
		
		/*int b=5;
		System.out.println(factorial2(b));*/
		
		/*double e=cala(10);
		System.out.println(e);
		System.out.println(calapi(500000));*/
		
		//System.out.println(reverse("Hello"));
		
		System.out.println(decToHex(1958));
		
	}
}