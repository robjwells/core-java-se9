/**
 * As Exercise 2.5 but now `scale` and `transform` are mutators.
 *
 * I’ve implemented them using a fluent style because why not?
 */
class Ex2_6 {
    public static void main(String[] args) {
        MutablePoint p = new MutablePoint(3, 4).translate(1, 3).scale(0.5);
        System.out.printf("(%.2f, %.2f)\n", p.getX(), p.getY());
    }
}

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
