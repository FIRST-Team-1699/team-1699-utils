package frc.team1699.test;

import org.junit.Test;

import frc.team1699.vision.AngleFinder;

public class AngleFinderTest {
	
	@Test
	public void getAngle(){
		AngleFinder aFind = new AngleFinder(100);
		System.out.println(aFind.getAngle(120, 20));
	}
}