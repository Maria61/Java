public class JavaDaily_5{
	
	//求n的阶乘
	public static int factorial(int n){
		while (n>=0){
			if(n==1||n==0){
				return 1;
			}else{
				return n*factorial(n-1);
			}
		}
		return -1;
	}
	
	//求e,精度<=precision
	public static double calaE(double precision){
		double e=0;
		double item=0;
		int n=0;
		while(true){
			item=1.0/factorial(n++);
			e+=item;
			if(item<precision){
				break;
			}
		}
		return e;
	}
	
	//求π
	public static double calaPi(int n){
		double Pi4=0;
		int i=0;
		for(i=0;i<n;i++){
			int m=2*i+1;
			if(i%2==0){
				Pi4+=1.0/m;
			}else{
				Pi4-=1.0/m;
			}
		}
		return Pi4*4;
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
	
	public static void main(String[] args){
		//System.out.println(factorial(5));
		
		//System.out.println(calaE(0.00001));
		
		//System.out.println(calaPi(5000000));
		
		System.out.println(reverse("hello"));
	}
}