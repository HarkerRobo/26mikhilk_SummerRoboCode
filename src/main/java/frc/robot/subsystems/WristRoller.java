package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class WristRoller extends SubsystemBase {

    private static WristRoller instance;

    private HSTalon master;

    private static final int MASTER_ID = 0;

    private static final boolean MASTER_INVERT = false;

    public WristRoller() {
        master = new HSTalon(MASTER_ID);
        master.setInverted(MASTER_INVERT);
    }

    public void setOutput(double power) {
        master.set(ControlMode.PercentOutput, power);
    }

    public static WristRoller getInstance() {
        if (instance == null) {
            instance = new WristRoller();
        }
        return instance;
    }
    
}
