//Hiding一定涉及到继承
class A{
	int field=1;
	static int staticField=2;
	
	static void staticMethod(){
		System.out.println("父类的静态方法");
	}
}

class B extends A{
	int field=100;
	static int staticField=200;
	
	static void staticMethod(){
		System.out.println("子类的静态方法");
	}
	
	public void method(){
		System.out.println(field);
		System.out.println(this.field);
		System.out.println(super.field);
	}
}

public class HidingExample{
	public static void main(String[] args){
		B object=new B();
		
		System.out.println(object.field);
		System.out.println(object.staticField);
		System.out.println(B.staticField);
		B.staticMethod();
		
		System.out.println(A.staticField);
		A.staticMethod();
		
	}
}