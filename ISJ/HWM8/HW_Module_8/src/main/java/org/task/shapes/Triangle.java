package org.task.shapes;

public class Triangle extends Shape{
    private double a, b, c;

    public Triangle(double a, double b, double c){
        super("Triangle");
        this.a = a;
        this.b = b;
        this.c = c;
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

    @Override
    public double getPerimeter() {
        return a+b+c;
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter()/2;
        return Math.sqrt(halfPerimeter*(halfPerimeter-a)*(halfPerimeter-b)*(halfPerimeter-c));
    }
}
