
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
			System.out.println("月不合法："+month);
			return;
		}
		if(day<1||day>getDayOfMonth(year,month)){
			System.out.println("日不合法："+day);
			return;
		}
		
		this.year=year;
		this.month=month;
		this.day=day;
		
		
	}
	
	public void add(int days){
		if(days<0){
			System.out.println("日不合法："+days);
			return;
		}
		day+=days;
		while(day>getDayOfMonth){
			day-=getDayOfMonth;
			month++;
			if(month>12){
				month=1;
				year++;
			}
		}
	}
	
	public void sub(int days){
		if(days<0){
			System.out.println("日不合法："+days);
			return;
		}
		day-=days;
		while(day<1){
			month--;
			if(month<1){
				month=12;
				year--;
			}
			day+=getDayOfMonth(year,month);
		}
		
	}
	
	public String toString(){
		
	}
	
	
}

public class Date{
	public static void main(String[] args){
		
	}
}