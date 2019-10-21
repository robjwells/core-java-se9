package ch04.ex08;

import java.util.List;

public class ClassStringRepresentations {
    // arrays, generic types, inner classes, and primitive types

    private class InnerClass {
        int x;
    }

    public static void main(String[] args) {
        List<Class> classes = List.of(
                int[].class,
                List.of(1).getClass(),
                InnerClass.class,
                int.class
        );
        for (Class c : classes) {
            System.out.println("getCanonicalName(): " + c.getCanonicalName());
            System.out.println("getSimpleName(): " + c.getSimpleName());
            System.out.println("getTypeName(): " + c.getTypeName());
            System.out.println("getName(): " + c.getName());
            System.out.println("toString(): " + c.toString());
            System.out.println("toGenericString(): " + c.toGenericString());
            System.out.println();
        }
    }
}
