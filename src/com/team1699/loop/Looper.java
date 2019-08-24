package com.team1699.loop;

import com.team1699.constants.Constants;
import com.team1699.crashTracker.CrashTrackerRunnable;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;
import java.util.List;

public class Looper implements ILooper{
    private final double kPeriod = Constants.kDt;

    private boolean mRunning;

    private final Notifier mNotifier;
    private final List<Loop> mLoops;
    private final Object mTaskRunningLock = new Object();
    private double mTimestamp = 0.0;
    private double mDT = 0.0;

    private final CrashTrackerRunnable runnable = new CrashTrackerRunnable() {
        @Override
        public void trackCrash() {
            synchronized (mTaskRunningLock){
                if(mRunning){
                    double now = Timer.getFPGATimestamp();

                    mLoops.forEach(l -> l.onLoop(now));

                    mDT = now - mTimestamp;
                    mTimestamp = now;
                }
            }
        }
    };

    public Looper(){
        mNotifier = new Notifier(runnable);
        mRunning = false;
        mLoops = new ArrayList<>();
    }

    @Override
    public void register(Loop loop) {
        synchronized (mTaskRunningLock){
            mLoops.add(loop);
        }
    }

    public synchronized void start() {
        if (!mRunning) {
            System.out.println("Starting loops");

            synchronized (mTaskRunningLock) {
                mTimestamp = Timer.getFPGATimestamp();
                for (Loop loop : mLoops) {
                    loop.onStart(mTimestamp);
                }
                mRunning = true;
            }

            mNotifier.startPeriodic(kPeriod);
        }
    }

    public synchronized void stop() {
        if (mRunning) {
            System.out.println("Stopping loops");
            mNotifier.stop();

            synchronized (mTaskRunningLock) {
                mRunning = false;
                mTimestamp = Timer.getFPGATimestamp();
                for (Loop loop : mLoops) {
                    System.out.println("Stopping " + loop);
                    loop.onStop(mTimestamp);
                }
            }
        }
    }

    public void outputToSmartDashboard() {
        SmartDashboard.putNumber("looper_dt", mDT);
    }
}
