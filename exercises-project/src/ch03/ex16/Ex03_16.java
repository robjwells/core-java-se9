package ch03.ex16;

import java.util.Random;

public class Ex03_16 {
    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }

    private static class RandomSequence implements IntSequence {
        private static final Random generator = new Random();
        private final int low;
        private final int high;

        private RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
    }
}
