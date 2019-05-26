class LeetCode0526 {
    public static int reverse(int x) {
        int newX=0;
        int temp=0;
        while(x!=0){
            temp=x%10;
            x/=10;
			if(newX>(Integer.MAX_VALUE/10)||(newX==(Integer.MAX_VALUE/10)&&temp>7)
			||newX<(Integer.MIN_VALUE/10)||(newX==(Integer.MIN_VALUE/10)&&temp<-8)){
				return 0;
			}
            newX=newX*10+temp;
        }
		//System.out.println(newX);
		//System.out.println(temp);
        
        return newX;
    }
	public static void main(String[] args){
		System.out.println(reverse(-2147483412));
	}
}