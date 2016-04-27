package frc.team1699.vision;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Vision{
	
	private int imageWidth, imageHeight, minWidth, maxWidth, minHeight, maxHeight;
	private boolean[][] imagePixels;
	private boolean stop = false;
	private int iteration = 0;
	private int heightFound = 0;
	private int widthFound = 0;

	public Vision(int imageWidth, int imageHeight, int minWidth, int maxWidth, int minHeight, int maxHeight) {
		super();
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		this.minWidth = minWidth;
		this.maxWidth = maxWidth;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		imagePixels = new boolean[imageWidth][imageHeight];
	}

	public void imageToArray(BufferedImage image, int redMin, int redMax, int greenMin, int greenMax, int blueMin, int blueMax){
		int i;
		int j;
		for(i = 0; i < imageWidth; i++){
			for(j = 0; j < imageHeight; j++){
				int iColor = image.getRGB(i, j);
                Color c = new Color(iColor);
                
                if((c.getRed() > redMin && c.getRed() < redMax) && (c.getGreen() > greenMin && c.getGreen() < greenMax) && (c.getBlue() > blueMin && c.getBlue() < blueMax)){
                	imagePixels[i][j] = true;
                }else{
                	imagePixels[i][j] = false;
                }
			}
		}
	}
	
	public void lookForGoal(){
		int i;
		int j;
		for(i = 0; i < imageWidth; i++){
			for(j = 0; j < imageHeight; j++){
				if(imagePixels[i][j]){
					while(!stop){
						if(imagePixels[i + iteration][j] && (i + iteration < imageWidth)){
							
						}else if(imagePixels[i - iteration][j] && (i - iteration > imageWidth)){
							
						}else if(imagePixels[i][j + iteration] && (j + iteration < imageHeight)){
							
						}else if(imagePixels[i][j - iteration] && (j - iteration > imageHeight)){
							
						}else{
							stop = true;
						}
					}
				}
			}		
		}
	}

	public boolean[][] getImagePixels() {
		return imagePixels;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public int getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(int minWidth) {
		this.minWidth = minWidth;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
}
