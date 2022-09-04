package org.task.shapes.quadrangles;

import org.task.shapes.Shape;

public class Trapezoid extends Shape {
    private double a;
    private double  b;
    private double  c;
    private double d;
    private double height;

    public Trapezoid(double a, double b, double c, double d, double height) {
        super("Trapezoid");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.height = height;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return a+b+c+d;
    }

    @Override
    public double getArea() {
        return (a+c)/2*height;
    }
}
