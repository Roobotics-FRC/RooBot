package org.usfirst.frc.team4373.robot;

/**
 * Created by tesla on 11/1/15.
 */

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

    private Compressor piston1 = new Compressor(3);

    @Override
    public void robotInit() {

    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void teleopPeriodic() {

    }

    @Override
    public void testPeriodic() {

    }

    @Override
    public void disabledPeriodic() {
        this.piston1.start(); // Keep starting the compressor
    }
}
