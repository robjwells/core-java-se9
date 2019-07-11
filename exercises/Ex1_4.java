class Ex1_4 {
    public static void main(String[] args) {
        System.out.println("Using constants:");
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

        System.out.println("Using Double.nextUp() and Double.nextDown():");
        System.out.println(Math.nextUp(0.0));
        System.out.println(Math.nextDown(Double.POSITIVE_INFINITY));
    }
}
