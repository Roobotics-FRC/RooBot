package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.commands.auton.AutonLurchForwards;
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
        SmartDashboard.putBoolean("Disable Auton", true);
        SmartDashboard.putBoolean("Forklift Down", false);
    }

    public static DriveTrain driveTrain = new DriveTrain();
    public static Intake intake = new Intake(0, 1, 1);
    public static Shooter shooter = new Shooter(0, 1, 1);
    private CommandBase autonCommand = null;

    @Override
    public void autonomousInit() {
        if (!SmartDashboard.getBoolean("Disable Auton")) {
            autonCommand = new AutonLurchForwards();
            autonCommand.start();
        }
    }

    @Override
    public void teleopInit() {
        if (autonCommand != null && autonCommand.isRunning()) {
            autonCommand.cancel();
        }
    }

    @Override
    public void teleopPeriodic() {
        if (autonCommand != null) {
            if (autonCommand.isRunning()) {
                autonCommand.cancel();
                autonCommand = null;
            }
        }
        Scheduler.getInstance().run();
        OI.getOI().tick();
    }

    @Override
    public void autonomousPeriodic() {
        if (!SmartDashboard.getBoolean("Disable Auton")) {
            if (autonCommand == null) {
                autonCommand = new AutonLurchForwards();
                autonCommand.start();
            }
            Scheduler.getInstance().run();
            OI.getOI().tick();
        }
    }
}
