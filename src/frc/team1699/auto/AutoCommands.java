package frc.team1699.auto;

import java.util.ArrayList;

import frc.team1699.command.Command;

public abstract class AutoCommands {
	
	private ArrayList<Command> autoCommands;
	
	public AutoCommands(){
		autoCommands = new ArrayList<Command>();
	}
	
	public abstract void forward(int distance);
	public abstract void backward(int distance);
	public abstract void turnLeft(int distance);
	public abstract void turnRight(int distance);
	
	public void addCommand(String name){
		autoCommands.add(new Command(name));
	}
	
}
