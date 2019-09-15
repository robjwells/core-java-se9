package ch02.ex06;

class MutablePoint {
    private double x;
    private double y;

    MutablePoint() {
        this.x = 0.0;
        this.y = 0.0;
    }

    MutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    MutablePoint translate(double xDelta, double yDelta) {
        x += xDelta;
        y += yDelta;
        return this;
    }

    MutablePoint scale(double factor) {
        x *= factor;
        y *= factor;
        return this;
    }
}
