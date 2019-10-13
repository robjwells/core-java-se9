package ch04.ex04;

import ch04.ex01.Point;

public abstract class Shape {
    protected Point point;

    public Shape(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("Point cannot be null.");
        }
        this.point = point;
    }

    public abstract Point getCenter();

    public void moveBy(double dx, double dy) {
        this.point = new Point(
                point.getX() + dx,
                point.getY() + dy
        );
    }
}
