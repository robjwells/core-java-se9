package ch05.ex05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Exercise 5.5
 * <p>
 * Implement a method that contains the code with a Scanner and a PrintWriter in Section 5.1.5,
 * “The Try-with-Resources Statement” (page 187).
 * But don’t use the try-with-resources statement. Instead, just use catch clauses.
 * Be sure to close both objects, provided they have been properly constructed.
 * <p>
 * You need to consider the following conditions:
 * <ul>
 * <li>The Scanner constructor throws an exception.</li>
 * <li>The PrintWriter constructor throws an exception.</li>
 * <li>hasNext, next, or println throw an exception.</li>
 * <li>out.close() throws an exception.</li>
 * <li>in.close() throws an exception.</li>
 * </ul>
 */
public class Catch {
    public static void main(String[] args) {
        scanAndPrint();
    }

    static void scanAndPrint() {
        try {
            Scanner in = new Scanner(Paths.get("/usr/share/dict/words"));
            try {
                PrintWriter out = new PrintWriter("output.txt");
                try {
                    while (in.hasNext()) {
                        out.println(in.next().toLowerCase());
                    }
                } catch (Exception outer) {
                    System.err.println("Error occurred with hasNext, next or println.");
                    try {
                        out.close();
                        in.close();
                    } catch (Exception inner) {
                        System.err.println("Exception occurred trying to close in & out.");
                        outer.addSuppressed(inner);
                    }
                    outer.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                System.err.println("FileNotFound when trying to create the PrintWriter.");
                try {
                    in.close();
                } catch (Exception ex) {
                    System.err.println("Exception when trying to close the scanner.");
                    e.addSuppressed(ex);
                }
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.err.println("IOException when trying to create the Scanner.");
            e.printStackTrace();
        }
    }
}
