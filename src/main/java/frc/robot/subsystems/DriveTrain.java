package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class DriveTrain extends SubsystemBase {
 
    private static DriveTrain instance;
    
    //declare motor IDs
    private static final int LEFT_MASTER_ID = 0;
    private static final int RIGHT_MASTER_ID = 0;
    private static final int LEFT_FOLLOW_ID = 0;
    private static final int RIGHT_FOLLOW_ID = 0;

    //declare invert constants
    private static final boolean LEFT_INVERT = false;
    private static final boolean RIGHT_INVERT = false;
    private static final boolean LEFT_FOLLOW_INVERT = false;
    private static final boolean RIGHT_FOLLOW_INVERT = false;


    //declare motors
    private HSTalon leftMaster;
    private HSTalon rightMaster;
    private VictorSPX leftFollower;
    private VictorSPX rightFollower;

    //create drivetrain
    private DriveTrain() {
        leftMaster = new HSTalon(LEFT_MASTER_ID);
        rightMaster = new HSTalon(RIGHT_MASTER_ID);
        leftFollower = new VictorSPX(LEFT_FOLLOW_ID);
        rightFollower = new VictorSPX(RIGHT_FOLLOW_ID);
        //make followers follow masters
        leftFollower.follow(leftMaster);
        rightFollower.follow(rightMaster);
        //add motor invert
        leftMaster.setInverted(LEFT_INVERT);
        rightMaster.setInverted(RIGHT_INVERT);
        leftFollower.setInverted(LEFT_FOLLOW_INVERT);
        rightFollower.setInverted(RIGHT_FOLLOW_INVERT);
    }

    //create method to turn motors
    public void setArcadeDrive(double turn, double speed) {
        leftMaster.set(ControlMode.PercentOutput, speed+turn);
        rightMaster.set(ControlMode.PercentOutput, speed-turn);
    }

    public static DriveTrain getInstance() {
        if (instance == null) {
            instance = new DriveTrain();
        }
        return instance;
    }

}
