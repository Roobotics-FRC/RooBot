package org.usfirst.frc.team4373.robot.commands.teleop;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;

/**
 * Created by tesla on 1/29/16.
 */
public class DriveWithJoystick extends CommandBase {
    private DriveTrain driveTrain;
    private RooJoystick driveJoystick;
    private RooJoystick operatorJoystick;

    public DriveWithJoystick() {
        super();
        driveTrain = Robot.driveTrain;
        driveJoystick = this.oi.getDriveJoystick();
        operatorJoystick = this.oi.getOperatorJoystick();
        requires(this.driveTrain);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        double right = -this.driveJoystick.getAxis(1) - (this.driveJoystick.getAxis(3) / 3);
        double left =  -this.driveJoystick.getAxis(1) + (this.driveJoystick.getAxis(3) / 3);
        if (right == 0 && left == 0) {
            right = this.operatorJoystick.getAxis(1) - (this.operatorJoystick.getAxis(0) / 3);
            left =  this.operatorJoystick.getAxis(1) + (this.operatorJoystick.getAxis(0) / 3);
            SmartDashboard.putNumber("Left", left);
            SmartDashboard.putNumber("Right", right);
            SmartDashboard.putBoolean("Good", true);
        }
        this.driveTrain.setRight(right);
        this.driveTrain.setLeft(left);
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
