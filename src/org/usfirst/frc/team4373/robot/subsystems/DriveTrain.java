package org.usfirst.frc.team4373.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Created by tesla on 1/15/16.
 */
public class DriveTrain extends PIDSubsystem {
    public DriveTrain(double p, double i, double d) {
        super(p, i, d);
    }

    @Override
    protected double returnPIDInput() {
        return 0;
    }

    @Override
    protected void usePIDOutput(double output) {

    }

    @Override
    protected void initDefaultCommand() {

    }
}
