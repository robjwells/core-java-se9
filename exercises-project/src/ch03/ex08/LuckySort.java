package ch03.ex08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LuckySort {
    public static void luckySort(ArrayList<String> strings, Comparator<String> comparator) {
        while (!isSorted(strings, comparator)) {
            Collections.shuffle(strings);
        }
    }

    private static boolean isSorted(ArrayList<String> strings, Comparator<String> comparator) {
        for (int index = 0; index < strings.size() - 1; index++) {
            String first = strings.get(index);
            String second = strings.get(index + 1);
            if (comparator.compare(first, second) >= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(List.of("d", "c", "b", "a"));
        luckySort(strings, Comparator.naturalOrder());
        System.out.println("Sorted: " + strings);
    }
}
