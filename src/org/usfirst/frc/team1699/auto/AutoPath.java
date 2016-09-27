package org.usfirst.frc.team1699.auto;

public class AutoPath {
	
	private String path;
	private int[] fileAsString;
	private int width;
	
	public AutoPath(String path, int width){
		this.path = path;
		this.width = width;
		fileAsString = Utils.loadFileAsArray(path, width);
	}
	
	
	
	public void generateDirections(){
		
	}
}
