package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;

/**
 * Created by tesla on 1/29/16.
 */
public class DriveWithJoystick extends CommandBase {
    private DriveTrain driveTrain;
    private RooJoystick joystick;

    public DriveWithJoystick() {
        super();
        driveTrain = Robot.driveTrain;
        joystick = this.oi.getJoystick();
        requires(this.driveTrain);
    }

    @Override
    protected void execute() {
        this.driveTrain.setRight(this.joystick.getTwist() + this.joystick.getY());
        this.driveTrain.setLeft(-this.joystick.getTwist() + this.joystick.getY());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
