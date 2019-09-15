package ch01.ex10;

import java.util.Random;

class Main {
    public static void main(String[] args) {
        long randomLong = new Random().nextLong();
        String base36Long = Long.toString(randomLong, 36);
        long roundTripped = Long.parseLong(base36Long, 36);
        System.out.println(randomLong);
        System.out.println(base36Long);
        System.out.println(roundTripped);
    }
}
