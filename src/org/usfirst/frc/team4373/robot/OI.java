package org.usfirst.frc.team4373.robot;

import org.usfirst.frc.team4373.robot.dashboard.RooDashboard;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;

/**
 * Created by tesla on 1/15/16.
 */
public class OI {
    private static OI oi = null;

    private RooJoystick joystick;
//    private ADXRS450_Gyro gyro;

    public OI() {
//        gyro = new ADXRS450_Gyro();
        joystick = new RooJoystick(RobotMap.JOYSTICK_PORT);
    }

    public static OI getOI() {
        if (oi == null) {
            oi = new OI();
        }
        return oi;
    }

    public RooJoystick getJoystick() {
        return this.joystick;
    }

    public void tick() {
        RooDashboard.tick();
    }

//    public double getAngle() {
//        return this.gyro.getAngle();
//    }
}
