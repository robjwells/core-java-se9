package ch02.ex05;

/**
 * 5. Implement an immutable class Point that describes a point in the plane.
 *
 * Provide a constructor to set it to a specific point, a no-arg constructor to
 * set it to the origin, and methods getX, getY, translate, and scale
 *
 * The translate method moves the point by a given amount in x- and y-direction.
 * The scale method scales both coordinates by a given factor. Implement these
 * methods so that they return new points with the results.
 *
 * For example, Point p = new Point(3, 4).translate(1, 3).scale(0.5); should set
 * p to a point with coordinates (2, 3.5).
 */
class Main {
    public static void main(String[] args) {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.printf("(%.2f, %.2f)\n", p.getX(), p.getY());
    }
}

