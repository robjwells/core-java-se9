package ch04.ex12;

import ch04.ex11.InvokeHelloWorld;

import java.util.Arrays;

public class ReflectionPerformance {
    public static void main(String[] args) {
        int rounds = 100;

        long[] directResults = new long[rounds];
        for (int i = 0; i < rounds; i++) {
            long start = System.currentTimeMillis();
            System.out.println("Hello, World!");
            long duration = System.currentTimeMillis() - start;
            directResults[i] = duration;
        }

        long[] reflectionResults = new long[rounds];
        for (int i = 0; i < rounds; i++) {
            long start = System.currentTimeMillis();
            InvokeHelloWorld.printThroughReflection("Hello, world!");
            long duration = System.currentTimeMillis() - start;
            reflectionResults[i] = duration;
        }

        Arrays.stream(directResults)
                .average()
                .ifPresent(System.out::println);
        Arrays.stream(reflectionResults)
                .average()
                .ifPresent(System.out::println);

    }
}
