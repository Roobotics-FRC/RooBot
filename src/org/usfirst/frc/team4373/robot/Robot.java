package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;

/**
 * Created by tesla on 1/15/16.
 */
public class Robot extends IterativeRobot {
    private CANTalon talon;
    public static DriveTrain driveTrain = new DriveTrain(1, 1, 1);

    @Override
    public void robotInit() {
        this.talon = new CANTalon(0);
    }

    @Override
    public void teleopPeriodic() {
        this.talon.set(1.0D);
        OI.getOI().tick();
    }

    @Override
    public void autonomousPeriodic() {
        this.talon.set(-1.0D);
        OI.getOI().tick();
    }
}
