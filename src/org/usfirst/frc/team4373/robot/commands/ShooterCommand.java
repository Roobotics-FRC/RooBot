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

    private Shooter shooter;
    private RooJoystick joystick;
    private double minShootSpeed;

    public ShooterCommand() {
        super();
        joystick = this.oi.getJoystick();
        shooter = Robot.shooter;
        requires(this.shooter);
    }

    @Override
    public void initialize() {
        setShootSpeed();
        RooDashboard.getDashboard().putNumber("GOOD THINGS ARE HAPPENING", 1);
    }

    protected boolean canShoot() {
        return shooter.getSpeed() >= minShootSpeed;
    }

    protected void setShootSpeed() {
        minShootSpeed = oi.getJoystick().getRawAxis(RobotMap.SHOOTER_SPEED_AXIS);
    }

    @Override
    protected void execute() {
        setShootSpeed();
        SmartDashboard.putNumber("Shooter Speed", shooter.getSpeed());
        if (joystick.getRawButton(RobotMap.SHOOTER_BUTTON_START)) {
            shooter.start();
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
