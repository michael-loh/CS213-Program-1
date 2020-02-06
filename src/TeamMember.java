/**
 
 @author  
 */

public class TeamMember 
{

	private String name;
	private Date startDate;
   
	public TeamMember(String nm, Date date)
	{
       this.name = nm;
       this.startDate = date;
	}
   
	public Date getStartDate()
	{
		return startDate;
	}
   
	@Override
	public boolean equals(Object obj)
	{		
		//name and startDate must be the same
		if( obj == null ) {
			return false;
		}
		if( this.getClass() != obj.getClass() ) {
			return false;
		}
		
		TeamMember temp = (TeamMember) obj;
		if( temp.name.equals( this.name ) && temp.getStartDate().equals(this.getStartDate() ) ) {
			return true;
		}
		return false;
	}  
   
	public String toString()
	{
		//name + " " + startDate;
		return name + " " + this.getStartDate().toString();
	}

   
	public static void main(String [] args)
	{
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.
	}
}
