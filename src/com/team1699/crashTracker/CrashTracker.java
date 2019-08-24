package com.team1699.crashTracker;

import edu.wpi.first.wpilibj.DriverStation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CrashTracker {

    private static CrashTracker instance;

    public static CrashTracker getInstance(){
        if(instance == null){
            instance = new CrashTracker();
        }
        return instance;
    }

    protected static final UUID uuid = UUID.randomUUID();
    private final String filePath;
    private final SimpleDateFormat format;

    private CrashTracker(){
        format = new SimpleDateFormat("MM-dd-yyyy HH-mm-ss");
        init("/home/lvuser/");
        filePath = "/home/lvuser/" + format.format(new Date()) + " " + DriverStation.getInstance().getMatchType().toString() + " " + DriverStation.getInstance().getMatchNumber() + ".txt";
    }

    //Use only for writing test cases
    protected CrashTracker(final String filePath){
        format = new SimpleDateFormat("MM-dd-yyyy HH mm ss");
        init(filePath);
        this.filePath = filePath + format.format(new Date()) + ".txt";
    }

    private void init(final String directory){
        try {
            File[] files = new File(directory).listFiles();
            File oldestFile;
            if(new File(directory).list().length >= 4){
                oldestFile = files[0];
                for(File f : files){
                    if(f.lastModified() < oldestFile.lastModified()){
                        oldestFile = f;
                    }
                }
            }else{
                return;
            }
            oldestFile.delete();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void logRobotStartup(){
        log("Robot Started Up");
    }

    public void logRobotInit(){
        log("Robot Init");
    }

    public void logTeleOpInit(){
        log("Teleop Init");
    }

    public void logAutoInit(){
        log("Auto Init");
    }

    public void logDisabledInit(){
        log("Disabled Init");
    }

    public void logTestInit(){
        log("Test Init");
    }

    public void logThrowableCrash(Throwable crash){
        log("Crash", crash);
    }

    private void log(String message){
        log(message, null);
    }

    private void log(String message, Throwable exception){
        try(PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))){
            writer.printf("%s, %s, %s", UUID.randomUUID(), format.format(new Date()), message);

            if(exception != null){
                writer.print(": -- %s");
                exception.printStackTrace(writer);
            }

            writer.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
