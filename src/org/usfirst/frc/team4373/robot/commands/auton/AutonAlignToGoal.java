package org.usfirst.frc.team4373.robot.commands.auton;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;

/**
 * Created by tesla on 3/14/16.
 */
public class AutonAlignToGoal extends CommandBase {
    private NetworkTable visionTable;

    @Override
    protected void initialize() {
        SmartDashboard.putNumber("POWER", 0.2D);
        visionTable = NetworkTable.getTable(RobotMap.VISION_TABLE_NAME);
    }

    @Override
    protected void execute() {
        double power = SmartDashboard.getNumber("POWER");
        double horizontal = visionTable.getNumber("horizontal");
        if (Math.abs(horizontal) > 10) {
            if (horizontal < 0) {
                Robot.driveTrain.setLeft(power);
                Robot.driveTrain.setRight(-power);
            } else if (horizontal > 0) {
                Robot.driveTrain.setLeft(-power);
                Robot.driveTrain.setRight(power);
            }
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
