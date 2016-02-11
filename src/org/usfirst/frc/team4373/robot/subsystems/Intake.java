package org.usfirst.frc.team4373.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team4373.robot.RobotMap;

/**
 * Created by tesla on 2/8/16.
 */
public class Intake extends PIDSubsystem {

    private final static double INTAKE_POWER = 1;
    private CANTalon motor;

    public Intake(String name, double p, double i, double d) {
        super(name, p, i, d);
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

    }
}
