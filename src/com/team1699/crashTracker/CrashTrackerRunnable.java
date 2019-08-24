package com.team1699.crashTracker;

public abstract class CrashTrackerRunnable implements Runnable {

    @Override
    public void run() {
        try{
            trackCrash();
        }catch (Throwable t){
            CrashTracker.getInstance().logThrowableCrash(t);
            throw t;
        }
    }

    public abstract void trackCrash();
}
