package ch04.ex01.ProtectedTest;

import ch04.ex01.LabeledPoint;
import ch04.ex01.Point;

public class ProtectedTestClient {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        LabeledPoint lp = new LabeledPoint(1, 2, "MyPoint");
        // Below won't compile as we're not in the same package.
        // System.out.println(p.x);
        // System.out.println(lp.y);
    }
}
