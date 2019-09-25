package ch03.ex04;

import java.util.NoSuchElementException;

@FunctionalInterface
public interface IntSequence {
    static IntSequence of(int... integers) {
        return new IntSequence() {
            private int index = 0;

            public boolean hasNext() {
                return index < integers.length;
            }

            public int next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int val = integers[index];
                index++;
                return val;
            }
        };
    }

    /**
     * Return an infinite IntSequence where each item is <code>value</code>.
     * @param value the <code>int</code> to be returned from the <code>IntSequence</code>
     * @return an <code>IntSequence</code> whose <code>next</code> method always gives <code>value</code>
     */
    static IntSequence constant(int value) {
        return () -> value;
    }

    default boolean hasNext() {
        return true;
    }

    int next();
}
