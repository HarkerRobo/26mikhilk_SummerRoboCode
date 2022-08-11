package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Wrist extends SubsystemBase {

    private static Wrist instance;

//declare motors
    private HSTalon master;
    private VictorSPX follow;

    //declare motor IDs
    private static final int MASTER_ID = 0;
    private static final int FOLLOW_ID = 0;

    //declare inverts
    private static final boolean MASTER_INVERT = false;
    private static final boolean FOLLOW_INVERT = false;

    public Wrist() {
        master = new HSTalon(MASTER_ID);
        follow = new VictorSPX(FOLLOW_ID);
        follow.follow(master);
        master.setInverted(MASTER_INVERT);
        follow.setInverted(FOLLOW_INVERT);
    }

    public void setOutput(double power) {
        master.set(ControlMode.PercentOutput, power);
    }

    public static Wrist getInstance() {
        if (instance == null) {
            instance = new Wrist();
        }
        return instance;
    }

}
