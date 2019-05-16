public class JavaDaily_6{
	
	//字符串反转
	public static String reverse(String s){
		int length=s.length();
		String r="";
		for(int i=length-1;i>=0;i--){
			r+=s.charAt(i);
		}
		return r;
	}
	
	//十进制转换十六进制
	public static String decToHex(int dec){
		String hex="";
		while(dec>=16){
			int reminder=dec%16;
			dec=dec/16;
			if(reminder>=10){
				hex+=(char)('A'+reminder-10);
			}else{
				hex+=reminder;
			}
		}
		if(dec!=0){
			if(dec>=10){
				hex+=(char)('A'+dec-10);
			}else{
				hex+=dec;
			}
		}
		return reverse(hex);
	}
	
	public static void main(String[] args){
		System.out.println(reverse("hello"));
		System.out.println(decToHex(420));
	}
} 