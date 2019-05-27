public class NowCoder0527 {
	//青蛙跳台阶(只能跳一级或两级)
	public static int JumpFloor(int target) {
        if(target<=0){
            System.out.println("参数不合法！参数必须大于0");
            return 0;
        }
        if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }else{
            return JumpFloor(target-1)+JumpFloor(target-2);
        }
    }
	//变态跳台阶（可跳N级）
    public static int JumpFloorII(int target) {
        if(target==0){
            return 0;
        }else if(target==1){
            return 1;
        }else{
            return 2*JumpFloorII(target-1);
        }
    }
	public static void main(String[] args){
		System.out.println(JumpFloorII(2));
		System.out.println(JumpFloor(3));
	}
}