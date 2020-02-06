/**
  
 @author  
 */

import java.util.StringTokenizer;

public class Date {

	private int  day;
	private int  month;
	private int  year;
   
	public Date(String d) {
   
		StringTokenizer st = new StringTokenizer(d, "/");
	   
		int i = 0;
	   
		month = Integer.parseInt(st.nextToken());
		day = Integer.parseInt(st.nextToken());
		year = Integer.parseInt(st.nextToken());
	}
   
	public Date(Date d)   
	{
		//this is a constructor
		day = d.getDay();
		month = d.getMonth();
		year = d.getYear();
	}      
   
   
	public boolean isValid() 
	{
		return isValidDay() && isValidMonth();
	}
   
   
	@Override
   
	public String toString()   
	{
		//use the format "month/day/year"
		return month + "/" + day + "/" + year;
	}
   
   
	@Override
	public boolean equals(Object obj)
	{  
		if( obj == null ) {
			return false;
		}
		if( this.getClass() != obj.getClass() ) {
			return false;
		}
		
		Date temp = (Date)obj;
		if( this.getDay() != temp.getDay() || this.getMonth() != temp.getMonth() || this.getYear() != temp.getYear() ) {
			return false;
		}
		
		return true;
	}  
	
	
	//getter methods
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	
	//helper methods
	private boolean isLeapYear() {
		if(year % Month.QUADRENNIAL == 0 && year % Month.CENTENNIAL == 0 && year % Month.QUATERCENTENNIAL == 0) {
			return true;
		}
		return false;
	}
	
	private int daysInMonth() {
		switch(month) {
			case Month.JAN:		//January
				return Month.DAYS_ODD;
			case Month.FEB:		//February
				return (isLeapYear()) ? Month.DAYS_FEB+1: Month.DAYS_FEB;
			case Month.MAR:		//March
				return Month.DAYS_ODD;
			case Month.APR:		//April
				return Month.DAYS_EVEN;
			case Month.MAY:		//May
				return Month.DAYS_ODD;
			case Month.JUN:		//June
				return Month.DAYS_EVEN;
			case Month.JUL:		//July
				return Month.DAYS_ODD;
			case Month.AUG:		//August
				return Month.DAYS_ODD;
			case Month.SEP:		//September
				return Month.DAYS_EVEN;
			case Month.OCT:		//October
				return Month.DAYS_ODD;
			case Month.NOV:		//November
				return Month.DAYS_EVEN;
			case Month.DEC:		//December
				return Month.DAYS_ODD;
		}
		
		return -1;
	}
	
	private boolean isValidDay() {
		return ( day > 0 ) && ( day <= daysInMonth() );
	}
	
	private boolean isValidMonth() {
		return ( month > 0 ) && ( month < 13 );
	}
	
	//test main
	
	public static void main(String[]args) {
		Date d1 = new Date("1/31/2001");
		System.out.println(d1.toString());
		System.out.println(d1.getDay());
		System.out.println(d1.getMonth());
		System.out.println(d1.getYear());
		System.out.println(d1.isValid());
	}
	
}




