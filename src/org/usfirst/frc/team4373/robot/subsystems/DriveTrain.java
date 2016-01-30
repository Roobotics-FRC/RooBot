package org.usfirst.frc.team4373.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.DriveWithJoystick;

/**
 * Created by tesla on 1/15/16.
 */
public class DriveTrain extends PIDSubsystem {
    private CANTalon left1, left2, right1, right2;

    public DriveTrain(double p, double i, double d) {
        super(p, i, d);
        this.left1 = new CANTalon(RobotMap.LEFT_DRIVE_MOTOR_1);
        this.left2 = new CANTalon(RobotMap.LEFT_DRIVE_MOTOR_2);
        this.right1 = new CANTalon(RobotMap.RIGHT_DRIVE_MOTOR_1);
        this.right2 = new CANTalon(RobotMap.RIGHT_DRIVE_MOTOR_2);
    }

    public void setLeft(double power) {
        this.left1.set(power);
        this.left2.set(-power);
    }

    public void setRight(double power) {
        this.right1.set(power);
        this.right2.set(power);
    }

    public void setBoth(double power) {
        setLeft(power);
        setRight(power);
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
        setDefaultCommand(new DriveWithJoystick());
    }
}
