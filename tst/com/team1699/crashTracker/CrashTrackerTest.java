package com.team1699.crashTracker;

import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class CrashTrackerTest {

    @Test
    public void testCrashTracker(){
        CrashTracker tracker = new CrashTracker("C:/FRCTestLogs/");
        tracker.logRobotStartup();
        tracker.logRobotInit();
        tracker.logDisabledInit();
        tracker.logThrowableCrash(new NullPointerException("Test NullPointerException"));
    }
}
