/**
  Varun Vasudevan 
 @author  
 */

import java.util.Scanner;

public class ProjectManager
{
	Scanner stdin;
	Team cs213;
   
	public void run()
	{   
		stdin = new Scanner(System.in);
		cs213 = new Team();
		
		boolean done = false;
      
		while ( !done )
		{
			String command = stdin.next();
			
			switch ( command )  
			{   
				case "A": 
					add();
					break; 
				case "R": 
					remove();
					break;
				case "P": 
					print();
					break;
				case "Q": 
					print();
					successfulQuit();
					done = true;
				default: 
					System.out.println("Command '" + command + "' is not supported!");
					stdin.nextLine();
			}  
		}
		//write java code before you terminate the program
	} //run()
   
	private void add()
	{
		String name = stdin.next();
		
		//must check if the date is valid
		String date = stdin.next();
		Date d = new Date(date);
		if( !d.isValid() ) {
			invalidDateError(date);
			return;
		}
		
		//must call the contains() method to check if a given
		TeamMember member = new TeamMember(name, d);
		if(cs213.contains(member)) {
			
			//team member is in the team already
			duplicateMemberError(member);
			return;
		}
		
		cs213.add(member);
		successfulAdd(member);
		
	}
   
	private void remove()
	{
		String name = stdin.next();
		
		//must check if the date is valid   
		String date = stdin.next();
		Date d = new Date(date);
		if(!d.isValid()) {
			invalidDateError(date);
			return;
		}
		
		//Initialize the TeamMember
		TeamMember member = new TeamMember(name, d);
		
		//check if Team contains member
		if(!cs213.contains(member)) {
			memberNotFound(member);
			return;
		}
		
		//remove the member
		cs213.remove(member);
		successfulRemove(member);
		
	}
	
	private void print()
	{
		//must check if the team has 0 members. 
		if(cs213.isEmpty()) {
			System.out.println("We have 0 team members!");
			return;
		}
		
		//print out list of team members
		System.out.println("We have the following members:");
		cs213.print();
		System.out.println("-- end of list --");
	}
	
	//helper methods
	private void invalidDateError(String date) {
		System.out.println(date + " is not a valid date!");
	}

	private void duplicateMemberError(TeamMember m) {
		System.out.println(m.toString() + " is already in the team.");
	}
	
	private void successfulAdd(TeamMember m) {
		System.out.println(m.toString() + " has joined the team.");
	}
	
	private void successfulRemove(TeamMember m) {
		System.out.println(m.toString() + " has left the team.");
	}
	
	private void memberNotFound(TeamMember m) {
		System.out.println(m.toString() + " is not a team member.");
	}
	
	private void successfulQuit() {
		System.out.println("The team is ready to go!");
	}
} //ProjectManager
