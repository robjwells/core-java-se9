package ch02.ex06;

/**
 * As Exercise 2.5 but now `scale` and `transform` are mutators.
 *
 * I’ve implemented them using a fluent style because why not?
 */
class Main {
    public static void main(String[] args) {
        MutablePoint p = new MutablePoint(3, 4).translate(1, 3).scale(0.5);
        System.out.printf("(%.2f, %.2f)\n", p.getX(), p.getY());
    }
}

