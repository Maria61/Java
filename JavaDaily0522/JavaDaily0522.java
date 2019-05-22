//定义类 
class Student{
	//定义属性
	String name;
	int age;
	
	//不给出构造方法，系统默认的构造方法
	Student(){}
	//给出的构造方法，构造方法名与类名相同
	Student(String n,int a){
		//System.out.println(n);
		name=n;
		age=a;
	}
	//普通方法
	void print(){
		System.out.println(name);
		System.out.println(age);
		//System.out.println(n);错误，n为构造方法里的参数，该方法不能使用
	}
	//重载
	void print(String s){
		System.out.printf("我是%s,今年%d岁,来自%s班",name,age,s);
	}
	
}

class Student2{
	private String name;
	private int age;
	
	Student2(String name,int age){
		//System.out.printf("Student(%s,%d)%n",name,age);//打印传进来的参数
		this.name=name;
		this.age=age;
		//System.out.printf("Student(%s,%d)%n",this.name,this.age);//打印对象的属性
		
		//this.name="小小";
		System.out.printf("Student(%s,%d)%n",this.name,this.age);//打印对象的属性
		//System.out.printf("Student(%s,%d)%n",name,age);//打印传进来的参数
	}
	
	//this可以调用其他的构造方法
	public Student2(){
		this("小芳",18);//this可以调用其他构造方法，但必须出现在构造方法第一行
		//this();//错误的调用,没有其他构造方法的参数列表与该参数列表相匹配
		this.print();//this相当于对象，可以调用其他方法
	}
	
	void print(){
		System.out.println(name+age+"ou");
	}
	void print(Student2 s){
		//this("xioa",1);//this只能在构造方法中调用其他构造函数,这样会报错
		System.out.println(name+age+"ha");
		
	}
	
}

public class JavaDaily0522{
	public static void main(String[] args){
		Student s1=new Student();
		//s1.print();
		//System.out.println(s1.name+s1.age);//null0
		
		Student s2=new Student("小明",18);//小明
		//s2.Student("小明2",2);//错误的调用方法，构造方法不能这样调用！
		//System.out.println(s2.name+s2.age);//小明18
		//s2.print();
		
		Student s3;//没有初始化，直接调用s3的方法会报错!
		//s3=new Student("小红",3);
		//s3.print();//小红 3
		
		Student s4=null;//定义了一个引用变量，初始化了，但没有构造对象
		//s4.Student("小胡",4);//错误的调用方法，构造方法不能这样调用！
		//s4.print();//会报错  NullPointerException  简称NPE
		s4=new Student("小胡",4);
		//s4.print();//小胡  4
		//s4.print("机械171");
		
		Student2 s5=new Student2("小华",20);//Student(小华,20)
		//s5.print();
		s5.print(s5);//小华20
		
		new Student2().print(new Student2());
		
	} 
}