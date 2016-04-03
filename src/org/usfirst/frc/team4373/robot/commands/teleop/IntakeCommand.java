package org.usfirst.frc.team4373.robot.commands.teleop;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;

/**
 * Created by tesla on 2/8/16.
 */
public class IntakeCommand extends CommandBase {

    private RooJoystick driveJoystick;
    private RooJoystick operatorJoystick;


    public IntakeCommand() {
        super();
        this.driveJoystick = oi.getDriveJoystick();
        this.operatorJoystick = oi.getOperatorJoystick();
        requires(Robot.intake);

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (driveJoystick.getRawButton(RobotMap.INTAKE_BUTTON_FORWARD) || driveJoystick.getRawButton(RobotMap.SHOOTER_BUTTON_SHOOT)) {
            Robot.intake.turnForward();
        } else if (operatorJoystick.getRawButton(RobotMap.SHOOTER_BUTTON_SHOOT)) {
            Robot.intake.turnForward();
        } else if (driveJoystick.getRawButton(RobotMap.INTAKE_BUTTON_BACKWARD) || operatorJoystick.getRawButton(RobotMap.INTAKE_BUTTON_BACKWARD)) {
            Robot.intake.turnBackward();
        } else {
            Robot.intake.stop();
        }
        if (driveJoystick.getRawButton(RobotMap.SOLENOID_BUTTON_FORWARD)) {
            Robot.intake.raise();
        } else if (driveJoystick.getRawButton(RobotMap.SOLENOID_BUTTON_REVERSE)) {
            Robot.intake.lower();
        } else {
            Robot.intake.stopRaise();
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
