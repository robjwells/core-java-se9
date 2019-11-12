package ch05.ex11;

/**
 * Exercise 5.11
 *
 * Write a recursive factorial method in which you print all stack frames before you return the value.
 * Construct (but don’t throw) an exception object of any kind and get its stack trace,
 * as described in Section 5.1.8, “Uncaught Exceptions and the Stack Trace” (page 192).
 */
public class FactorialStackTrace {
    public static void main(String[] args) {
        System.out.println("Ordinary recursive factorial:");
        factorial(6);
        System.out.println("\n\nTail-recursive factorial:");
        tailRecursiveFactorial(6);
    }

    public static int factorial(int n) {
        if (n == 1) {
            Exception ex = new RuntimeException();
            ex.printStackTrace();
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int tailRecursiveFactorial(int n) {
        return trfact(n, 1);
    }

    // The rubbish method name is to make it easy to distinguish
    // from the wrapper in the stack trace.
    //
    // The standard JVM does not support tail-call optimisation
    // so this is the same as the preceding recursive factorial
    // method, except with an extra frame for the wrapper.
    private static int trfact(int n, int total) {
        if (n == 1) {
            Exception ex = new RuntimeException();
            ex.printStackTrace();
            return total;
        }
        return trfact(n - 1, n * total);
    }
}
