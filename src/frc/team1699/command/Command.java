package frc.team1699.command;

public abstract class Command {
	
	String name;
	
	public Command(String name){
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
