package ch01.ex03;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int x_or_y = x > y ? x : y;
        System.out.println(
            x_or_y > z ? x_or_y : z
        );
        System.out.println(
            Math.max(Math.max(x, y), z)
        );
        in.close();
    }
}
