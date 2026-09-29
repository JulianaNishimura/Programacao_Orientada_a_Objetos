package org.example.class05.exercises.ex01;

public abstract class Figure {
    private double x, y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}