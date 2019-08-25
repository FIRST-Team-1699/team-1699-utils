package com.team1699.drive;

import edu.wpi.first.wpilibj.DriverStation;

public class DriveSignal {

    //A class that will represent the signal that will be send to the drive train
    private final double mPortMotor;
    private final double mStarMotor;
    private final boolean mBrakeMode;

    public DriveSignal(final double portMotor, final double starMotor){
        this(portMotor, starMotor, false);
    }

    public DriveSignal(final double portMotor, final double starMotor, final boolean brakeMode){
        this.mPortMotor = portMotor;
        this.mStarMotor = starMotor;
        this.mBrakeMode = brakeMode;
    }

    public static DriveSignal fromControls(double throttle, double turn){
        return new DriveSignal(throttle - turn, throttle + turn);
    }

    public double getPortMotor() {
        return mPortMotor;
    }

    public double getStar() {
        return mStarMotor;
    }

    public boolean getBrakeMode() {
        return mBrakeMode;
    }

    @Override
    public String toString() {
        return "Port: " + mPortMotor + ", Star: " + mStarMotor + (mBrakeMode ? ", BRAKE" : "");
    }
}
