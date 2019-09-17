package ch02.ex10;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {
    private static Random generator = new Random();

    public static int nextInt(int low, int high) {
        return low + generator.nextInt(high - low + 1);
    }

    /**
     * Return a random element from <code>integers</code>.
     * <p>
     * Returns 0 if <code>integers</code> is empty. (!!! but that’s what the exercise says.)
     *
     * @param integers an array of <code>int</code> to choose from
     * @return a random element from <code>integers</code> or 0 if <code>integers</code> is empty
     */
    public static int randomElement(int[] integers) {
        if (integers.length == 0) {
            return 0;
        }
        int index = generator.nextInt(integers.length);
        return integers[index];
    }

    /**
     * Return a random element from <code>integers</code>.
     * <p>
     * Returns 0 if <code>integers</code> is empty. (!!! but that’s what the exercise says.)
     *
     * @param integers an <code>ArrayList</code> of <code>Integer</code> to choose from
     * @return a random element from <code>integers</code> or 0 if <code>integers</code> is empty
     */
    public static int randomElement(ArrayList<Integer> integers) {
        if (integers.size() == 0) {
            return 0;
        }
        int index = generator.nextInt(integers.size());
        return integers.get(index);
    }

}
