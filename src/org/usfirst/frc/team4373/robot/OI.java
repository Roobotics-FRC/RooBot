package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import org.usfirst.frc.team4373.robot.dashboard.RooDashboard;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;

/**
 * Created by tesla on 1/15/16.
 */
public class OI {
    private static OI oi = null;

    private RooJoystick joystick;
    private ADXRS450_Gyro gyro;
    private AnalogInput ultrasonic;

    public OI() {
        gyro = new ADXRS450_Gyro();
        joystick = new RooJoystick(RobotMap.JOYSTICK_PORT);
        ultrasonic = new AnalogInput(0);
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

    public double getAngle() {
        return this.gyro.getAngle();
    }

    public ADXRS450_Gyro getGyro() {
        return gyro;
    }

    public void resetGyro() {
        /*gyro.reset();*/
    }

    public double getDistance() {
        return this.ultrasonic.getValue();
    }
}
