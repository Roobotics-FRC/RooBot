package org.usfirst.frc.team4373.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.ShooterCommand;

/**
 * Created by tesla on 2/8/16.
 */
public class Shooter extends PIDSubsystem {

    private CANTalon motor1;
    private CANTalon motor2;

    public Shooter(double p, double i, double d) {
        super("Shooter", p, i, d);
        this.motor1 = new CANTalon(RobotMap.SHOOTER_1);
        this.motor2 = new CANTalon(RobotMap.SHOOTER_2);
    }

    public void start() {
        setBoth(1);
    }

    public void stop() {
        setBoth(0);
    }

    private void setBoth(double power) {
        this.motor1.set(power);
        this.motor2.set(power);
    }

    public double getSpeed() {
        return this.motor1.getSpeed();
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
        setDefaultCommand(new ShooterCommand());
    }
}
