/**
  
 @author  
 */
public class Team 
{

	private final int NOT_FOUND = -1;
	private final int GROW_SIZE = 4; //initial and grow size
	private TeamMember [] team;
	private int numMembers;
	
	public Team()
	{
		//this is the default constructor
		team = new TeamMember[GROW_SIZE];
		numMembers = 0;
	}
   
	private int find(TeamMember m)
	{
		for(int i = 0; i < numMembers; i++) {
			if(m.equals(team[i])) return i;
		}
		return -1;
	}
   
	private void grow()
	{
		TeamMember[] newTeam = new TeamMember[ team.length + GROW_SIZE ];
		for(int i = 0; i < team.length; i++) {
			newTeam[i] = team[i];
		}
		team = newTeam;
	}
   
	public boolean isEmpty()
	{
		if(numMembers == 0) {
			return true;
		}
		return false;
	}
   
	public void add(TeamMember m)
	{     
		if(numMembers >= team.length) {
			grow();
		}
		team[numMembers] = m;
		numMembers++;
	}
   
	public boolean remove(TeamMember m)
	{
		int index =  find(m);
		
		if(index == -1) return false;
		
		for(int i = index; i < numMembers-1; i++) {
			team[i] = team[i+1];
		}
		numMembers--;
		team[numMembers] = null;
		return true;
	} 
   
	public boolean contains(TeamMember m)
	{
		for(int i = 0; i < numMembers; i++) {
			if( m.equals(team[i]) ) return true;
		}
		return false;
	} 
   
	public void print()
	{
		//set up a for loop and call the toString() method
		for(int i = 0; i < numMembers; i++) {
			System.out.println(team[i].toString());
		}
	}
	
	public static void main(String[]args) {
		Team team = new Team();
		
		TeamMember t1 = new TeamMember("Bob", new Date("1/31/2019"));
		team.add(t1);
		team.print();
		
		TeamMember t2 = new TeamMember("Karen", new Date("2/14/2019"));
		team.add(t2);
		team.print();
		
		System.out.println(team.contains(t2));
		
		team.remove(t2);
		team.print();
		
		System.out.println(team.contains(t2));
		
		System.out.println(team.isEmpty());
		
		team.remove(t1);
		team.print();
		
		System.out.println(team.isEmpty());
		
	}
}
