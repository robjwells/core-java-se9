package ch03.ex06;

import ch03.ex04.IntSequence;

public class SquareSequence implements IntSequence {
    private int i;

    /**
     * Ex 3.6 asks: The <code>SquareSequence</code> class doesn’t actually deliver an infinite
     * sequence of squares due to integer overflow. Specifically, how does it behave?
     * <p>
     * Because of the use of two’s complement for the <code>int</code> type, we end up with these
     * results as the value of <code>i</code> nears and then passes the square root of
     * <code>Integer.MAX_VALUE</code>:
     * <p>
     * 2147302921
     * 2147395600
     * -2147479015
     * -2147386332
     */
    public static void main(String[] args) {
        SquareSequence sq = new SquareSequence();
        for (int x = 0; x < (Math.sqrt(Integer.MAX_VALUE) - 10); x++) {
            sq.next();
        }
        for (int x = 0; x < 100; x++) {
            System.out.println(sq.next());
        }
    }

    @Override
    public int next() {
        i++;
        return i * i;
    }
}
