package ch06.ex02;

import java.util.Arrays;

public class Stack<E> {
    private static final int MINIMUM_SIZE = 10;
    @SuppressWarnings("unchecked")
    private E[] storage = (E[]) new Object[MINIMUM_SIZE];
    private int size = 0;

    private void resizeIfNecessary() {
        if (size == storage.length) {
            storage = Arrays.copyOf(storage, storage.length * 2);
        } else if (size > MINIMUM_SIZE && size == storage.length / 4) {
            storage = Arrays.copyOf(storage, storage.length / 2);
        }
    }

    public void push(E element) {
        resizeIfNecessary();
        storage[size++] = element;
    }

    public E pop() {
        E element = storage[--size];
        resizeIfNecessary();
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
