package javaimpatient.ch04.sec01;

public interface Named {
    default String getName() { return ""; }
}
