/**
 * FIRST Team 1699
 * 
 * A layout for a better speed controller.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 * @version v0.1-pre
 */
package org.usfirst.frc.team1699.utils.bettercontrollers;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * The abstract class used to make better SpeedControllers.
 * 
 * @inheritDoc
 */
public interface BetterController extends SpeedController{
	
	/**
	 * Reverse the output of the motor
	 */
	public void reverse();
	
	/**
	 * See if the motor is reversed
	 * 
	 * @return true if the motor is reversed
	 */
	public boolean getReversed();
	
	/**
	 * Set the motor to be reversed or not.
	 * 
	 * @param reversed
	 */
	public void setReversed(boolean reversed);
	
	/**
	 * @inheritDoc
	 */
	public void set(double speed);	
	
	/**
	 * Turn off error output.
	 */
	public void supressErrors();
	
	/**
	 * Force any child classes to implement the toString method
	 *  
	 * @return a String that represents this object
	 * 
	 * @inheritDoc
	 */
	public String toString();
	
	/**
	 * @inheritDoc
	 */
	@Override
	default public void setInverted(boolean isInverted) {
		this.setReversed(isInverted);
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	default public boolean getInverted() {
		return this.getReversed();
	}
}
