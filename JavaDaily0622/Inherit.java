class A{
	int a=10;
	static int b=10;
	
	public void method(int a){
		a=20;	//Shadowing
		System.out.println(a);
		System.out.println(this.a);
	}
	public static void staticMethod(){
		System.out.println("父类的静态方法");
	}
}

class B extends A{
	int a=30;
	static int b=30;
	
	public static void staticMethod(){
		System.out.println("子类的静态方法");
	}
}

public class Inherit{
	public static void main(String[] args){
		B b=new B();
		System.out.println(b.a);//30
		System.out.println(b.b);//30
		b.method(5);//20,10,子类对象调用父类方法
		B.staticMethod();//子类的静态方法
		A.staticMethod();//父类的静态方法
		
		
	}
}
