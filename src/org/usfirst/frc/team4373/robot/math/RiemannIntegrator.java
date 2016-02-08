package org.usfirst.frc.team4373.robot.math;

import java.util.*;

/**
 * Created by tesla on 2/8/16.
 */
public class RiemannIntegrator {
    private RiemannMethod method;
    private Map<Double, Double> points;

    public RiemannIntegrator(RiemannMethod method) {
        points = new HashMap<>(20);
        this.method = method;
    }

    public RiemannIntegrator(RiemannMethod method, double points[][]) {
        this(method);
        addPoints(points);
    }

    public RiemannIntegrator(RiemannMethod method, List<Point> points) {
        this(method);
        addPoints(points);
    }

    public void addPoint(Point point) {
        points.put(point.getX(), point.getY());
    }

    public void addPoint(double x, double y) {
        points.put(x, y);
    }

    public void addPoints(double points[][]) {
        for (double point[] : points) {
            addPoint(point[0], point[1]);
        }
    }

    public void addPoints(List<Point> points) {
        for (Point point : points) {
            this.points.put(point.getX(), point.getY());
        }
    }

    public RiemannMethod getMethod() {
        return method;
    }

    public void setMethod(RiemannMethod method) {
        this.method = method;
    }

    public double integrate() {
        Set<Double> doubleSet = points.keySet();
        Double xVals[] = doubleSet.toArray(new Double[doubleSet.size()]);
        Arrays.sort(xVals);
        double total = 0;
        for (int i = 0; i < points.size() - 1; ++i) {
            switch (method) {
                case LEFT:
                    total += (xVals[i + 1] - xVals[i]) * (points.get(xVals[i]));
                    break;
                case RIGHT:
                    total += (xVals[i + 1] - xVals[i]) * (points.get(xVals[i + 1]));
                    break;
                case TRAPEZOIDAL:
                    total += (xVals[i + 1] - xVals[i]) * ((points.get(xVals[i + 1]) + points.get(xVals[i]))) / 2;
                    break;
                default:
                    throw new IllegalArgumentException("Midpoint integration not possible with discrete data sets");
            }
        }
        return total;
    }

    public enum RiemannMethod {
        LEFT,
        RIGHT,
        MIDPOINT,
        TRAPEZOIDAL;

        @Override
        public String toString() {
            switch (this) {
                case LEFT:
                    return "left";
                case RIGHT:
                    return "right";
                case MIDPOINT:
                    return "midpoint";
                case TRAPEZOIDAL:
                    return "trapezoidal";
                default:
                    return "invalid";
            }
        }
    }
}
