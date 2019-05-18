public class JavaDaily_5_18{
	
	public static void printArray2(int[] temp){
		for(int j=0;j<temp.length;j++){
			System.out.println(temp[j]);
		}
	}
	
	public static void main(String[] args){
		//动态初始化
		/*int[] x=new int[3];//初始值为0
		int[] temp=null;
		System.out.println(x.length);
		x[0]=1;
		x[1]=2;
		x[2]=3;
		for(int i=0;i<x.length;i++){
			System.out.println(x[i]);
		}
		temp=x;
		temp[0]=55;
		System.out.println(x[0]);
		printArray2(temp);*/
		
		//静态初始化
		/*int[] y={1,2,5,55,555,223,456436,243,1234};
		System.out.println(y.length);
		for(int i=0;i<y.length;i++){
			System.out.println(y[i]);
		}*/
		
		//匿名数组
		/*System.out.println(new int[]
		{1,2,3,4,5,6}.length);*/
		
		//二维数组
		int[][] data=new int[][]{
		{1,2,3},{4,5,6},{6,7,8}};
			printArray(data);
		
	}
	public static void printArray(int[][] temp){
		for(int x=0;x<temp.length;x++){
			for(int y=0;y<temp[x].length;y++){
				System.out.println
				("temp["+x+"]["+y+"]="+temp[x][y]+",");
			}
			System.out.println();
		}
	}
}
