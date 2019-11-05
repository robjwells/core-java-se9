package ch05.ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 6. Section 5.1.6, “The finally Clause” (page 189) has an example of a broken
 * try statement with catch and finally clauses. Fix the code with
 * (a) catching the exception in the finally clause,
 * (b) a try/catch statement containing a try/finally statement, and
 * (c) a try-with-resources statement with a catch clause.
 */
public class TryVariations {
    static void tryBroken(Path path) throws IOException {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            // Read from in...
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            if (in != null) {
                in.close(); // Caution—might throw an exception
            }
        }
    }

    static void tryA_catchInFinally(Path path) {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            System.out.println("tryA_catchInFinally: Read from in...");
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close(); // Caution—might throw an exception
                }
            } catch (IOException ex) {
                System.err.println("Caught IOException on close: " + ex.getMessage());
            }
        }
    }

    static void tryB_nestedTry(Path path) {
        try {
            // Read from in...
            BufferedReader in = null;
            try {
                in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
                System.out.println("tryB_nestedTry: Read from in...");
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }

    static void tryC_withResources(Path path) {
        try (BufferedReader in = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            System.out.println("tryC_withResources: Read from in...");
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }
}
