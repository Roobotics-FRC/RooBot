package org.usfirst.frc.team4373.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.dashboard.RooDashboard;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;
import org.usfirst.frc.team4373.robot.subsystems.Shooter;

/**
 * Created by tesla on 2/8/16.
 */
public class ShooterCommand extends CommandBase {
    private RooJoystick joystick;

    public ShooterCommand() {
        super();
        joystick = this.oi.getJoystick();
        requires(Robot.shooter);
    }

    @Override
    public void initialize() {
    }


    @Override
    protected void execute() {
        if (joystick.getRawButton(RobotMap.SHOOTER_BUTTON_START)) {
            Robot.shooter.start();
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
