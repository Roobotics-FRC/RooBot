package org.usfirst.frc.team4373.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team4373.robot.dashboard.RooDashboard;

/**
 * Created by tesla on 1/15/16.
 */
public class DriveTrain extends PIDSubsystem {
    private CANTalon left1, left2, right1, right2;
    private double pidOutput = 0;

    public DriveTrain(double p, double i, double d) {
        super("DriveTrain", p, i, d);
        getPIDController().setContinuous(false);
        this.left1 = new CANTalon(RobotMap.LEFT_DRIVE_MOTOR_1);
        this.left2 = new CANTalon(RobotMap.LEFT_DRIVE_MOTOR_2);
        this.right1 = new CANTalon(RobotMap.RIGHT_DRIVE_MOTOR_1);
        this.right2 = new CANTalon(RobotMap.RIGHT_DRIVE_MOTOR_2);
        OI.getOI().resetGyro();
        getPIDController().setContinuous(false);
        getPIDController().setInputRange(-180, 180);
        getPIDController().setOutputRange(-1.0, 1.0);
    }

    public void setLeft(double power) {
        this.left1.set(-power);
        this.left2.set(-power);
    }

    public void setRight(double power) {
        this.right1.set(power);
        this.right2.set(power);
    }

    public void setBoth(double power) {
        power = -power;
        setLeft(power);
        setRight(power);
    }

    @Override
    protected double returnPIDInput() {
        double angle = OI.getOI().getAngle();
        double sign = angle / Math.abs(angle);
        double input = (Math.abs(angle) % 180) * sign;
        if (getPIDController().isEnabled()) {
            SmartDashboard.putNumber("PID Input", input);
        }
        return input;
    }

    @Override
    protected void usePIDOutput(double output) {
        if (getPIDController().isEnabled()) {
            SmartDashboard.putNumber("PID Output", output);
            SmartDashboard.putString("P, I, D", String.format("%f %f %f", getPIDController().getP(), getPIDController().getI(), getPIDController().getD()));
        }
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }

    public double getPidOutput() {
        return pidOutput;
    }

    @Override
    public void disable() {
        super.disable();
        SmartDashboard.putNumber("Enabled", 0);
    }

    @Override
    public void enable() {
        super.enable();
        SmartDashboard.putNumber("Enabled", 1);
    }
}
