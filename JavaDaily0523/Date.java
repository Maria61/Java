/**
 * 如何设计一个类（日期类）
 * 1. 根据需求列出功能：
 * 	1. 传 年、月、日 构造日期类
 * 	2. 在当前日期上增加多少天
 * 	3. 在当前日期上减少多少天
 * 	4. 可以返回字符串 String 的方法		”2019-05-20“
 * 	5. 加一些限制,年支持的范围 [1900, 2100]
 *  6. 如果给定两个日期，希望计算下两个日期之间相差多少天
 * 2. 设计属性
 *	1. 年、月、日
 */
public class Date{
	
	private int year;
	private int month;
	private int day;
	
	public Date(int year,int month,int day){
		if(year<1900||year>2100){
			System.out.println("年不合法："+year);
			return;
		}
		if(month<1||month>12){
			System.out.println("月不合法:"+month);
			return;
		}
		if(day<1||day>31){
			System.out.println("日不合法:"+day);
			return;
		}
		this.year=year;
		this.month=month;
		this.day=day;
	}
	
	private Date(Date other){
		this(other.year,other.month,other.day);
	}
	//在当前日期上增加天数计算新日期
	public void add(int days){
		if(days<1){
			System.out.println("days不合法："+days);
			return;
		}
		day+=days;
		//System.out.println(day);
		//System.out.println(getDayOfMonth(year,month));
		while(day>getDayOfMonth(year,month)){
			day=day-getDayOfMonth(year,month);
			month++;
			if(month>12){
				month=1;
				year++;
			}
		}
	}
	//在当前日期上减少天数计算新日期
	public void sub(int days){
		if(days<1){
			System.out.println("days不合法："+days);
			return;
		}
		day-=days;
		while(day<1){
			month--;
			if(month<1){
				month=12;
				year--;
			}
			//System.out.println(month);
			day+=getDayOfMonth(year,month);
		}
	}
	//格式化打印日期
	public String toString(){
		return String.format("%04d-%02d-%02d",year,month,day);
	}
	//计算两日期相差多少天
	public static int differ(Date d1,Date d2){
		if(!isGreatDay(d1,d2)){
			System.out.println("d1必须大于d2");
			return -1;
		}
		Date temp=new Date(d1);
		int days=0;
		while(isGreatDay(temp,d2)){
			temp.sub(1);
			days++;
			
		}
		return days;
	}
	
	//计算每月的天数
	private static final int[] DAY_OF_MONTH={31,28,31,30,31,30,31,31,30,31,30,31};
	private int getDayOfMonth(int year,int month){
		int days=DAY_OF_MONTH[month-1];
		if(month==2&&isLeapYear(year)){
			days+=1;
		}
		return days;
	}
	//判断是否是闰年
	private static boolean isLeapYear(int year){
		if((year%4==0&&year%100!=0)||year%400==0){
			return true;
		}
		return false;
	}
	//判断是否输入合法的日期
	private static boolean isGreatDay(Date d1,Date d2){
		if(d1.year>d2.year){
			return true;
		}
		if(d1.year==d2.year&&d1.month>d2.month){
			return true;
		}
		if(d1.year==d2.year&&d1.month==d2.month&&d1.day>d2.day){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		Date d1=new Date(2019,05,23);
		System.out.println(d1.toString());
		//d1.add(10);
		d1.add(365);
		System.out.println(d1.toString());
		//d1.sub(3);
		d1.sub(365);
		System.out.println(d1.toString());
		
		Date today=new Date(2019,5,24);
		Date intern=new Date(2021,6,1);
		System.out.println(Date.differ(intern,today));
		 
	}
}