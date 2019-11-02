package ch05.ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadValues {
    /**
     * Exercise 5.1: Read a file containing floating-point numbers into an ArrayList.
     *
     * @param fileName the name of the file from which to read the floating-point numbers.
     * @return an <tt>ArrayList</tt> containing all of the floating-point numbers in the file.
     * @throws FileNotFoundException should the file with the given <tt>fileName</tt> not be found.
     */
    public static ArrayList<Double> readValues(String fileName) throws FileNotFoundException {
        ArrayList<Double> results = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextDouble()) {
                results.add(scanner.nextDouble());
            }
        }
        return results;
    }

    /**
     * Exercise 5.2: Sum the double values returned by <tt>readValues</tt>.
     *
     * @param filename the file to read
     * @return the sum of the double values in the file
     * @throws FileNotFoundException rethrown from <tt>readValues</tt>
     */
    public static double sumOfValues(String filename) throws FileNotFoundException {
        return readValues(filename).stream().mapToDouble(d -> d).sum();
    }

    /**
     * Exercise 5.3: Call the <tt>sumOfValues</tt> method and provide feedback to the user.
     * @param args The first command-line argument should be the filename to read.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please provide the filename as the first and only argument.");
            return;
        }
        try {
            System.out.println(sumOfValues(args[0]));
        } catch (FileNotFoundException exc) {
            System.err.printf("Could not find file %s.\n", args[0]);
        }
    }
}
