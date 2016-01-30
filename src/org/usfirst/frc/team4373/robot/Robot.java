package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;

/**
 * Created by tesla on 1/15/16.
 */
public class Robot extends IterativeRobot {
    public static DriveTrain driveTrain = new DriveTrain(1, 1, 1);


    @Override
    public void robotInit() {
        SmartDashboard.putString("egrjoi", "fewioj");
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        OI.getOI().tick();
    }

    @Override
    public void autonomousPeriodic() {
        OI.getOI().tick();
    }
}
