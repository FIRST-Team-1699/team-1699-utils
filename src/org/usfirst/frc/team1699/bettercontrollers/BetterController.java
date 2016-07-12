/*
 * FIRST Team 1699
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 * An interface for a better speed controller.
 */
package org.usfirst.frc.team1699.bettercontrollers;

import edu.wpi.first.wpilibj.SpeedController;

public interface BetterController extends SpeedController
{
	public void reverseOutput();
	public boolean getreverseOutput();
	public void setreverseOutput(boolean _reversed);
}
