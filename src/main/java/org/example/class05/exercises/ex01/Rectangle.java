package org.example.class05.exercises.ex01;

public class Rectangle extends Figure{
    private double width,length;

    public Rectangle(double x, double y, double width, double length) {
        super(x, y);
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width * length;
    }
}
