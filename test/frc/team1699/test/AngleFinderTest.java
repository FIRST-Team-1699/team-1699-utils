package frc.team1699.test;

import org.junit.Test;

import frc.team1699.math.RoboMath;

public class AngleFinderTest {
	
	@Test
	public void getAngle(){
		RoboMath aFind = new RoboMath();
		System.out.println(aFind.getAngle(120, 20, 200));
		int[] l = {1, 2, 6, 3};
		System.out.println(l.length);
	}
}
