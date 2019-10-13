package ch04.ex04;

import ch04.ex01.Point;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
        // `point` is the top-left corner of the rectangle
        return new Point(point.getX() + width / 2, point.getY() - height / 2);
    }
}
