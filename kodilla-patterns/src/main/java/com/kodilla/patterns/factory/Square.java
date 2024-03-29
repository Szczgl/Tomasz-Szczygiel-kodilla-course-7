package com.kodilla.patterns.factory;

public final class Square implements Shape {

    public final String name;
    public final double width;

    public Square(final String name, final double width) {
        this.name = name;
        this.width = width;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return Math.pow(width,2.0);
    }

    @Override
    public double getCircumference() {
        return 4 * width;
    }
}
