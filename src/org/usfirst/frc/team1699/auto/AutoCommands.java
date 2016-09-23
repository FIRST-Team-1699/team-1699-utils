package org.usfirst.frc.team1699.auto;

import java.util.ArrayList;

import org.usfirstfrc.team1699.command.Command;

public abstract class AutoCommands {
	
	private ArrayList<Command> autoCommands;
	
	public AutoCommands(){
		autoCommands = new ArrayList<Command>();
	}
	
	public abstract void forward(int distance);
	public abstract void backward(int distance);
	public abstract void turnLeft(int degree);
	public abstract void turnRight(int degree);
	public abstract void function();
	
	public void addCommand(Command c){
		autoCommands.add(c);
	}
	
	public void callCommand(String name){
		for(int i = 0; i < autoCommands.size(); i++){
			if(autoCommands.get(i).getName().equals(name)){
				//Run command
			}
		}
	}
	
}
