package frc.team1699.vision;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Vision{
	
	private int imageWidth;
	private int imageHeight;
	private boolean[][] imagePixels;
	
	public Vision(int imageWidth, int imageHeight){
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
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
}
