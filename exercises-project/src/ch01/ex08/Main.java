package ch01.ex08;

import java.util.Scanner;

class Main {
    /**
     * Write a program that reads a string and prints all of its nonempty substrings.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        for (int start = 0; start <= s.length(); start++) {
            for (int end = start + 1; end <= s.length(); end++) {
                String substring = s.substring(start, end);
                if (!substring.isEmpty()) {
                    System.out.println(substring);
                }
            }
        }
    }
}
