package org.usfirst.frc.team4373.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.teleop.IntakeCommand;

/**
 * Created by tesla on 2/8/16.
 */
public class Intake extends PIDSubsystem {

    private double INTAKE_POWER = 1;
    private CANTalon motor;
    private DoubleSolenoid solenoid1;
    private DoubleSolenoid solenoid2;
    private Compressor compressor;

    public Intake(double p, double i, double d) {
        super("Intake", p, i, d);
        this.motor = new CANTalon(RobotMap.INTAKE_PORT);
        this.solenoid1 = new DoubleSolenoid(RobotMap.PCM_PORT, 2, 0);
        this.solenoid2 = new DoubleSolenoid(RobotMap.PCM_PORT, 3, 1);
        this.compressor = new Compressor(RobotMap.PCM_PORT);
        this.compressor.setClosedLoopControl(true);
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

    public void startCompressor() {
        this.compressor.start();
    }

    private void setBoth(DoubleSolenoid.Value value) {
        this.solenoid1.set(value);
        this.solenoid2.set(value);
    }

    public void raise() {
        setBoth(DoubleSolenoid.Value.kForward);
    }

    public void lower() {
        setBoth(DoubleSolenoid.Value.kReverse);
    }

    public void stopRaise() {
        setBoth(DoubleSolenoid.Value.kOff);
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
