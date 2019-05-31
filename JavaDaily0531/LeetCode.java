import java.util.Arrays;
public class LeetCode{
	//求字符串数组的最长公共前缀
	public static String longestCommonPrefix(String[] strs) {
        StringBuffer s=new StringBuffer("");
        if(strs.length==0){
            return s.toString();
        }
        if(strs.length==1){
            return strs[0];
        }
		//求最短字符串长度
        int len=strs[0].length();
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<len){
                len=strs[i].length();
            }
        }
		//每个字符串按字母逐一比较
        for(int j=0;j<len;j++){
            for(int i=0;i<strs.length-1;i++){
                if(strs[i].charAt(j)!=strs[i+1].charAt(j)){
                    return s.toString();
                } 
            } 
            s.append(strs[0].charAt(j));//StringBuffer的方法！！用于将字符连接至原字符串后
        }
        return s.toString();
    }
	public static void main(String[] args){
		String[] a={"asdf","ahjkl","axcvb"};
		//System.out.println(Arrays.toString(a));
		System.out.println(longestCommonPrefix(a));
	}
}