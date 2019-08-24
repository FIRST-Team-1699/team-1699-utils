package com.team1699.loop;

//This class will hold routines that are updated periodically on the robot
public interface Loop {

    //Called when the loop is started
    void onStart(double timestamp);

    //Called periodically on each loop
    void onLoop(double timestamp);

    //Called when the loop is stopped
    void onStop(double timestamp);
}
