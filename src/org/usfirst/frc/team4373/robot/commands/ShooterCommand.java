package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;
import org.usfirst.frc.team4373.robot.subsystems.Shooter;

/**
 * Created by tesla on 2/8/16.
 */
public class ShooterCommand extends CommandBase {

    private Shooter shooter;
    private RooJoystick joystick;

    public ShooterCommand() {
        super();
        joystick = this.oi.getJoystick();
        shooter = Robot.shooter;
        requires(Robot.driveTrain);
    }

    @Override
    protected void execute() {
        if (joystick.getRawButton(RobotMap.SHOOTER_BUTTON_FORWARD)) {
            shooter.shoot();
        } else {
            shooter.stop();
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
