class Group{
	//属性
	String name;
	int num;
	//方法
	Group(String n,int m){
		name=n;
		num=m;
	}
	//构造新方法
	void print(String welcome){
		System.out.printf("%s %s 的 %d 位同学们%n",welcome,name,num);
	}
}

class B{
	int sum;
	//这里的方法名要和类名相同
	B(int a,int b,int c){
		System.out.println(a+b+c);
		sum=a+b+c;
	}
	void print(){
		System.out.println(sum);
	}
}

//一个文件只允许一个类用public修饰，这个类名称为文件名
public class JavaDaily051902{
	public static void main(String[] args){
		//定义一个对象group
		Group group=new Group("java10班",50);
		//调用
		group.print("欢迎来到比特，");
		
		B b=new B(1,3,5);
		//b.print();
	}
}