package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase {
    
    private static Intake instance;

    private static final int INTAKE_MOTOR_ID = 0;
    private static final int SOLENOID_FORWARD = 0;
    private static final int SOLENOID_REVERSE = 0;
    private static final boolean MOTOR_INVERT = false;

    private HSTalon intakeMotor;
    private DoubleSolenoid piston;

    public boolean intaking;

    private Intake() {
        intakeMotor = new HSTalon(INTAKE_MOTOR_ID);
        intakeMotor.setInverted(MOTOR_INVERT);
        piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, SOLENOID_FORWARD, SOLENOID_REVERSE);
    }

    public HSTalon getMotor() {
        return intakeMotor;
    }

    public void setOutput(double power) {
        if (power > 0.1) {
            intaking = true;
        } else {
            intaking = false;
        }
        intakeMotor.set(ControlMode.PercentOutput, power);
    }

    //boolean flag for WristRollerManual
    public boolean isIntaking() {
        return intaking;
    }

    public void toggleSolenoid() {
        switch(piston.get()) {
            case kForward:
                piston.set(Value.kReverse);
                break;
            case kReverse:
                piston.set(Value.kForward);
                break;
            case kOff:
                piston.set(Value.kReverse);
        }
    }

    public static Intake getInstance() {
        if (instance == null) {
            instance = new Intake();
        }
        return instance;
    }

}
