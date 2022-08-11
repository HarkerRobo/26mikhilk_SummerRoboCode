package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Elevator;
import harkerrobolib.commands.IndefiniteCommand;

public class ElevatorManual extends IndefiniteCommand {
    
    public ElevatorManual() {
        addRequirements(Elevator.getInstance());
    }

    private double joystickY;

    public void execute() {
        joystickY = OI.getInstance().getDriver().getRightY();
        if (Math.abs(joystickY) < 0.1) {joystickY = 0.1;}
        Elevator.getInstance().setOutput(joystickY);
    }

    public void end(boolean interrupted) {
        Elevator.getInstance().setOutput(0);
    }

}
