package ch01.ex01;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(Integer.toBinaryString(n));
        System.out.printf("%o\n", n);
        System.out.printf("%x\n", n);
        if (n != 0) {
            System.out.printf("1/n = %a\n", 1.0/n);
        }
        in.close();
    }
}
