/*
 * FIRST Team 1699
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 * An class implementing BetterController for a TalonSRX.
 */
package org.usfirst.frc.team1699.bettercontrollers;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;

public class BetterTalonSRX extends TalonSRX implements SpeedController, BetterController {

	
	// Initializer
	private boolean reversed = false;
	
	
	// Constructor
	public BetterTalonSRX(int channel)
	{
		super(channel);
	}

	
	// Getters and Setters
	public void reverseOutput() {this.reversed = !reversed;}
	public boolean getreverseOutput() {return this.reversed;}
	public void setreverseOutput(boolean _reversed) {this.reversed = _reversed;}

	
	// Methods
	public void set(double speed)
	{
		if (reversed == true)
		{
			super.set(-1 * speed);
		}
		else if (reversed == false)
		{
			super.set(1 * speed);
		}
	}
}
