package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team4373.robot.commands.auton.AutonTurnToPosition;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
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

    public static DriveTrain driveTrain = new DriveTrain();
//    public static Intake intake = new Intake(0, 1, 1);
//    public static Shooter shooter = new Shooter(0, 1, 1);
//    private CommandBase autonCommand = null;

    @Override
    public void autonomousInit() {
//        autonCommand = new AutonTurnToPosition();
//        autonCommand.start();
    }

    @Override
    public void teleopInit() {
//        if (autonCommand != null && autonCommand.isRunning()) {
//            autonCommand.cancel();
//        }
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
