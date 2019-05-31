public class NowCoder{
	/**在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
	并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
	**/
    public static  int FirstNotRepeatingChar(String str) {//有问题
        if (str.length() == 0) {
            return  -1;
        }
        char c = 'A';
        if(str.charAt(0) >= 'a'){
            c = 'a';
        }
        int[] counts = new int[58];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - c]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (counts[str.charAt(i) - c] == 1){
                return i;
            }
        }
        return -1;
    }
	public static int FirstNotRepeatingChar2(String str) {
        int[] count=new int[256];
        for(int i=0;i<str.length();i++){
            count[(int)str.charAt(i)]++;
        }
        for(int i=0;i<str.length();i++){
            if(count[(int)str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }
	public static void main(String[] args){
		/*if('a'=='A'){
			System.out.println(true);
		}else{
			System.out.println(false);
		}*/
		System.out.println(FirstNotRepeatingChar("NXWtnzyoHoBhUJaPXauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
			
	}
}