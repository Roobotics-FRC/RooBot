package org.usfirst.frc.team4373.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.Robot;

/**
 * Created by tesla on 2/20/16.
 */
public class AutonTurnToPosition extends CommandBase {

    public AutonTurnToPosition() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        Robot.driveTrain.setSetpoint(50.0);
    }

    @Override
    protected void execute() {
        Robot.driveTrain.setLeft(Robot.driveTrain.getPidOutput());
        Robot.driveTrain.setRight(-Robot.driveTrain.getPidOutput());
        Robot.driveTrain.enable();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.driveTrain.disable();
    }

    @Override
    protected void interrupted() {
        Robot.driveTrain.disable();
    }
}
