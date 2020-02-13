/**
 Michael Loh
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
		TeamMember t1 = new TeamMember("Daniel", new Date("1/1/2020"));				//testing contstructor and toString()
		System.out.println(t1.toString());
		
		TeamMember t2 = new TeamMember("Daniel", new Date("1/1/2020"));				//testing equals with a successful case
		System.out.println(t1.equals(t2));
		
		TeamMember t3 = new TeamMember("Mark", new Date("1/1/2020"));				//testing equals with different name
		System.out.println(t1.equals(t3));
		
		TeamMember t4 = new TeamMember("Daniel", new Date("12/31/2020"));			//testing equals with different date
		System.out.println(t1.equals(t4));
	}
}
