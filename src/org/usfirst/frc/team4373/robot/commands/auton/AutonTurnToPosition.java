package org.usfirst.frc.team4373.robot.commands.auton;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.commands.CommandBase;

/**
 * Created by tesla on 2/20/16.
 */
public class AutonTurnToPosition extends CommandBase {

    public AutonTurnToPosition() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        OI.getOI().resetGyro();
        Robot.driveTrain.setSetpoint(-0.5);
    }

    @Override
    protected void execute() {
        Robot.driveTrain.setLeft(Robot.driveTrain.getPIDController().get()/5);
        if (!Robot.driveTrain.getPIDController().isEnabled()) {
            Robot.driveTrain.enable();
        }
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
