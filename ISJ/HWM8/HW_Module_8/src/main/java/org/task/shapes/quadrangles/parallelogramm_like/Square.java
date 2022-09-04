package org.task.shapes.quadrangles.parallelogramm_like;

import org.task.shapes.quadrangles.Parallelogramm;

public class Square extends Parallelogramm {

    public Square(double side) {
        super(side, side, Math.PI/2);
        setName("Square");
    }
}
