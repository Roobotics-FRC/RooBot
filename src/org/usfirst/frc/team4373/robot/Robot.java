package org.usfirst.frc.team4373.robot;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
=======
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team4373.robot.commands.AutonCollisionAvoid;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4373.robot.subsystems.Intake;
>>>>>>> 5f3c8049708974c32f73fe93e1dfadeadd90774b

/**
 * Created by tesla on 1/15/16.
 */
public class Robot extends IterativeRobot {
<<<<<<< HEAD
    private CANTalon talon;

    @Override
    public void robotInit() {
        this.talon = new CANTalon(0);
=======
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
>>>>>>> 5f3c8049708974c32f73fe93e1dfadeadd90774b
    }

    @Override
    public void teleopPeriodic() {
<<<<<<< HEAD
        this.talon.set(1.0D);
=======
        Scheduler.getInstance().run();
        OI.getOI().tick();
>>>>>>> 5f3c8049708974c32f73fe93e1dfadeadd90774b
    }

    @Override
    public void autonomousPeriodic() {
<<<<<<< HEAD
        this.talon.set(-1.0D);
=======
        Scheduler.getInstance().run();
        OI.getOI().tick();
>>>>>>> 5f3c8049708974c32f73fe93e1dfadeadd90774b
    }
}
