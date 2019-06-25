//多态
class Base{
	
	void method(){
		System.out.println("Base 的 method 方法");
	}
	
	static void staticmethod(){
		System.out.println("Base 的 staticmethod 方法");
	}
}

class D1 extends Base{
	@Override	//重写检查
	void method(){
		System.out.println("D1 的 method 方法");
	}
	
	static void staticmethod(){
		System.out.println("D1 的 staticmethod 方法");
	}
	
}

public class Polymorphism{
	public static void main(String[] args){
		D1 d1=new D1();
		Base base=d1;	//向下转型
		
		//普通方法调用看后面的对象类型（根本的）来决定执行哪个方法
		base.method();	// D1 的 method 方法
		d1.method();	// D1 的 method 方法
		
		//静态方法调用看前面的引用类型（直接的）来决定执行哪个方法
		//静态方法不建议用对象调用，一般用类直接调用
		base.staticmethod();	// Base 的 staticmethod 方法
		d1.staticmethod();	// d1 的 staticmethod 方法
		
		//super.staticmethod(); 	错误用法，super只能在子类中使用
	}
}