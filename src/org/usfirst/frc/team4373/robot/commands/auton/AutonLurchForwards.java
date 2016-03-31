package org.usfirst.frc.team4373.robot.commands.auton;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.dashboard.RooDashboard;

/**
 * Created by tesla on 3/19/16.
 */
public class AutonLurchForwards extends CommandBase {
    private static final int DURATION_MILLIS = 5000;
    private boolean lowered;
    private long startTime;
    private int durationMillis;

    @Override
    protected void initialize() {
        lowered = false;
        startTime = System.currentTimeMillis();
        durationMillis = DURATION_MILLIS;
    }

    @Override
    protected void execute() {
        SmartDashboard.putString("AutonTime",
                String.format("%d : %d : %d",
                        System.currentTimeMillis() - startTime,
                        startTime,
                        System.currentTimeMillis()));
        if ((System.currentTimeMillis() - startTime) < durationMillis) {
            if (!lowered) {
                if (RooDashboard.getBoolean("Forklift Down")) {
                    Robot.intake.raise();
                } else {
                    Robot.intake.lower();
                }
            } else {
                Robot.driveTrain.setBoth(1.0D);
            }
        } else {
            if (!lowered) {
                startTime = System.currentTimeMillis();
                lowered = true;
            } else {
                Robot.driveTrain.setBoth(0.0D);
                this.cancel();
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return (System.currentTimeMillis() - startTime) >= durationMillis;
    }

    @Override
    protected void end() {
        lowered = false;
        Robot.intake.lower();
    }

    @Override
    protected void interrupted() {
        lowered = false;
    }
}
