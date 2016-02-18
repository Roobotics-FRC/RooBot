package org.usfirst.frc.team4373.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.IntakeCommand;

/**
 * THIS IS ROODIAGNOSTIC
 */
public class RooDoubleSolenoid extends PIDSubsystem {

    private DoubleSolenoid solenoid;

    public RooDoubleSolenoid(double p, double i, double d) {
        super("DoubleSolenoid", p, i, d);
        this.solenoid = new DoubleSolenoid(RobotMap.SOLENOID_PORT_1, RobotMap.SOLENOID_PORT_2);
    }

    public void setForward() {
        this.solenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void setReverse() {
        this.solenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void stop() {
        this.solenoid.set(DoubleSolenoid.Value.kOff);
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
