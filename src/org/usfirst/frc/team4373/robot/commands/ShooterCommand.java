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
    private int shootTicks;
    private boolean isShooting;
    private static final int MIN_SHOOT_SPEED = 1;

    public ShooterCommand() {
        super();
        requires(Robot.shooter);
        requires(Robot.intake);
        joystick = this.oi.getJoystick();
        shooter = Robot.shooter;
        isShooting = false;
        shootTicks = 0;
    }

    @Override
    protected void initialize() {

    }

    protected boolean canShoot() {
        return shooter.getSpeed() >= MIN_SHOOT_SPEED;
    }

    @Override
    protected void execute() {
        if (isShooting) shootTicks++;
        if (shootTicks >= 600) {
            Robot.shooter.stop();
            shootTicks = 0;
            isShooting = false;
        }
        if (joystick.getRawButton(RobotMap.SHOOTER_BUTTON_START)) {
            shooter.start();
            isShooting = true;
        }
        if (joystick.getRawButton(RobotMap.SHOOTER_BUTTON_SHOOT) && canShoot()) {
            Robot.intake.turnBackward();
        } else {
            Robot.intake.stop();
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
