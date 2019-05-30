public class LeetCode{
	/**罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
	字符          数值
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	例如， 
	罗马数字 2 写做 II ，即为两个并列的 1。
	12 写做 XII ，即为 X + II 。 
	27 写做  XXVII, 即为 XX + V + II 。

	通常情况下，罗马数字中小的数字在大的数字的右边。
	但也存在特例，例如 4 不写做 IIII，而是 IV。
	数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
	同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

	I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
	X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
	C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
	给定一个罗马数字，将其转换成整数。
	**/
	public static int romanToInt(String s) {
        int re=0;
		//System.out.println(s.length());
        for(int i=0;i<s.length();++i){
            switch(s.charAt(i)){
                case'I':
                    re+=1;
                    break;
                case'V':
                    re+=5;
                    break;
                case'X':
                    re+=10;
                    break;
                case'L':
                    re+=50;
                    break;
                case'C':
                    re+=100;
                    break;
                case'D':
                    re+=500;
                    break;
                case'M':
                    re+=1000;
                    break;   
            }
			
        }
		
        for(int j=0;j<s.length()-1;j++){
            switch(""+s.charAt(j)+s.charAt(j+1)){
                case"IV":
                case"IX":
                    re-=2;
                    break;
                case"XL":
                case"XC":
                    re-=20;
                    break;
                case"CD":
                case"CM":
                    re-=200;
                    break;
            }
        }
        return re;
    }
	public static void main(String[] args){
		String s="IX";
		System.out.println(romanToInt(s));
		
	}
}