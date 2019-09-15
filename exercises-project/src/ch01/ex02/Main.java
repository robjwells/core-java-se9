package ch01.ex02;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int angle = in.nextInt();
        System.out.printf("%%:        %d\n", angle % 360);
        System.out.printf("floorMod: %d\n", Math.floorMod(angle, 360));
        in.close();
    }
}
