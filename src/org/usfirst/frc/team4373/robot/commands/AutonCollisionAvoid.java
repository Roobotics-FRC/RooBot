package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;

/**
 * Created by tesla on 1/30/16.
 */
public class AutonCollisionAvoid extends CommandBase {
    private static final double SPEED = -0.35D;
    private int turnTicks = 0;
    private DriveTrain driveTrain;

    public AutonCollisionAvoid() {
        driveTrain = Robot.driveTrain;
    }

    @Override
    protected void execute() {
        if (oi.getDistance() < 260) {
            driveTrain.setBoth(-SPEED / 2);
            turnTicks = 60;
        } else if (turnTicks > 0) {
            --turnTicks;
            driveTrain.setRight(-SPEED / 2);
            driveTrain.setLeft(SPEED / 2);
        } else {
            driveTrain.setBoth(SPEED);
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
