package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * Created by tesla on 1/15/16.
 */
public class Robot extends IterativeRobot {
    private CANTalon talon;

    @Override
    public void robotInit() {
        this.talon = new CANTalon(0);
    }

    @Override
    public void teleopPeriodic() {
        this.talon.set(1.0D);
    }

    @Override
    public void autonomousPeriodic() {
        this.talon.set(-1.0D);
    }
}
