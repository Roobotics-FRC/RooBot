package org.usfirst.frc.team4373.robot.commands.teleop;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;

/**
 * Created by tesla on 2/8/16.
 */
public class ShooterCommand extends CommandBase {
    private RooJoystick joystick;

    public ShooterCommand() {
        super();
        joystick = this.oi.getOperatorJoystick();
        requires(Robot.shooter);
    }

    @Override
    public void initialize() {
    }


    @Override
    protected void execute() {
        
        if (joystick.getRawButton(4)) {
            if (joystick.getRawButton(RobotMap.SHOOTER_BUTTON_REVERSE)) {
                Robot.shooter.startReverse();
            } else {
                Robot.shooter.start();
            }
        } else {
            Robot.shooter.stop();
        }
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
