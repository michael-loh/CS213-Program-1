/**
  
 @author  
 */

import java.util.Scanner;
import java.util.StringTokenizer;
public class ProjectManager
{
   Scanner stdin;
   Team cs213;
   public void run()
   {
       
      boolean done = false;
      while ( !done )
      {
         String command = stdin.next();
         switch (command.charAt(0))  
         {   
            case 'A': add(command);
		       
            case 'R': remove(command);
            
            case 'P': print();
            case 'Q': print(); 
            		done =true;    
            default: //deal with bad command here 
            	System.out.println("Command "+ command.charAt(0)+ "not supported!" );
         }  
      }
      //write java code before you terminate the program
   } //run()
   
   private void add(String command)
   {
	  StringTokenizer st = new StringTokenizer(command, " ");
	  st.nextToken();
	  String teamMember = st.nextToken();
	  String dateString =  st.nextToken();
	  Date date = new Date(dateString);
	  TeamMember member = new TeamMember(teamMember,date);
	  if (!date.isValid()) {
		 System.out.println("Date is not valid");
		 
	  }
	  else if(cs213.contains(member)) {
			  System.out.println(teamMember + " " + dateString + " is already in the team." );
		  }
	  else {
		  cs213.add(member);
		  System.out.println(teamMember + " " + dateString + " has joined the team." );
	  }
	  
	  
    //must check if the date is valid
	//must call the contains() method to check if a given 
	//team member is in the team already
   }
   
   
   private void remove(String command)
   {
      //must check if the date is valid
	  StringTokenizer st = new StringTokenizer(command, " ");
	  st.nextToken();
	  String teamMember = st.nextToken();
	  String dateString =  st.nextToken();
	  Date date = new Date(dateString);
	  TeamMember member = new TeamMember(teamMember,date);
	  if (!date.isValid()) {
		 System.out.println("Date is not valid");
		 
	  }
//	  else if(!cs213.contains(member)) {
//		  System.out.println(teamMember + " " + dateString + " is not a team member." );
//	  }
	  else {
		  boolean isRemoved = cs213.remove(member);
		  if(isRemoved) {
			  System.out.println(teamMember + " " + dateString + " has left the team." );
		  }
		  else {
			  System.out.println(teamMember + " " + dateString + " is not a team member." );
		  }
	  }
   }
   
   private void print()
   {
	   if(cs213.isEmpty()) {
		   System.out.println("We have 0 team members!");
		   
	   }
	   else {
		   System.out.println("We have the following team members: ");
		   cs213.print();
		   System.out.println("-- end of the list --");
		   
		   
	   }
      //must check if the team has 0 members. 
   }   
} //ProjectManager

