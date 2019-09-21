package ch03.ex01;

import java.util.Arrays;

public interface Measurable {
    double getMeasure();

    static double average(Measurable[] objects) {
        if (objects.length == 0) {
            return 0;
        }
        return Arrays.stream(objects).mapToDouble(Measurable::getMeasure).sum() / objects.length;
    }
}
