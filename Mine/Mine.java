public class Mine{
	
	public static void learnIdentifier(){
	    int a=100;
		int A=200;//大写与小写是两个各自变量，没有影响
		int d=03;
		long b=100L;
		int _h=2;//可以但不建议
		int $m=20;//可以但不建议
		int c;//变量要初始化才可以用！
		String 哈="呵呵";
		char 啊='呵';
		//下列是错误的变量命名
		//int 23A=10;
		//int .23=11;
		//int public =10;
		
		
		System.out.println(a);
		System.out.println(A);
		System.out.println(d);
		System.out.println(b);
		System.out.println(_h);
		System.out.println($m);
		System.out.println(哈);
		System.out.println(啊);
	}
	
	public static void learnLiteral(){
		byte a=100;
		//byte b=128;  报错，超范围了！
		//int c=100l;  long转int会数据丢失，编译会报错
		int d=0xFF;
		int e=0b1010;
		double m=1.0;
		float n=2.0f;
		
		System.out.println(a);
		System.out.println(d);//输出结果为十进制
		System.out.println(e);//同上
		System.out.println(m);
		System.out.println(n);
	}
	
	public static void learnUnicode(){
		String a="中国";
		String b="\u4e2d\u56fd";
		
		System.out.println(a);
		System.out.println(b);
	}
	
	public static void learnTypeCast(){
		long a=100l;
		//byte b=a;
		int c=(int)a;//小类型—>大类型，需强制类型转换
		long d=c;//大类型—>小类型，直接赋值即可
		//short e=c;
		
		System.out.println(a);
		//System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		//System.out.println(e);
	}
	
	public static void learnDefaultValue() {
		int a;
		a = 10;
		System.out.println(a);
	}
	
	/*public static void learnRange(){
		System.out.println("byte的取值范围是：");
		System.out.println(Byte.MAX_VALUES);
		System.out.println(Byte.MIN_VALUES);
	}*/
	
	public static void learnStringAdd() {
		int a = 3;
		int b = 4;
		
		System.out.println("结果是" + a + b);
		System.out.println("结果是" + (a + b));
	}
	
	public  static void main(String[] args){
		//learnIdentifier();
		//learnUnicode();
		//learnLiteral();
		//learnTypeCast();
		//learnDefaultValue();
		//learnRange();
		learnStringAdd();
		
	}
}