package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;
import org.usfirst.frc.team4373.robot.subsystems.Intake;
import org.usfirst.frc.team4373.robot.subsystems.RooDoubleSolenoid;

/**
 * Created by tesla on 2/8/16.
 */
public class IntakeCommand extends CommandBase {

    private Intake intake;
    private RooDoubleSolenoid solenoid;
    private RooJoystick joystick;

    public IntakeCommand() {
        super();
        this.joystick = oi.getJoystick();
        this.intake = Robot.intake;
        this.solenoid = Robot.solenoid;
        requires(this.solenoid);
        requires(this.intake);

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (joystick.getRawButton(RobotMap.INTAKE_BUTTON_FORWARD) || joystick.getRawButton(RobotMap.SHOOTER_BUTTON_SHOOT)) {
            intake.turnForward();
        } else if (joystick.getRawButton(RobotMap.INTAKE_BUTTON_BACKWARD)) {
            intake.turnBackward();
        } else {
            intake.stop();
        }

        if (joystick.getRawButton(RobotMap.SOLENOID_BUTTON_FORWARD)) {
            solenoid.setForward();
        } else if (joystick.getRawButton(RobotMap.SOLENOID_BUTTON_REVERSE)) {
            solenoid.setReverse();
        } else {
            solenoid.stop();
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
