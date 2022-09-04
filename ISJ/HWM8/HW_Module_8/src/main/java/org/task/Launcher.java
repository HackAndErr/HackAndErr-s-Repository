package org.task;

import org.task.shapes.Triangle;

public class Launcher {
    public static void main(String[] args) {
        Triangle tr = new Triangle(5,4,3);
        System.out.println(tr.getArea());

        ShapePrinter sp = new ShapePrinter();
        sp.printShapeName(tr);
    }
}
