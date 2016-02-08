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

    public Accelerometer() {
        super();
        xIntegrator = new RiemannIntegrator(RiemannIntegrator.RiemannMethod.TRAPEZOIDAL);
        yIntegrator = new RiemannIntegrator(RiemannIntegrator.RiemannMethod.TRAPEZOIDAL);
    }

    public void tick() {
        xIntegrator.addPoint(ticks, getX());
        yIntegrator.addPoint(ticks, getY());
        ++ticks;
    }

    public double getAverageXVelocity() {
        return xIntegrator.integrate();
    }

    public double getAverageYVelocity() {
        return yIntegrator.integrate();
    }
}
