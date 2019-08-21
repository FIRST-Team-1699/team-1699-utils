package com.team1699.motion;

public class PIDController {

    private double kP, kI, kD;

    public PIDController(final double kP, final double kI, final double kD){
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    /**
     * This method is called periodically and used to control a motor or set of motors
     *
     * @param //TODO Comment
     * @param //TODO Comment
     * @param //TODO Comment
     * @return Returns the voltage needed to adjust the system to its desired state
     */
    public double update(double currentCount, boolean limit, boolean isEnabled){5
        return 0.0;
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
