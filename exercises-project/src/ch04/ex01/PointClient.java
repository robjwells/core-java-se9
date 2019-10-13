package ch04.ex01;

public class PointClient {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        LabeledPoint lp = new LabeledPoint(3, 4, "MyPoint");
        // Can access protected members as we're in the same package.
        System.out.println(p.x);
        System.out.println(lp.x);
    }
}
