package ch04.ex09;

import java.lang.reflect.Field;
import java.util.List;

public class UniversalStringRepresentation {
    public static class Pair<T> {
        public final T first;
        public final T second;

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(1, 2);
        System.out.println(universalRepresentation(p));

        List<Integer> l = List.of(1, 2);
        System.out.println(universalRepresentation(l));

        int[] intArray = {1, 2};
        System.out.println(universalRepresentation(intArray));

        String s = "1, 2";
        System.out.println(universalRepresentation(s));
    }

    public static <T> String universalRepresentation(T object) {
        StringBuilder output = new StringBuilder();
        output.append(object.getClass().getCanonicalName());
        output.append(" {\n");

        for (Field f : object.getClass().getDeclaredFields()) {
            output.append("    ");
            output.append(f.getName());
            output.append(": ");
            try {
                output.append(f.get(object).toString());
            } catch (IllegalAccessException exc) {
                output.append("*Could not access*");
            }
            output.append("\n");
        }
        output.append("}");

        return output.toString();
    }
}
