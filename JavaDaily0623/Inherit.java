//先执行构造代码块，再执行构造方法
//先执行父类，再执行子类
//只有用到类时才加载,类加载时静态代码块执行
class Base{
	Base(){
		System.out.println("Base的构造方法");
	}
	{
		System.out.println("Base的构造代码块 1");
	}
	static {
		System.out.println("Base的静态构造代码块");	//静态构造代码块在类加载时执行
	}
	
}

class Derived extends Base{
	static {
		System.out.println("Derived的静态构造代码块");
	}
	
	{
		System.out.println("Derived的构造代码块");
	}
	
	Derived(){
		System.out.println("Derived的构造方法");
	}
}

public class Inherit{
	public static void main(String[] args){
		System.out.println("开始");
		new Derived();
		System.out.println("结束");
		
	}
} 