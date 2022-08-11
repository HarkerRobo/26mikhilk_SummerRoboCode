package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.*;
import harkerrobolib.commands.IndefiniteCommand;

public class ArcadeDriveManual extends IndefiniteCommand{
    
    private double joystickX;
    private double joystickY;

    public ArcadeDriveManual() {
        addRequirements(DriveTrain.getInstance());
    }

    public void initialize() {
        
    }

    public void execute() {
        joystickX = OI.getInstance().getDriver().getLeftX();
        joystickY = OI.getInstance().getDriver().getLeftY();
        DriveTrain.getInstance().setArcadeDrive(joystickX, joystickY);
    }

    public void end(boolean interrupted) {
        DriveTrain.getInstance().setArcadeDrive(0, 0);
    }

}
