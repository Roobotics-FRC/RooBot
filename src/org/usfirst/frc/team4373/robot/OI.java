package org.usfirst.frc.team4373.robot;

/**
 * Created by tesla on 1/15/16.
 */
public class OI {
    private static OI oi = null;
    public static OI getOI() {
        if (oi == null) {
            oi = new OI();
        }
        return oi;
    }
}
