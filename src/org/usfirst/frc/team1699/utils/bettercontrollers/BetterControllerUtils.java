package org.usfirst.frc.team1699.utils.bettercontrollers;

public class BetterControllerUtils {

	/**
	 * Makes sure that a parameter is above -1 and below 1. Prints out if the value is out of range.
	 * 
	 * @param n the value to be checked
	 * @return the value after it's checked
	 */
	protected static double check(double n, boolean supress, String toString) {
		if (n > 1.0) {
			if (supress == false) {
				System.err.println("Htting max speed in " + toString);
			}
			return 1.0;
		}
		if (n < -1.0) {
			if (supress == false) {
				System.err.println("Htting min speed " + toString);
			}
			return -1.0;
		}
		return n;
	}
	
}
