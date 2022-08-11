package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.*;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class HatchLatcher extends SubsystemBase {

    private static HatchLatcher instance;

    private static final int FLOWER_FORWARD = 0;
    private static final int FLOWER_BACKWARD = 0;
    private static final int EXTENDER_FORWARD = 0;
    private static final int EXTENDER_BACKWARD = 0;

    private DoubleSolenoid flower;
    private DoubleSolenoid extender;

    private HatchLatcher() {
        flower = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FLOWER_FORWARD, FLOWER_BACKWARD);
        extender = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, EXTENDER_FORWARD, EXTENDER_BACKWARD);
    }

    public void toggleFlower() {
        switch(flower.get()) {
            case kOff:
            case kForward:
                flower.set(Value.kReverse);
                break;
            case kReverse:
                flower.set(Value.kForward);
        }
    }

    public void toggleExtender() {
        switch(extender.get()) {
            case kOff:
            case kForward:
                extender.set(Value.kReverse);
                break;
            case kReverse:
                extender.set(Value.kForward);
        }
    }

    public static HatchLatcher getInstance() {
        if (instance == null) {
            instance = new HatchLatcher();
        }
        return instance;
    }
    
}
