package ch02.ex06;

/**
 *  A mutable point in the 2D plane.
 *
 * @author Rob Wells
 * @version 1.0
 */
class MutablePoint {
    private double x;
    private double y;

    /**
     * Constructs a <code>MutablePoint</code> at the origin (0, 0).
     */
    MutablePoint() {
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Constructs a <code>MutablePoint</code> at the given <em>x</em> and <em>y</em> coordinates.
     * @param x The <em>x</em> (horizontal) coordinate in the plane
     * @param y The <em>y</em> (vertical) coordinate in the plane
     */
    MutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the <em>x</em> coordinate of the <code>MutablePoint</code>.
     * @return the <em>x</em> coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the <em>y</em> coordinate of the <code>MutablePoint</code>.
     * @return the <em>y</em> coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Mutate this point by moving it by <code>xDelta</code> along the <em>x</em> axis
     * and <code>yDelta</code> along the <em>y</em> axis, so it now represents the
     * point at <code>(x + xDelta, y + yDelta)</code>. Returns <code>this</code> so
     * that it may be used in a fluent style.
     * @param xDelta the distance to move the point along the <em>x</em> axis
     * @param yDelta the distance to move the point along the <em>x</em> axis
     * @return <code>this</code> after its coordinates have been mutated in place
     */
    MutablePoint translate(double xDelta, double yDelta) {
        x += xDelta;
        y += yDelta;
        return this;
    }

    /**
     * Mutate this point by scaling its <code>x</code> and <code>y</code> values by
     * <code>factor</code> so that it now represents the point at
     * <code>(x * factor, y * factor)</code>. Returns <code>this</code> so that it
     * maybe be used in a fluent style.
     * @param factor the amount by which to scale the <code>x</code> and <code>y</code> coordinates
     * @return <code>this</code> after its coordinates have been mutated in place
     */
    MutablePoint scale(double factor) {
        x *= factor;
        y *= factor;
        return this;
    }
}
