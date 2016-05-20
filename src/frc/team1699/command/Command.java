package frc.team1699.command;

public abstract class Command {
	
	String name;
	
	//id is used for commands run in auto. It should be set to and interger value that corrisponds to the value used when wanting to call the command from the autonomous file.
	public Command(String name, int id){
		this.name = name;
	}
	
	public abstract void init();
	public abstract void run();
	public abstract void isFinished();
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
