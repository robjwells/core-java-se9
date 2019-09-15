package ch01.ex06;

import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        BigInteger factorial = BigInteger.valueOf(n);
        for (
            BigInteger current = factorial.subtract(BigInteger.ONE);
            current.compareTo(BigInteger.ZERO) > 0;
            current = current.subtract(BigInteger.ONE)
        ) {
            factorial = factorial.multiply(current);
        }
        System.out.printf("Factorial of %s = %s\n", n, factorial);
}
}
