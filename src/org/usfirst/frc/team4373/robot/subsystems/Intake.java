package org.usfirst.frc.team4373.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.IntakeCommand;
import org.usfirst.frc.team4373.robot.dashboard.RooDashboard;

/**
 * Created by tesla on 2/8/16.
 */
public class Intake extends PIDSubsystem {

    private double INTAKE_POWER = 1;
    private CANTalon motor;

    public Intake(double p, double i, double d) {
        super("Intake", p, i, d);
        this.motor = new CANTalon(RobotMap.INTAKE_PORT);
    }

    public void turnForward() {
        motor.set(INTAKE_POWER);
    }

    public void turnBackward() {
        motor.set(-INTAKE_POWER);
    }

    public void stop() {
        motor.set(0);
    }

    @Override
    protected double returnPIDInput() {
        return 0;
    }

    @Override
    protected void usePIDOutput(double output) {

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeCommand());
    }
}
