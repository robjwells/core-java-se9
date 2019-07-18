class Ex1_16 {
    public static void main(String[] args) {
        System.out.println(average(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(average(1));
        System.out.println(average(1, 2));
        System.out.println(average(1, 2, 3));
        // Following does not compile as it requires at least one argument
        // System.out.println(average());
    }

    public static double average(double first, double... rest) {
        double sum = first;
        for (double d : rest) {
            sum += d;
        }
        return sum / (1 + rest.length);
    }
}
