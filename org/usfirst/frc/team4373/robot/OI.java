package org.usfirst.frc.team4373.robot;

import org.usfirst.frc.team4373.input.RooJoystick;
import org.usfirst.frc.team4373.input.filter.BobFilter;

/**
 * Created by tesla on 11/1/15.
 */
public class OI {
    private static OI oi = null;
    public static OI getOI() {
        if (oi == null) {
            oi = new OI();
        }
        return oi;
    }

    private RooJoystick joystick;

    public OI() {
        joystick = new RooJoystick(RobotMap.JOYSTICK_PORT, new BobFilter());
    }
}
