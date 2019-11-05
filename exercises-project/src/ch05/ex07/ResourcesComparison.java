package ch05.ex07;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class ResourcesComparison {
    // `throws Exception` added to keep code examples as-is but not block compilation.
    public static void main(String[] args) throws Exception {
        String outputFile = "outfile.txt";

        // Exercise 5.7: Explain why
        try (Scanner in = new Scanner(Paths.get("/usr/share/dict/words"));
             PrintWriter out = new PrintWriter(outputFile)) {
            while (in.hasNext()) out.println(in.next().toLowerCase());
        }
        // is better than
        Scanner in = new Scanner(Paths.get("/usr/share/dict/words"));
        PrintWriter out = new PrintWriter(outputFile);
        try (in; out) {
            while (in.hasNext()) out.println(in.next().toLowerCase());
        }

        /*
          The former is better than the latter as, presuming that it is paired
          with a catch clause, as it will catch exceptions thrown by the
          two constructors.

          Additionally, the variables are scoped to the try block in the former,
          but exist independently of it in the latter.
         */
    }
}
