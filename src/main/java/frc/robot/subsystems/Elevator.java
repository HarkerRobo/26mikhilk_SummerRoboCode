package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase {

    private static Elevator instance;

    //declare motors
    private HSTalon master;
    private HSTalon talonFollow;
    private VictorSPX victorFollow1;
    private VictorSPX victorFollow2;

    //declare motor IDs
    private static final int MASTER_ID = 0;
    private static final int TALON_FOLLOW_ID = 0;
    private static final int VICTOR_FOLLOW_1_ID = 0;
    private static final int VICTOR_FOLLOW_2_ID = 0;

    //declare inverts
    private static final boolean MASTER_INVERT = false;
    private static final boolean TALON_FOLLOW_INVERT = false;
    private static final boolean VICTOR_FOLLOW_1_INVERT = false;
    private static final boolean VICTOR_FOLLOW_2_INVERT = false;

    public Elevator() {
        master = new HSTalon(MASTER_ID);
        talonFollow = new HSTalon(TALON_FOLLOW_ID);
        victorFollow1 = new VictorSPX(VICTOR_FOLLOW_1_ID);
        victorFollow2 = new VictorSPX(VICTOR_FOLLOW_2_ID);
        talonFollow.follow(master);
        victorFollow1.follow(master);
        victorFollow2.follow(talonFollow);
        master.setInverted(MASTER_INVERT);
        talonFollow.setInverted(TALON_FOLLOW_INVERT);
        victorFollow1.setInverted(VICTOR_FOLLOW_1_INVERT);
        victorFollow2.setInverted(VICTOR_FOLLOW_2_INVERT);
    }

    public void setOutput(double power) {
        master.set(ControlMode.PercentOutput, power);
    }

    public static Elevator getInstance() {
        if (instance == null) {
            instance = new Elevator();
        }
        return instance;
    }
}
