package org.usfirst.frc.team1699.auto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AutoPath {
	
	private String path;
	private int[][] fileAsString;
	private int width, height;
	
	public AutoPath(String path, int width, int height){
		this.path = path;
		loadFileAsArray();
		this.width = width;
		this.height = height;
		fileAsString = new int[width][height];
		loadFileAsArray();
	}
	
	public void loadFileAsArray(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			int i = 0;
			while((line = br.readLine()) != null){
				String[] l = line.split(" ");
				for(int j = 0; j < l.length; j++){
					fileAsString[i][j] = Utils.parseInt(l[j]);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void generateDirections(){
		
	}
}
