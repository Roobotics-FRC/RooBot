package org.usfirst.frc.team4373.robot.input.filter;

/**
 * Created by tesla on 11/1/15.
 */
public class SquareFilter implements Filter {
    @Override
    public Object applyFilter(Object input) {
        double magnitude = (Double)input;
        return magnitude < 0 ? -(magnitude * magnitude) : magnitude * magnitude;
    }
}
