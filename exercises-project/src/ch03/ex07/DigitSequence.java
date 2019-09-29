package ch03.ex07;

import java.util.Iterator;

/**
 * Ex 3.7: Only implementing the class as a good-faith effort,
 * but not attempting the Java 7/8 differences as I don’t have
 * Java 7 (or 8!) installed.
 */
public class DigitSequence implements Iterator<Integer> {
    private int current;

    /**
     * Construct a <tt>DigitSequence</tt> that starts from 0.
     */
    public DigitSequence() {
        this(0);
    }

    /**
     * Construct a <tt>DigitSequence</tt> that starts from <tt>current</tt>.
     *
     * @param current the starting integer value of the <tt>DigitSequence</tt>
     */
    public DigitSequence(int current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != (Integer.MAX_VALUE);
    }

    @Override
    public Integer next() {
        return current++;
    }
}
