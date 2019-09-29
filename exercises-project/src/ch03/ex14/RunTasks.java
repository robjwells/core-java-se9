package ch03.ex14;

import java.util.Arrays;

public class RunTasks {
    static Runnable runnableOfTasks(Runnable... tasks) {
        return () -> Arrays.stream(tasks).forEach(Runnable::run);
    }

    public static void main(String[] args) {
        runnableOfTasks(
                () -> System.out.println("First"),
                () -> System.out.println("Second"),
                () -> System.out.println("Third")
        ).run();
    }
}
