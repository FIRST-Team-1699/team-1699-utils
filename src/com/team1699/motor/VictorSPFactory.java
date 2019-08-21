package com.team1699.motor;

import edu.wpi.first.wpilibj.VictorSP;

public class VictorSPFactory {

    public VictorSP victorSPFactory(final int id){
        VictorSP victorSP = new VictorSP(id);
        //TODO Add needed initialization
        return victorSP;
    }
}
