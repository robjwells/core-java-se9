package ch04.ex01;

import java.util.Objects;

public class LabeledPoint extends Point {
    private final String label;

    public LabeledPoint(double x, double y, String label) {
        super(x, y);
        if (label == null) {
            throw new IllegalArgumentException("Label cannot be null.");
        }
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return String.format("(%s: %s, %s)", label, x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LabeledPoint that = (LabeledPoint) o;
        return label.equals(that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label);
    }
}
