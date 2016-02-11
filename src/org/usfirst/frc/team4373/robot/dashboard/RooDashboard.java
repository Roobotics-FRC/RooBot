package org.usfirst.frc.team4373.robot.dashboard;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.input.sensor.SonicRangeFinder;

/**
 * Created by tesla on 1/15/16.
 */
public class RooDashboard extends SmartDashboard {
    private static RooDashboard dashboard;
    public static RooDashboard getDashboard() {
        return dashboard;
    }
    public RooDashboard() {
        super();
        this.putNumber("U1 Distance", new SonicRangeFinder(0));
    }
}
