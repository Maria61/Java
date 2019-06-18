class A{
	int size=5;
	
	public void method(int size){
		System.out.println(size);
		System.out.println(this.size);
	}
}

public class ShadowingExample{
	public static void main(String[] args){
		A a=new A();
		a.method(100);
	}
}