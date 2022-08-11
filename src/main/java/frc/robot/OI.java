package frc.robot;

import frc.robot.commands.ToggleExtender;
import frc.robot.commands.ToggleFlower;
import frc.robot.commands.ToggleIntake;
import harkerrobolib.wrappers.XboxGamepad;

public class OI {

    private static OI instance;
    
    private XboxGamepad driver;

    private static final int driverId = 0;

    private OI() {
        driver = new XboxGamepad(driverId);
        driver.getButtonA().whenPressed(new ToggleFlower());
        driver.getButtonB().whenPressed(new ToggleExtender());
        driver.getButtonX().whenPressed(new ToggleIntake());
    }

    public XboxGamepad getDriver() {
        return driver;
    }

    public static OI getInstance() {
        if(instance == null) {
            instance = new OI();
        }
        return instance;
    }

}