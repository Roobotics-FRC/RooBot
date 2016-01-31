package org.usfirst.frc.team4373.robot.input.hid;


import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team4373.robot.input.filter.Filter;

/**
 * Created by tesla on 11/1/15.
 */
public class RooJoystick extends Joystick {
    private static final double DEADZONE = 0.1D;
    private Filter filter = null;

    public RooJoystick(int port, Filter... filter) {
        super(port);
        this.filter = filter.length > 0 ? filter[0] : null;
    }

    public double filter(double val, Filter filter) {
        Object ret = filter == null ? this.filter == null ? val : this.filter.applyFilter(val) : filter.applyFilter(val);
        return (Double) ret;
    }

    protected double rooGetX(Filter filter) {
        return this.filter(this.getX(), filter);
    }

    protected double rooGetY(Filter filter) {
        if (Math.abs(this.getY()) < DEADZONE) {
            return 0.0D;
        }
        return this.filter(this.getY(), filter);
    }

    protected double rooGetZ(Filter filter) {
        return this.filter(this.getZ(), filter);
    }

    protected double rooGetTwist(Filter filter) {
        if (Math.abs(this.getTwist()) <= DEADZONE) {
            return 0.0D;
        }
        return this.filter(this.getTwist() - DEADZONE, filter);
    }

    protected double rooGetThrottle(Filter filter) {
        return this.filter(this.getThrottle(), filter);
    }

    @Override
    public double getAxis(Joystick.AxisType axis) {
        return this.getAxis(axis.value);
    }

    public double getAxis(Joystick.AxisType axis, Filter... filter) {
        return this.filter(this.getAxis(axis.value), filter.length > 0 ? filter[0] : null);
    }

    public double getAxis(int axis, Filter... filter) {
        return this.filter(this.getAxis(axis), filter.length > 0 ? filter[0] : null);
    }

    public double getAxis(int axis) {
        switch (axis) {
            case 0:
                return this.rooGetX(null);
            case 1:
                return this.rooGetY(null);
            case 2:
                return this.rooGetZ(null);
            case 3:
                return this.rooGetTwist(null);
            case 4:
                return this.rooGetThrottle(null);
            default:
                return 0.0;
        }
    }

    public double getAngle() {
        double x = this.getAxis(AxisType.kX);
        double y = this.getAxis(AxisType.kY);
        return Math.atan(y / x);
    }
}
