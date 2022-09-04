package org.task.shapes.quadrangles;

import org.task.shapes.Shape;
import org.task.shapes.exceptions.AngleOverflowException;

public class Parallelogramm extends Shape {
    private double a, b, acuteAngle; //Гострий кут у радіанах

    public Parallelogramm(double a, double b, double acuteAngle){
        super("Parallelogramm");
        this.a = a;
        this.b = b;
        this.acuteAngle = acuteAngle;
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

    public double getAcuteAngle() {
        return acuteAngle;
    }

    public void setAcuteAngle(double acuteAngle) throws AngleOverflowException {
        if(acuteAngle > Math.PI/2) throw new AngleOverflowException("Acute angle can't be bigger than 90 degrees.");
        this.acuteAngle = acuteAngle;
    }

    //Обчислення тупого кута у радіанах
    public double getObtuseAngle() {
        return Math.PI - acuteAngle;
    }

    @Override
    public double getPerimeter() {
        return 2*(a+b);
    }

    @Override
    public double getArea() {
        return a*b*Math.sin(acuteAngle);
    }

    //Отримання довжини діагоналі, що лежить між сторонами a і b, і кутом angle
    public double getDiagonalLength(double angle){
        return Math.sqrt(Math.pow(a,2) + Math.pow(b,2) - 2*a*b*Math.cos(angle));
    }
}
