import java.util.Scanner;

class Ex1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int angle = in.nextInt();
        System.out.printf("%%:        %d\n", angle % 360);
        System.out.printf("floorMod: %d\n", Math.floorMod(angle, 360));
    }
}
