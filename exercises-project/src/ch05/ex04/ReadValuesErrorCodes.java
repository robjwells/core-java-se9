package ch05.ex04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ex 5.4 said to rewrite using error codes. Instead, I tried to implement Result in Java.
 *
 * It’s too unwieldy to use and there are casts needed at the use site, so this is a no-go
 * in its current form, but it was fun.
 */
public class ReadValuesErrorCodes {
    /**
     * Exercise 5.4: Read a file containing floating-point numbers into an ArrayList, wrapped in a Result.
     *
     * @param fileName the name of the file from which to read the floating-point numbers.
     * @return a <tt>Result</tt> containing an ArrayList of Doubles if the read was successful.
     */
    public static Result<ArrayList<Double>> readValues(String fileName) {
        ArrayList<Double> results = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextDouble()) {
                results.add(scanner.nextDouble());
            }
        } catch (FileNotFoundException exc) {
            return new Result.Failure<>(String.format("File %s not found.", fileName));
        }
        return new Result.Success<>(results);
    }

    /**
     * Exercise 5.4: Sum the double values returned by <tt>readValues</tt>, wrapped in a Result.
     *
     * @param filename the file to read
     * @return the sum of the double values in the file
     */
    public static Result<Double> sumOfValues(String filename) {
        Result<ArrayList<Double>> values = readValues(filename);
        switch (values.outcome) {
            case FAILURE:
                return new Result.Failure<>(((Result.Failure<?>) values).reason);
            case SUCCESS:
                return new Result.Success<>(
                        ((Result.Success<ArrayList<Double>>) values).value.stream().mapToDouble(d -> d).sum()
                );
            default:
                return null; // Unreachable.
        }
    }


    private abstract static class Result<T> {
        private enum ResultOutcome {SUCCESS, FAILURE}
        public ResultOutcome outcome;

        private Result() {
        }

        public static class Failure<T> extends Result<T> {
            public final ResultOutcome outcome = ResultOutcome.FAILURE;
            public final String reason;

            public Failure(String reason) {
                this.reason = reason;
            }
        }

        public static class Success<T> extends Result<T> {
            public final ResultOutcome outcome = ResultOutcome.SUCCESS;
            public final T value;

            public Success(T value) {
                this.value = value;
            }
        }
    }

}
