package ch04.ex10;

import ch04.ex06.DiscountedItem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Use the MethodPrinter program in Section 4.5.1, “EnumeratingClassMembers” (page 168)
 * to enumerate all methods of the int[] class.
 * Extra credit if you can identify the one method (discussed in this chapter)
 * that is wrongly described.
 *
 * Is it clone? It is listed in Java 13.
 */
public class MethodPrinter {
    public static void main(String[] args) {
        // System.out.println(listMethods(MethodPrinter.class));
        // System.out.println(listMethods(int[].class));
        // System.out.println(listMethods(Class.class));
        // System.out.println(listMethods(DiscountedItem.class));
        try {
            printMethodsBookMethod(int[].class.getName());
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }

    public static void printMethodsBookMethod(String className) throws ClassNotFoundException {
        Class<?> cl = Class.forName(className);
        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " " +
                                m.getReturnType().getCanonicalName() + " " +
                                m.getName() +
                                Arrays.toString(m.getParameterTypes())
                );
            }
            cl = cl.getSuperclass();
        }
    }

    public static String listMethods(Class c) {
        return listMethods(c, false);
    }

    public static String listMethods(Class c, boolean printObjectMethods) {
        StringBuilder output = new StringBuilder();
        output.append(Modifier.toString(c.getModifiers()))
                .append(" class ")
                .append(c.getSimpleName())
                .append(" {\n");

        for (Constructor<?> constructor : c.getConstructors()) {
            output.append("    ");
            if (constructor.getModifiers() != 0) {
                output.append(Modifier.toString(constructor.getModifiers()))
                        .append(" ");
            }
            output.append(constructor.getName())
                    .append("(")
                    .append(joinSimpleNames(constructor.getParameterTypes()));
            if (constructor.isVarArgs()) {
                output.append("...");
            }
            output.append(")");
            if (constructor.getExceptionTypes().length != 0) {
                output.append(" ")
                        .append(joinSimpleNames(constructor.getExceptionTypes()));
            }
            output.append("\n");
        }

        while (c != null) {
            if (c.getDeclaredMethods().length != 0) {
                output.append("    // Methods from ").append(c.getSimpleName()).append("\n");
                for (Method m : c.getDeclaredMethods()) {
                    output.append("    ");
                    if (m.getModifiers() != 0) {
                        output.append(Modifier.toString(m.getModifiers()))
                                .append(" ");
                    }
                    output.append(m.getReturnType().getSimpleName())
                            .append(" ")
                            .append(m.getName())
                            .append("(")
                            .append(joinSimpleNames(m.getParameterTypes()));
                    if (m.isVarArgs()) {
                        // Trim [] from final parameter type
                        output.replace(output.length() - 2, output.length(), "");
                        output.append("...");
                    }
                    output.append(")");
                    if (m.getExceptionTypes().length > 0) {
                        output.append(" throws ")
                                .append(joinSimpleNames(m.getExceptionTypes()));
                    }
                    output.append("\n");
                }
            }
            c = c.getSuperclass();
            if (c != null && c.equals(Object.class)) {
                break;
            }
        }
        output.append("}");
        return output.toString();
    }

    private static String joinSimpleNames(Class[] classes) {
        return Arrays.stream(classes)
                .map(Class::getSimpleName)
                .collect(Collectors.joining(", "));
    }

}
