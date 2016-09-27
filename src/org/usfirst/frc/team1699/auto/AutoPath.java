package org.usfirst.frc.team1699.auto;

public class AutoPath {
	
	private String path;
	private int[] fileAsString;
	private int width, height;
	
	public AutoPath(String path, int width){
		this.path = path;
		this.width = width;
		this.height = height;
		fileAsString = Utils.loadFileAsArray(path, width);
	}
	
	
	
	public void generateDirections(){
		
	}
}
