
interface  Condition{  //接口
    boolean test(int val);
}
public class JavaDaily0706 {
    private static void printCondition(int[] list,Condition cond){
        for(int val:list){
            if(cond.test(val)){
                System.out.println(val);
            }
        }
    }

    public static void main(String[] args){
        int[] a=new int[100];
        for(int i=0;i<100;i++){
            a[i]=i;
        }
        //成员内部类
        class Even implements Condition{

            @Override
            public boolean test(int val) {
                return val % 2 == 0;
            }
        }

        //打印 2 的倍数
        printCondition(a, new Even() );

        //打印 3 的倍数  //匿名内部类
        printCondition(a, new Condition() {
            @Override
            public boolean test(int val) {
                return val % 3 == 0;
            }
        });
        
        printCondition(a,(int val) -> val % 3 == 0);//Lambda 表达式

        //打印 5 的倍数，使用 Lambda 表达式，变量 -> 条件
        printCondition(a, (int val) -> val % 5 == 0);
    }
}
