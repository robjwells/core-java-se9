package ch05.ex08;

/**
 * Exercise 5.8
 *
 * For this exercise, you’ll need to read through the source code of
 * the java.util.Scanner class.
 *
 * If input fails when using a Scanner, the Scanner class catches
 * the exception and stops reading from the input source.
 *
 * What happens when the scanner is closed, and closing the input
 * source throws an exception?
 *
 * Compare this behavior with the handling of suppressed exceptions
 * in the try-with-resources statement.
 *
 * ---
 *
 * The scanner stores the exception if it’s an IOException in a
 * private variable, <tt>lastException</tt>. Other exceptions
 * are propagated.
 *
 * Here’s the code from <tt>close()</tt>:
 *
 * <pre><code>
 * public void close() {
 *     if (closed)
 *         return;
 *     if (source instanceof Closeable) {
 *         try {
 *             ((Closeable)source).close();
 *         } catch (IOException ioe) {
 *             lastException = ioe;
 *         }
 *     }
 *     sourceClosed = true;
 *     source = null;
 *     closed = true;
 * }
 * </code></pre>
 *
 * This is different from try-with-resources in that the IOException
 * from closing is available on the Scanner (through
 * <tt>ioException()</tt>), whereas with try-with-resources it is
 * added as a suppressed exception to another thrown exception.
 *
 */
public class ScannerExceptions {
    static class ExceptionA extends RuntimeException {}
    static class ExceptionB extends RuntimeException {}

    static class FakeCloseable implements AutoCloseable {
        @Override
        public void close() {
            throw new ExceptionA();
        }
    }

    /**
     * Results in ExceptionB, with ExceptionA added as a suppressed exception.
     */
    public static void main(String[] args) {
        try(FakeCloseable fc = new FakeCloseable()) {
            throw new ExceptionB();
        }
    }
}
