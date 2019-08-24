package com.team1699.motion;

import com.team1699.constants.Constants;

public class PIDController {

    //Constants
    private static final double kMaxVoltage = 12.0;
    private static final double kMaxZeroingVoltage = 4.0;

    //Variables
    private double kP, kI, kD;
    private double mGoal;
    private SystemState mSystemState;
    private double offset = 0.0;
    private double lastError = 0.0;
    private double filteredGoal = 0.0;

    public PIDController(final double kP, final double kI, final double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        mSystemState = SystemState.DISABLED;
    }

    /**
     * This method is called periodically and used to control a motor or set of motors
     *
     * @param //TODO Comment
     * @param //TODO Comment
     * @param //TODO Comment
     * @return Returns the voltage needed to adjust the system to its desired state
     */
    public double update(double currentCount, boolean limit, boolean isEnabled) {
        double position = currentCount - offset;
        double maxVoltage = 0.0;

        switch (mSystemState){
            case DISABLED:
                //Do nothing
                break;
            case ZEROING:
                //Zero system
                maxVoltage = kMaxZeroingVoltage;
                break;
            case HOMING:
                //Attempt to maintain goal
                maxVoltage = kMaxVoltage;
                break;
            case ESTOP:
                //Stop the system to prevent damage
                break;
        }

        //TODO Add integral term
        final double error = filteredGoal - position;
        final double vel = (error - lastError) / Constants.kDt;
        lastError = error;
        double voltage = kP * error + kD * vel; //TODO Figure out if kD is the right constant

        if(voltage >= maxVoltage){
            return maxVoltage;
        }else if(voltage <= -maxVoltage){
            return -maxVoltage;
        }else{
            return voltage;
        }
    }

    public void setmSystemState(SystemState mSystemState) {
        this.mSystemState = mSystemState;
    }

    public SystemState getmSystemState(){
        return mSystemState;
    }

    public double getmGoal() {
        return mGoal;
    }

    public void setmGoal(double goal){
        mGoal = goal;
    }

    public double getkP() {
        return kP;
    }

    public void setkP(double kP) {
        this.kP = kP;
    }

    public double getkI() {
        return kI;
    }

    public void setkI(double kI) {
        this.kI = kI;
    }

    public double getkD() {
        return kD;
    }

    public void setkD(double kD) {
        this.kD = kD;
    }
}
