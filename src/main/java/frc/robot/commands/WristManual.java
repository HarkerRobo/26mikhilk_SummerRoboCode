package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Wrist;
import harkerrobolib.commands.IndefiniteCommand;

public class WristManual extends IndefiniteCommand {
    
    public WristManual() {
        addRequirements(Wrist.getInstance());
    }

    public void execute() {
        boolean up = OI.getInstance().getDriver().getUpDPadButton().get();
        boolean down = OI.getInstance().getDriver().getDownDPadButton().get();
        if (up) {
            Wrist.getInstance().setOutput(0.7);
        } else if (down) {
            Wrist.getInstance().setOutput(-0.7);
        } else {
            Wrist.getInstance().setOutput(0.2);
        }
    }

    public void end() {
        Wrist.getInstance().setOutput(0);
    }

}
