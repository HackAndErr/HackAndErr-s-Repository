package org.task.shapes.quadrangles.parallelogramm_like;

import org.task.shapes.quadrangles.Parallelogramm;

public class Rectangle extends Parallelogramm {
    public Rectangle(double width, double height) {
        super(width, height, Math.PI/2);
        setName("Rectangle");
    }

}
