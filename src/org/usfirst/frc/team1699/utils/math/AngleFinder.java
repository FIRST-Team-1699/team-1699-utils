/**
 * Finds the angle the robot must rotate in order to meet the goal
 * 
 * @author BalanceJF
 * @author BluBurryMuffin
 * @author squirlemaster42
 */
 

public class AngleFinder {
    
    private double goalHeight; //Holds the height of the goal
    private Ultrasonic ultra; //Holds an instance of the ultrasonic class (used to find range from robot to goal)
    private int targetX; //Holds the target value x will be to be sure that the ball will reach the goal
    private int targetY; //Holds the target value y will be to be sure that the ball will reach the goal
    
    /**
     * Constructor
     * 
     * @param goalHeight
     * @param ultra
     * @param targetX
     */
    public AngleFinder(double goalHeight, Ultrasonic ultra, int targetX) {
        this.goalHeight = goalHeight;
        this.targetX = targetX;
        this.targetY = 0;
        this.ultra = ultra;
        ultra.setAutomaticMode(true);
    }

    /**
     * Constructor
     * 
     * @param goalHeight
     * @param ultra
     * @param targetX
     * @param targetY
     */
    public AngleFinder(double goalHeight, Ultrasonic ultra, int targetX, int targetY) {
        this.goalHeight = goalHeight;
        this.targetX = targetX;
        this.targetY = targetY;
        this.ultra = ultra;
        ultra.setAutomaticMode(true);
    }
    
    /**
     * Used to get goalHeight
     * 
     * @return goalHeight
     */
    public void getGoalHeight() {
        return goalHeight;
    }

    /**
     * Used to set goalHeight
     * 
     * @param goalHeight
     */
    public void setGoalHeight(int goalHeight) {
        this.goalHeight = goalheight;
    }
    
    /**
     * Used to get ultra
     * 
     * @return ultra
     */
    public void getUltra() {
        return ultra;
    }

    /**
     * Used to set ultra
     * 
     * @param ultra
     */    
    public void setUltra(Ultrasonic ultra) {
        this.ultra = ultra;
    }
   
    /**
     * Used to get targetX
     * 
     * @return targetX
     */    
    public void getTargetX() {
        return targetX;
    }

    /**
     * Used to set targetX
     * 
     * @param targetX
     */        
    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    /**
     * Used to get targetY
     * 
     * @return targetY
     */    
    public void getTargetY() {
        return targetY;
    }

    /**
     * Used to set targetY
     * 
     * @param targetY
     */  
    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }
    
    /**
     * Finds the angle to turn the robot to meet the center of the goal horizontally
     * 
     * @param centerX
     * @return angle
     */
    public double findHorizontalDiff(int centerX) {
        double distance = ultra.getRangeMM(); //Holds the distance between the robot and the goal
        int xDifference = targetX - centerX; //Holds the distance between centerX and targetX
        double angle = 0.0; //Holds the angle that the robot must rotate to meet centerX
        int isNegative = 1; //Holds whether or not xDifference should be negative
        if(xDifference < 0) {
            isNegative = -1;
        }
        xDifference = Math.abs(xDifference);
        return angle * isNegative;
    }
    
    /**
     * Finds the angle to turn the robot to meet the center of the goal vertically
     * 
     * @param centerY
     * @return angle
     */
    public double findVerticalDiff(int centerY) {
        double distance = ultra.getRangeMM(); //Holds the distance between the robot and the goal
        int yDifference = targetY - centerY; //Holds the distance between centerY and targetY
        double angle = 0.0; //Holds the angle that the robot must rotate to meet centerY
        int isNegative = 1; //Holds whether or not yDifference should be negative
        if(xDifference < 0) {
            isNegative = -1;
        }
        yDifference = Math.abs(xDifference);
        return angle * isNegative;
    }

}
