package org.usfirst.frc.team4373.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;

/**
 * Created by tesla on 1/30/16.
 */
public class TestAuton extends CommandBase {
    private DriveTrain driveTrain;
    private RooJoystick joystick;
    private int ticks = 300;

    public TestAuton() {
        super();
        driveTrain = Robot.driveTrain;
        joystick = oi.getJoystick();
        requires(this.driveTrain);
    }

    @Override
    protected void execute() {
        if (!isFinished()) {
            SmartDashboard.putNumber("PID Output", this.driveTrain.getPidOutput());
            driveTrain.setBoth(0.5D);
            --ticks;
        }
    }

    @Override
    protected boolean isFinished() {
        return ticks <= 0;
    }

    @Override
    protected void end() {
        ticks = 300;
    }

    @Override
    protected void interrupted() {

    }
}
