package org.usfirst.frc.team4373.robot.input.sensor;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * Created by tesla on 1/15/16.
 */
public class SonicRangeFinder extends Ultrasonic {

    public SonicRangeFinder(int pingChannel, int echoChannel, Unit units) {
        super(pingChannel, echoChannel, units);
    }

    public SonicRangeFinder(int pingChannel, int echoChannel) {
        super(pingChannel, echoChannel);
    }

    public SonicRangeFinder(DigitalOutput pingChannel, DigitalInput echoChannel, Unit units) {
        super(pingChannel, echoChannel, units);
    }

    public SonicRangeFinder(DigitalOutput pingChannel, DigitalInput echoChannel) {
        super(pingChannel, echoChannel);
    }
}
