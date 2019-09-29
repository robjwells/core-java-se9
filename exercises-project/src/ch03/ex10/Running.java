package ch03.ex10;

import java.util.Arrays;

public class Running {
    public static void runTogether(Runnable... tasks) {
        Arrays.stream(tasks)
                .map(Thread::new)
                .forEach(Thread::start);
    }

    public static void runInOrder(Runnable... tasks) {
        Arrays.stream(tasks)
                .forEach(Runnable::run);
    }

    public static void main(String[] args) {
        runTogether(
                () -> System.out.println("Threaded: a"),
                () -> System.out.println("Threaded: b"),
                () -> System.out.println("Threaded: c"),
                () -> System.out.println("Threaded: d")
        );

        System.out.println("----- Started all threads -----");

        runInOrder(
                () -> System.out.println("Sequential: a"),
                () -> System.out.println("Sequential: b"),
                () -> System.out.println("Sequential: c"),
                () -> System.out.println("Sequential: d")
        );
    }
}
