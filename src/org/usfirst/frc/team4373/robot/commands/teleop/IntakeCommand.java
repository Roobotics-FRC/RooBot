package org.usfirst.frc.team4373.robot.commands.teleop;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;

/**
 * Created by tesla on 2/8/16.
 */
public class IntakeCommand extends CommandBase {

    private RooJoystick joystick;

    public IntakeCommand() {
        super();
        this.joystick = oi.getDriveJoystick();
        requires(Robot.intake);

    }

    @Override
    protected void initialize() {
        Robot.intake.startCompressor();
    }

    @Override
    protected void execute() {
        if (joystick.getRawButton(RobotMap.INTAKE_BUTTON_FORWARD) || joystick.getRawButton(RobotMap.SHOOTER_BUTTON_SHOOT)) {
            Robot.intake.turnForward();
        } else if (joystick.getRawButton(RobotMap.INTAKE_BUTTON_BACKWARD)) {
            Robot.intake.turnBackward();
        } else {
            Robot.intake.stop();
        }
        if (joystick.getRawButton(RobotMap.SOLENOID_BUTTON_FORWARD)) {
            Robot.intake.raise();
        } else if (joystick.getRawButton(RobotMap.SOLENOID_BUTTON_REVERSE)) {
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
