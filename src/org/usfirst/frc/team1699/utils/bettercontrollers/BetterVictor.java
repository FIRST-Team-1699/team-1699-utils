/*
 * FIRST Team 1699
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 * An class implementing BetterController for a Victor.
 */
package org.usfirst.frc.team1699.utils.bettercontrollers;

import edu.wpi.first.wpilibj.Victor;

/**
 * A BetterControllers implementation of the Victor SpeedController.
 */
public class BetterVictor extends Victor implements BetterController {

	private boolean reversed = false;
	private boolean supressErrors = false;
	
	/**
	 * Makes a BetterVictor
	 * 
	 * @param channel the channel of the Victor
	 */
	public BetterVictor(int channel) {
		super(channel);
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	public void reverse() {
		this.reversed = !reversed;
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	public boolean getReversed() {
		return this.reversed;
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	public void setReversed(boolean reversed) {
		this.reversed = reversed;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void set(double speed) {
		speed = BetterControllerUtils.check(speed, supressErrors, super.toString());
		if (reversed == true) {
			super.set(-1 * speed);
		} else {
			super.set(1 * speed);
		} 
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void supressErrors() {
		supressErrors = true;
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	public String toString() {
		return "BetterVictor at channel: " + super.getChannel();
	}
}