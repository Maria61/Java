class A{
	A(String title){
		System.out.println(title);
	}
}
public class JavaDaily052502{
	A a=new A("定义时初始化");
	static A staticA=new A("静态属性定义时初始化");
	JavaDaily052502(){
		a=new A("构造方法中初始化");
	}
	{
		a=new A("构造代码块中初始化");
	}
	static{
		staticA=new A("静态属性构造代码块时初始化");
	}
	static{
		staticA=new A("静态属性构造代码块2时初始化");
	}
	public static void main(String[] args){
		JavaDaily052502 j1=new JavaDaily052502();
		JavaDaily052502 j2=new JavaDaily052502();
		
	}
}