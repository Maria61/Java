public class NowCoder {
	//替换空格
    public static String replaceSpace(StringBuffer str) {
    	for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                str.deleteCharAt(i);//StringBuffer里的方法
                str.insert(i,"%20");//同上
            }
        }
        return str.toString();
    }
	public static void main(String[] args){
		//String s="asd dfg d";
		StringBuffer s=new StringBuffer("asd fgg h");
		System.out.println(replaceSpace(s));
	}
}