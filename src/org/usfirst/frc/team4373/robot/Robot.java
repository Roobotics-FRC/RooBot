package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.commands.auton.AutonDriveForwards;
import org.usfirst.frc.team4373.robot.commands.auton.AutonShootGoal;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4373.robot.subsystems.Intake;
import org.usfirst.frc.team4373.robot.subsystems.Shooter;

/**
 * Created by tesla on 1/15/16.
 */
public class Robot extends IterativeRobot {

    private SendableChooser autonChooser;

    @Override
    public void robotInit() {
        OI.getOI().init();
        SmartDashboard.putBoolean("Disable Auton", true);
        SmartDashboard.putBoolean("Forklift Down", false);
        autonChooser = new SendableChooser();
        autonChooser.addDefault("Disabled", "disabled");
        autonChooser.addObject("DriveStraight", "driveStraight");
        autonChooser.addObject("ShootGoal", "shootGoal");
        SmartDashboard.putData("Autonomous Chooser", autonChooser);

    }

    public static DriveTrain driveTrain = new DriveTrain();
    public static Intake intake = new Intake(0, 1, 1);
    public static Shooter shooter = new Shooter(0, 1, 1);
    private CommandBase autonCommand = null;

    @Override
    public void autonomousInit() {
        if (autonCommand != null) {
            autonCommand.cancel();
        }
        String command = (String) autonChooser.getSelected();
        switch (command) {
            case "driveStraight":
                autonCommand = new AutonDriveForwards();
                break;
            case "shootGoal":
                autonCommand = new AutonShootGoal();
                break;
            default:
                autonCommand = null;
        }
        if (autonCommand != null) {
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
        if (autonCommand != null) {
            Scheduler.getInstance().run();
            OI.getOI().tick();
        }
    }
}
