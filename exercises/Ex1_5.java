class Ex1_5 {
    /**
     * What happens when you cast a double to an int that is
     * larger than the largest possible int value? Try it out.
     */
    public static void main(String[] args) {
        double big = Integer.MAX_VALUE + 11.0;
        System.out.printf("Double:  %.0f\n", big);
        System.out.printf("Integer: %d\n", (int) big);
        System.out.printf(
            "Is cast double equal to Integer.MAX_VALUE? %s\n",
            ((int) big) == Integer.MAX_VALUE
        );
    }
}
