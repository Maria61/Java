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
		System.out.println(field);//100
		System.out.println(this.field);//100
		System.out.println(super.field);//1
	}
}

public class HidingExample{
	public static void main(String[] args){
		B object=new B();
		
		System.out.println(object.field);	//100
		System.out.println(object.staticField);//200	不建议用对象调用静态属性
		System.out.println(B.staticField);//200
		B.staticMethod();//“子类的静态属性”
		
		System.out.println(A.staticField);//2
		A.staticMethod();//“父类的静态属性”
		
	}
}