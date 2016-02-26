package org.usfirst.frc.team4373.robot.commands.auton;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.commands.CommandBase;

/**
 * Created by tesla on 2/26/16.
 */
public class AutonVisionShoot extends PIDCommand {
    private boolean horizontalAlign;

    public AutonVisionShoot() {
        super("AutonVisionShoot", 1, 1, 0);
        requires(Robot.driveTrain);
        getPIDController().setContinuous(false);
        getPIDController().setOutputRange(-1, 1);
    }

    @Override
    protected void initialize() {
        horizontalAlign = false;
    }

    @Override
    protected void execute() {
        getPIDController().enable();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        getPIDController().disable();
    }

    @Override
    protected void interrupted() {

    }

    @Override
    protected double returnPIDInput() {
        double displacement;
        if (!horizontalAlign) {
            displacement  = NetworkTable.getTable("rooVision").getNumber("horizontal");
        } else {
            displacement = NetworkTable.getTable("rooVision").getNumber("vertical");
        }
        return displacement;
    }

    @Override
    protected void usePIDOutput(double output) {
        if (!horizontalAlign) {
            Robot.driveTrain.setLeft(output);
            Robot.driveTrain.setRight(-output);
        } else {
            Robot.driveTrain.setBoth(output);
        }
    }
}
