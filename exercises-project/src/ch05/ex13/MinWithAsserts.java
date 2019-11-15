package ch05.ex13;

import java.util.Arrays;

public class MinWithAsserts {
    public static int min(int[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Values array must not be empty.");
        }
        int smallest = Integer.MAX_VALUE;
        for (int v : values) {
            if (v < smallest) smallest = v;
        }
        // New variable introduced to silence a lint about `smallest` appearing
        // in the allMatch closure below.
        final int result = smallest;
        assert Arrays.stream(values).allMatch(n -> result <= n) : "Smallest is not the smallest element!";
        return result;
    }

    /**
     * Had trouble getting to the point where the time taken is measurable!
     * These results are with an int[] of 20,000,000 elements.
     * Asserts removed:  9ms average
     * Asserts disabled: 9ms average
     * Asserts enabled: 56ms average
     */
    public static void main(String[] args) throws InterruptedException {
        int limit = args.length == 1 ? Integer.parseInt(args[0]) : 1000;
        int[] values = new int[20000000];
        values[500000] = -2;
        values[1000000] = -1;
        values[1500000] = -3;
        long[] times = new long[limit];
        for (int round = 0; round < limit; round++) {
            long start = System.currentTimeMillis();
            int smallest = min(values);
            long end = System.currentTimeMillis();
            times[round] = end - start;
        }
        System.out.println("Average time taken (ms): " + Arrays.stream(times).sum() / limit);
    }
}
