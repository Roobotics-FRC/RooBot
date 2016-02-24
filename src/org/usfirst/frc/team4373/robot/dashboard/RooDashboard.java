package org.usfirst.frc.team4373.robot.dashboard;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.Robot;

/**
 * Created by tesla on 1/15/16.
 */
public class RooDashboard extends SmartDashboard {
    private static RooDashboard dashboard = null;

    public RooDashboard() {
        super();
    }

    public static RooDashboard getDashboard() {
        if (dashboard == null) {
            dashboard = new RooDashboard();
        }
        return dashboard;
    }

    public static void tick() {
        putNumber("Joystick twist", OI.getOI().getDriveJoystick().getTwist());
        putNumber("Joystick magnitude", OI.getOI().getDriveJoystick().getMagnitude());
        putNumber("Gyro angle", OI.getOI().getAngle());
        putNumber("Ultrasonic", OI.getOI().getDistance());
        putNumber("Acceleration X", OI.getOI().getAccelerometer().getX());
        putNumber("Acceleration Y", OI.getOI().getAccelerometer().getY());
        putNumber("Velocity X", OI.getOI().getAccelerometer().getCurrentXVelocity());
        putNumber("Velocity Y", OI.getOI().getAccelerometer().getCurrentYVelocity());
        putNumber("Position X", OI.getOI().getAccelerometer().getCurrentXPosition());
        putNumber("Position Y", OI.getOI().getAccelerometer().getCurrentYPosition());
        putNumber("Speed", Robot.shooter.getRPM());
    }
}
