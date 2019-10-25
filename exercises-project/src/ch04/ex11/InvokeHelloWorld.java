package ch04.ex11;

import java.lang.reflect.InvocationTargetException;

public class InvokeHelloWorld {
    public static void main(String[] args) {
        printThroughReflection("Hello, world!");
    }

    public static void printThroughReflection(String... args) {
        try {
            System.out.getClass()
                    .getMethod("println", String.class)
                    .invoke(System.out, "Hello, world!");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exc) {
            exc.printStackTrace();
        }
    }
}
