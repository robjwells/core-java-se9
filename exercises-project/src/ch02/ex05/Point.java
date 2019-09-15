package ch02.ex05;

/**
 *  An immutable point in the 2D plane.
 *
 * @author Rob Wells
 * @version 1.0
 */
public class Point {
    private final double x;
    private final double y;

    /**
     * Constructs a <code>Point</code> at the origin (0, 0).
     */
    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Constructs a <code>Point</code> at the given <em>x</em> and <em>y</em> coordinates.
     * @param x The <em>x</em> (horizontal) coordinate in the plane
     * @param y The <em>y</em> (vertical) coordinate in the plane
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the <em>x</em> coordinate of the <code>Point</code>.
     * @return the <em>x</em> coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the <em>y</em> coordinate of the <code>Point</code>.
     * @return the <em>y</em> coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Constructs a new <code>Point</code> by translating this <code>Point</code> by <code>xDelta</code>
     * along the <em>x</em> axis and <code>yDelta</code> along the <em>y</em> axis, so the new
     * <code>Point</code> is at <code>(x + xDelta, y + yDelta)</code>.
     * @param xDelta the distance to move the point along the <em>x</em> axis
     * @param yDelta the distance to move the point along the <em>x</em> axis
     * @return a new <code>Point</code> at <code>(x + xDelta, y + yDelta)</code>
     */
    public Point translate(double xDelta, double yDelta) {
        return new Point(x + xDelta, y + yDelta);
    }

    /**
     * Constructs a new <code>Point</code> by scaling the <code>x</code> and <code>y</code> values
     * of this <code>Point</code> by <code>factor</code>, so that the new <code>Point</code> is at
     * <code>(x * factor, y * factor)</code>
     * @param factor the amount by which to scale the <code>x</code> and <code>y</code> coordinates
     * @return a new <code>Point</code> at <code>(x * factor, y * factor)</code>
     */
    public Point scale(double factor) {
        return new Point(x * factor, y * factor);
    }
}
