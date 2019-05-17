public class JavaDaily_7{
	
	public static int printStarTower(int line){
		for(int x=0;x<line;x++){
			for(int y=0;y<line-x;y++){
				System.out.print(" ");
			}
			for(int z=0;z<x;z++){
				System.out.print("* ");
			}
			System.out.println();
		}
		return 0;
	}
	
	public static int learnSwitch(char x){
		System.out.println("请输入字符：");
		//char x=(char)System.in.read();
		switch(x){
			case'a':{
				System.out.println("我是猪");
				break;
			}
			case'b':{
				System.out.println("我不是猪");
				break;
			}
			default:{
				System.out.println("我真的不是猪");
			}
		}
		return 0;
	}
	
	public static void myPrint(int x){
		if(x==2){
			return ;
		}else{
			System.out.println(x);
		}
	}
	
	
	public static void main(String[] args){
		//System.out.println(printStarTower(10));
		//System.out.println(learnSwitch('b'));
		//System.out.println(myPrint(2));//有问题
	
	}
	
	
	
}