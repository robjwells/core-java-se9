class Ex1_4 {
    public static void main(String[] args) {
        System.out.println("Using constants:");
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

        System.out.println("Using Double.nextUp():");
        System.out.println(Math.nextUp(0.0));
        // /* This is too slow */
        // double d = Math.pow(2, 1023);
        // while (true) {
        //     double next = Math.nextUp(d);
        //     if (next == Double.POSITIVE_INFINITY) {
        //         System.out.println(d);
        //         break;
        //     }
        //     d = next;
        // }
    }
}
