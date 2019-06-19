class A{
	int size=5;
	
	public void method(int size){
		System.out.println(size);	//形参	打印100
		System.out.println(this.size);	//属性  打印5
	}
}

public class ShadowingExample{
	public static void main(String[] args){
		A a=new A();
		a.method(100);
	}
}