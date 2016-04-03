package org.usfirst.frc.team4373.robot.commands.auton;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.commands.CommandBase;

/**
 * Created by tesla on 4/2/16.
 */
public class AutonShootGoal extends CommandBase {
    private static final int SPIN_SECONDS = 10;
    private static final int SHOOT_SECONDS = 3;
    private long start;
    private boolean finished;
    private boolean shooting;

    @Override
    protected void initialize() {
        Robot.driveTrain.setBoth(0);
        Robot.intake.lower();
        this.finished = false;
        this.shooting = false;
        this.start = System.currentTimeMillis();
    }

    @Override
    protected void execute() {
        if (!shooting && System.currentTimeMillis() <= (start + (SPIN_SECONDS * 1000))) {
            Robot.shooter.start();
        } else if (shooting && System.currentTimeMillis() <= (start + (SHOOT_SECONDS * 1000))) {
            Robot.intake.turnForward();
        } else if (!shooting) {
            shooting = true;
            start = System.currentTimeMillis();
        } else {
            finished = true;
        }

    }

    @Override
    protected boolean isFinished() {
        return finished;
    }

    @Override
    protected void end() {
        this.start = 0;
    }

    @Override
    protected void interrupted() {

    }
}
