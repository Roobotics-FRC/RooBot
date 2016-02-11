package org.usfirst.frc.team4373.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;

/**
 * Created by tesla on 1/15/16.
 */

public abstract class CommandBase extends Command {
    protected OI oi;


    @Override
    public void initialize() {
        this.oi = OI.getOI();
    }

}
