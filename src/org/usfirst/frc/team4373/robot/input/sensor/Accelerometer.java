package org.usfirst.frc.team4373.robot.input.sensor;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import org.usfirst.frc.team4373.robot.math.Point;
import org.usfirst.frc.team4373.robot.math.RiemannIntegrator;

import java.util.List;

/**
 * Created by tesla on 2/8/16.
 */
public class Accelerometer extends BuiltInAccelerometer {
    int ticks = 0;
    private List<Point> xDataTable;
    private List<Point> yDataTable;
    private RiemannIntegrator xIntegrator;
    private RiemannIntegrator yIntegrator;
    private RiemannIntegrator xVelocityIntegrator;
    private RiemannIntegrator yVelocityIntegrator;

    public Accelerometer() {
        super();
        xIntegrator = new RiemannIntegrator(RiemannIntegrator.RiemannMethod.TRAPEZOIDAL);
        yIntegrator = new RiemannIntegrator(RiemannIntegrator.RiemannMethod.TRAPEZOIDAL);
        xVelocityIntegrator = new RiemannIntegrator(RiemannIntegrator.RiemannMethod.TRAPEZOIDAL);
        yVelocityIntegrator = new RiemannIntegrator(RiemannIntegrator.RiemannMethod.TRAPEZOIDAL);
    }

    public void tick() {
        xIntegrator.addPoint(ticks, getX());
        yIntegrator.addPoint(ticks, getY());
        xVelocityIntegrator.addPoint(ticks, getCurrentXVelocity());
        yVelocityIntegrator.addPoint(ticks, getCurrentYVelocity());
        ++ticks;
    }

    public double getCurrentXVelocity() {
        return xIntegrator.integrate();
    }

    public double getCurrentYVelocity() {
        return yIntegrator.integrate();
    }

    public double getCurrentXPosition() {
        return xVelocityIntegrator.integrate();
    }

    public double getCurrentYPosition() {
        return yVelocityIntegrator.integrate();
    }
}
