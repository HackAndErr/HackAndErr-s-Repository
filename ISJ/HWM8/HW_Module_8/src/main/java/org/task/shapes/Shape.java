package org.task.shapes;

public abstract class Shape {
    private String name;

    protected Shape(String name){
        this.name = name;
    }

    protected void setName(String name){
        this.name = name;
    }
    public abstract double getPerimeter();
    public abstract double getArea();

    @Override
    public String toString(){
        return name;
    }

}
