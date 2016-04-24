package frc.team1699.vision;

public class AngleFinder {
	
	private int imageCenter;
	
	public AngleFinder(int imageCenter){
		this.imageCenter = imageCenter;
	}
	
//Must test
	public double getAngle(int centerX, double distance){
		if(centerX - imageCenter >= 0) {
			return Math.atan(Math.toDegrees((centerX - imageCenter) / distance));
		}else{
			return Math.atan(Math.toDegrees((centerX - imageCenter) / distance)) * -1;
		}
		
	}
}
