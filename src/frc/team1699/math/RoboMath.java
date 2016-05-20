package frc.team1699.math;

public class RoboMath {
	
	public double getAngle(int centerX, double distance, int imageCenter){
		if(centerX - imageCenter >= 0) {
			return Math.atan(Math.toRadians(((centerX - imageCenter) / distance)));
		}else{
			return Math.atan(Math.toRadians((Math.abs((centerX - imageCenter) / distance)))) * -1;
		}
		
	}
}
