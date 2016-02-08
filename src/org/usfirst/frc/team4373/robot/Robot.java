package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team4373.robot.commands.AutonCollisionAvoid;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4373.robot.subsystems.Intake;

/**
 * Created by tesla on 1/15/16.
 */
public class Robot extends IterativeRobot {
    public static DriveTrain driveTrain = new DriveTrain(1, 1, 0);
    public static Intake intake = new Intake(0, 1, 1);
    private AutonCollisionAvoid autonCommand = new AutonCollisionAvoid();

    @Override
    public void autonomousInit() {
        autonCommand.start();
    }

    @Override
    public void robotInit() {
    }

    @Override
    public void teleopInit() {
        if (autonCommand != null) {
            autonCommand.cancel();
        }
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        OI.getOI().tick();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        OI.getOI().tick();
    }
}
