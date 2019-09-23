package ch03.ex04;

public class OfTest {
    public static void main(String[] args) {
        IntSequence seq = IntSequence.of(9, 8, 7, 6, 5);
        while (seq.hasNext()) System.out.println(seq.next());
    }
}
