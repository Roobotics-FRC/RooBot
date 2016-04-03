package org.usfirst.frc.team4373.robot.commands.auton;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.commands.CommandBase;

/**
 * Created by tesla on 4/2/16.
 */

public class AutonDriveForwards extends CommandBase {
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.driveTrain.setBoth(1.0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.driveTrain.setBoth(0.0);
    }

    @Override
    protected void interrupted() {

    }
}
