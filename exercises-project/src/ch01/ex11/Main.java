package ch01.ex11;

import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        String input = args[0];
        IntStream.range(0, input.length())
            .filter(index -> input.codePointAt(index) > 127)
            .mapToObj(index -> input.substring(index, index + 1))
            .map(c -> String.format("%s\t%s", c, c.codePointAt(0)))
            .forEach(System.out::println);
    }
}
