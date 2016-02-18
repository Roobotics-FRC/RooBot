package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;
import org.usfirst.frc.team4373.robot.subsystems.Intake;

/**
 * Created by tesla on 2/8/16.
 */
public class IntakeCommand extends CommandBase {

    private Intake intake;
    private RooJoystick joystick;

    public IntakeCommand() {
        super();
        this.joystick = oi.getJoystick();
        this.intake = Robot.intake;
        requires(this.intake);
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (joystick.getRawButton(RobotMap.INTAKE_BUTTON_FORWARD)) {
            intake.turnForward();
        } else if (joystick.getRawButton(RobotMap.INTAKE_BUTTON_BACKWARD)) {
            intake.turnBackward();
        } else {
            intake.stop();
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
