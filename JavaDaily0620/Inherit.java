class A{
	protected int size=10;
	
	public int getSize(){
		return size;
	} 
	
}

class B extends A{
	private int size=20;
	
	public void setSize(int size){
		System.out.println(size);	//Shadowing 
		System.out.println(this.size);
		System.out.println(super.size);
	}
	public void setSize(){	//Overload
		size=555;
		System.out.println(size);//Hiding
	}
}

public class Inherit{
	public static void main(String[] args){
		B b=new B();
		//Package01.Obscuring.name="aaa";
		System.out.println(Package01.Obscuring.name);//Obscuring
		b.setSize(2);
		b.setSize();
	}
}