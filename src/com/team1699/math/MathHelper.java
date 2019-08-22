package com.team1699.math;

public class MathHelper {

    //This class contains many helper functions for commonly used mathematical operations

    public static final double kEpsilon = 1e-9; //This is a standard values used when checking whether the system is within tolerance

    //Used to prevent class from being instantiated
    private MathHelper(){}

    public static boolean epsilonEquals(double a, double b){
        return epsilonEquals(a, b, kEpsilon);
    }

    //This function returns true if
    public static boolean epsilonEquals(double a, double b, double epsilon){
        return (a - epsilon <= b) && (a + epsilon >= b);
    }
}
