package ch04.ex01;

public class LabeledPoint extends Point {
    protected final String label;

    public LabeledPoint(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
