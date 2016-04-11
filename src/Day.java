import java.io.Serializable;

public class Day implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	Day(int d,int m,int y){
		day=d;
		month=m;
		year=y;
	}
	
	public String printDate(){
		return day+"/"+month+"/"+year;
	}
}
