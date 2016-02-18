package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team4373.robot.commands.AutonCollisionAvoid;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4373.robot.subsystems.Intake;
import org.usfirst.frc.team4373.robot.subsystems.RooDoubleSolenoid;
import org.usfirst.frc.team4373.robot.subsystems.Shooter;

/**
 * Created by tesla on 1/15/16.
 */
public class Robot extends IterativeRobot {
    private CANTalon talon;

    @Override
    public void robotInit() {
        this.talon = new CANTalon(0);
        OI.getOI().init();
    }

    public static DriveTrain driveTrain = new DriveTrain(1, 1, 0);
    public static Intake intake = new Intake(0, 1, 1);
    public static Shooter shooter = new Shooter(0, 1, 1);
    public static RooDoubleSolenoid solenoid = new RooDoubleSolenoid(1, 0, 0);
//    private AutonCollisionAvoid autonCommand =null;// new AutonCollisionAvoid();


    @Override
    public void autonomousInit() {
        /*autonCommand.start();*/
    }

    @Override
    public void teleopInit() {
        /*if (autonCommand != null) {
            autonCommand.cancel();
        }*/
    }

    @Override
    public void teleopPeriodic() {
        this.talon.set(1.0D);
        Scheduler.getInstance().run();
        OI.getOI().tick();
    }

    @Override
    public void autonomousPeriodic() {
        this.talon.set(-1.0D);
        Scheduler.getInstance().run();
        OI.getOI().tick();
    }
}
