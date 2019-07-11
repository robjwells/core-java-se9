import java.util.Scanner;

class Ex1_7 {
    /**
     * Write a program that reads in two integers between 0 and 4294967295, stores
     * them in int variables, and computes and displays their unsigned sum,
     * difference, product, quotient, and remainder. Do not convert them to long
     * values.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = Integer.parseUnsignedInt(in.next());
        int b = Integer.parseUnsignedInt(in.next());
        in.close();

        System.out.printf("a = %s, b = %s\n", Integer.toUnsignedString(a), Integer.toUnsignedString(b));
        System.out.printf("a + b = %s\n", Integer.toUnsignedString(a + b));
        System.out.printf("a - b = %s\n", Integer.toUnsignedString(a - b));
        System.out.printf("a * b = %s\n", Integer.toUnsignedString(a * b));
        System.out.printf("a / b = %s\n", Integer.divideUnsigned(a, b));
        System.out.printf("a %% b = %s\n", Integer.remainderUnsigned(a, b));
    }
}
