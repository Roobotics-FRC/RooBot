package org.usfirst.frc.team4373.robot.commands;


import edu.wpi.first.smartdashboard.gui.elements.Command;
import org.usfirst.frc.team4373.robot.OI;

import java.util.Random;

/**
 * Created by tesla on 1/15/16.
 */

public abstract class CommandBase extends Command {
    protected Random random;
    protected OI oi;


    public CommandBase() {
        super();
        this.oi = OI.getOI();
        random = new Random(System.currentTimeMillis());
    }


}
