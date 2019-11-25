package ch06.ex01;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack<E> {
    private final ArrayList<E> storage = new ArrayList<>();

    public void push(E element) {
        storage.add(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return storage.remove(storage.size() - 1);
    }

    public boolean isEmpty() {
        return storage.size() == 0;
    }
}
