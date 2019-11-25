package ch06.ex02;

import java.util.Arrays;

/*
Compared to the Stack class in this package, this uses a plain Object[]
to store the data, and performs the cast when retrieving elements from
the array on pop().

I much prefer the casting of the array to E[] in Stack over this approach
as it keeps the cast at the original assignment (where it is assigned
with a default value), and it never has to be considered again.

I don’t like pushing the cast into the method, as my feeling is that
it would be easier to introduce a bug if pop() were ever refactored
(hypothetical).
 */
public class StackObjectArray<E> {
    private static final int MINIMUM_SIZE = 10;
    private Object[] storage = new Object[MINIMUM_SIZE];
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
        @SuppressWarnings("unchecked") E element = (E) storage[--size];
        resizeIfNecessary();
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
