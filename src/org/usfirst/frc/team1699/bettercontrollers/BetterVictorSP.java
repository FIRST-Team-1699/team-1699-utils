/*
 * FIRST Team 1699
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 * An class implementing BetterController for a VictorSP.
 */
package org.usfirst.frc.team1699.bettercontrollers;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

public class BetterVictorSP extends VictorSP implements SpeedController, BetterController {

	
	// Initializer
	private boolean reversed = false;
	
	
	// Constructor
	public BetterVictorSP(int channel)
	{
		super(channel);
	}

	
	// Getters and Setters
	public void reverseOutput() {
		this.reversed = !reversed;
	}
	public boolean getreverseOutput() {
		return this.reversed;
	}
	public void setreverseOutput(boolean _reversed) {
		this.reversed = _reversed;
	}

	
	// Methods
	public void set(double speed) {
		if (reversed) {
			super.set(-1 * speed);
		} else if (reversed) {
			super.set(1 * speed);
		}
	}
}
