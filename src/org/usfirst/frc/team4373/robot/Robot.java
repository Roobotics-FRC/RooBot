package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4373.robot.subsystems.Intake;
import org.usfirst.frc.team4373.robot.subsystems.Shooter;

/**
 * Created by tesla on 1/15/16.
 */
public class Robot extends IterativeRobot {

    @Override
    public void robotInit() {
        OI.getOI().init();
    }

    public static DriveTrain driveTrain = new DriveTrain(1, 1, 0);
    public static Intake intake = new Intake(0, 1, 1);
    public static Shooter shooter = new Shooter(0, 1, 1);

    @Override
    public void autonomousInit() {
    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {
//        Robot.shooter.start();
        Scheduler.getInstance().run();
        OI.getOI().tick();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        OI.getOI().tick();
    }
}
