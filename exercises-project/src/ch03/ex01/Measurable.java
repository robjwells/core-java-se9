package ch03.ex01;

import java.util.Arrays;
import java.util.Comparator;

public interface Measurable {
    double getMeasure();

    static double average(Measurable[] objects) {
        if (objects.length == 0) {
            return 0;
        }
        return Arrays.stream(objects).mapToDouble(Measurable::getMeasure).sum() / objects.length;
    }

    static Measurable largest(Measurable[] objects) {
        if (objects.length == 0) {
            return null; // Ick, but Ex 3.2 doesn't provide for Optional
        }
        return Arrays.stream(objects).max(Comparator.comparingDouble(Measurable::getMeasure)).get();
    }
}
