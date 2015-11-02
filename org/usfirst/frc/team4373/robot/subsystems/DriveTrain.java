package org.usfirst.frc.team4373.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Created by tesla on 11/2/15.
 */
public class DriveTrain extends PIDSubsystem {
    public DriveTrain(double p, double i, double d) {
        super(DriveTrain.class.getSimpleName(), p, i, d);
    }

    @Override
    protected double returnPIDInput() {
        return 0;
    }

    @Override
    protected void usePIDOutput(double v) {

    }

    @Override
    protected void initDefaultCommand() {

    }
}
