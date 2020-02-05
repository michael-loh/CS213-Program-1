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
		if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
			return true;
		}
		return false;
	}
	
	private int daysInMonth() {
		switch(month) {
			case 1:		//January
				return 31;
			case 2:		//February
				return (isLeapYear()) ? 29:28;
			case 3:		//March
				return 31;
			case 4:		//April
				return 30;
			case 5:		//May
				return 31;
			case 6:		//June
				return 30;
			case 7:		//July
				return 31;
			case 8:		//August
				return 31;
			case 9:		//September
				return 30;
			case 10:	//October
				return 31;
			case 11:	//November
				return 30;
			case 12:	//December
				return 31;
		}
		
		return -1;
	}
	
	private boolean isValidDay() {
		return ( day > 0 ) && ( day <= daysInMonth() );
	}
	
	private boolean isValidMonth() {
		return ( month > 0 ) && ( month < 13 );
	}
	
}


