// Package declaration given by the exercise instruction
// (ie not a mistake!)
package ch01.sec01;

/**
 * Ex 2.12
 *
 * <strong>Problem statement:</strong>
 * Make a file HelloWorld.java that declares a class HelloWorld in a package ch01.sec01.
 * Put it into some directory, but not in a ch01/sec01 subdirectory.
 * From that directory, run javac HelloWorld.java.
 * Do you get a class file? Where? Then run java HelloWorld. What happens? Why?
 * (Hint: Run javap HelloWorld and study the warning message.)
 * Finally, try javac -d . HelloWorld.java. Why is that better?
 *
 * <strong>Results:</strong>
 * After running javac HelloWorld.java, the Java compiler creates a class file in the same directory.
 * However, attempting to run the class (java HelloWorld) gives the following error:
 * <pre><code>
 * Error: Could not find or load main class HelloWorld
 * Caused by: java.lang.NoClassDefFoundError: ch01/sec01/HelloWorld (wrong name: HelloWorld)
 * </code></pre>
 * The class can't be found as it's not stored in a directory that matches its package declaration;
 *
 * The output from the disassembler (javap HelloWorld):
 * <pre><code>
 * Warning: File ./HelloWorld.class does not contain class HelloWorld
 * Compiled from "HelloWorld.java"
 * public class ch01.sec01.HelloWorld {
 *   public ch01.sec01.HelloWorld();
 *   public static void main(java.lang.String[]);
 * }
 * </code></pre>
 *
 * javac -d . HelloWorld.java creates the right directory structure, but attempting to run
 * java HelloWorld (from the root or from inside that structure) still gives the same error.
 *
 * Hypothesis: perhaps this is because this is already inside a project?
 * No; tried moving the file to the desktop, same results with javac -d ...
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
