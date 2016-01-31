package org.usfirst.frc.team4373.robot.dashboard;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.OI;

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
        putNumber("Joystick twist", OI.getOI().getJoystick().getTwist());
        putNumber("Joystick magnitude", OI.getOI().getJoystick().getMagnitude());
        putNumber("Gyro angle", OI.getOI().getAngle());
        putNumber("Ultrasonic", OI.getOI().getDistance());
    }
}
