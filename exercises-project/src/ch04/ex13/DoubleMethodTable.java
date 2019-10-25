package ch04.ex13;

import java.lang.reflect.Method;
import java.util.function.Function;

public class DoubleMethodTable {
    public static void main(String[] args) {
        try {
            printDoubleTableUsingReflection(
                    Math.class.getMethod("sqrt", double.class),
                    4.0,
                    7.0,
                    1.0
            );
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        printDoubleTableUsingFunction(
                Math::sqrt,
                4.0,
                7.0,
                1.0
        );
    }

    public static void printDoubleTableUsingReflection(
            Method doubleMethod, double lowerBound, double upperBound, double stepSize
    ) {
        for (double x = lowerBound; x <= upperBound; x += stepSize) {
            try {
                System.out.print(doubleMethod.invoke(null, x));
                System.out.print(" ");
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
        System.out.println();
    }

    // Much prefer this as you let the type system handle things safely for you.
    public static void printDoubleTableUsingFunction(
            Function<Double, Double> doubleFunction, double lowerBound, double upperBound, double stepSize
    ) {
        for (double x = lowerBound; x <= upperBound; x += stepSize) {
            System.out.print(doubleFunction.apply(x));
            System.out.print(" ");
        }
        System.out.println();
    }
}
