package org.usfirst.frc.team4373.robot;


import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team4373.robot.commands.ShooterCommand;
import org.usfirst.frc.team4373.robot.dashboard.RooDashboard;
import org.usfirst.frc.team4373.robot.input.filter.CubeFilter;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;
import org.usfirst.frc.team4373.robot.input.sensor.Accelerometer;

/**
 * Created by tesla on 1/15/16.
 */
public class OI {
    private static OI oi = null;

    private RooJoystick joystick;
    private ADXRS450_Gyro gyro;
    private AnalogInput ultrasonic;
    private Accelerometer accelerometer;
    private Button shoot;

    public OI() {
        gyro = new ADXRS450_Gyro();
        joystick = new RooJoystick(RobotMap.JOYSTICK_PORT, new CubeFilter());
        ultrasonic = new AnalogInput(0);
        accelerometer = new Accelerometer();
    }

    public void init() {
    }

    public static OI getOI() {
        if (oi == null) {
            oi = new OI();
        }
        return oi;
    }

    public Accelerometer getAccelerometer() {
        return accelerometer;
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
        return this.ultrasonic.getAverageValue();
    }

}
