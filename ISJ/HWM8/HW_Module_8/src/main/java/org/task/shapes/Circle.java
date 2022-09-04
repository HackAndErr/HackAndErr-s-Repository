package org.task.shapes;

public class Circle extends Shape{
    private int radius;

    public Circle(int radius) {
        super("Circle");
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius,2);
    }
}
