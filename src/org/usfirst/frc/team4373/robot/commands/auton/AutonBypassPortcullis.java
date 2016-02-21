package org.usfirst.frc.team4373.robot.commands.auton;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.commands.CommandBase;

/**
 * Created by tesla on 2/21/16.
 */
public class AutonBypassPortcullis extends CommandBase {
    private static final double CROSSING_RAMP_RATE = 6.0;
    private static final int APPROACH_TICKS = 300;
    private static final int DISABLE_TICKS = 75;
    private static final int CROSS_TICKS = 350;

    private int ticks;
    private AutonState state;
    private double oldRampRate;
    public AutonBypassPortcullis() {
        super();
        requires(Robot.driveTrain);
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
        state = AutonState.APPROACHING_DEFENSE;
        ticks = 0;
    }

    @Override
    protected void execute() {
        ++ticks;
        switch (state) {
            case APPROACHING_DEFENSE:
                Robot.driveTrain.setBoth(0.5);
                if (ticks > APPROACH_TICKS) {
                    state = AutonState.DISABLING_DEFENSE;
                    ticks = 0;
                }
                break;
            case DISABLING_DEFENSE:
                Robot.intake.raise();
                if (ticks > DISABLE_TICKS) {
                    state = AutonState.CROSSING_DEFENSE;
                    oldRampRate = Robot.driveTrain.getRampRate();
                    ticks = 0;
                }
                break;
            case CROSSING_DEFENSE:
                Robot.driveTrain.setRampRate(CROSSING_RAMP_RATE);
                if (ticks > CROSS_TICKS) {
                    state = AutonState.CROSSED_DEFENSE;
                    Robot.driveTrain.setRampRate(oldRampRate);
                }
                break;
        }
    }

    @Override
    protected boolean isFinished() {
        return state == AutonState.CROSSED_DEFENSE;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
