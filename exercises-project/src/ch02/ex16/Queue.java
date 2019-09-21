package ch02.ex16;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Implement a class Queue, an unbounded queue of strings. Provide methods add, adding at the tail,
 * and remove, removing at the head of the queue. Store elements as a linked list of nodes.
 * Make Node a nested class. Should it be static or not?
 * <p>
 * Yes, Node should be static -- it doesn't depend on the Queue.
 * There is a case for having it *not* be static so it can access the head node (as
 * we're using a circular list to avoid null).
 * <p>
 * I've made Queue generic because why not?
 *
 * @param <T> the type of the stored values (not just String as per the exercise)
 */
public class Queue<T> implements Iterable<T> {
    // We're using a circular doubly-linked list, so head.previous is the tail,
    // and head.next is the oldest item in the queue
    private Node<T> head;

    public Queue() {
        Node<T> headNode = new Node<>(null);
        headNode.isHeadNode = true;
        headNode.previous = headNode;
        headNode.next = headNode;
        head = headNode;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forEach(queue::add);
        Optional<Integer> opt;
        while ((opt = queue.remove()).isPresent()) {
            System.out.println("While: " + opt.get());
        }

        System.out.println();

        Queue<String> sq = new Queue<>();
        Stream.of("a", "b", "c", "d").forEach(sq::add);
        Optional<String> optS;
        while ((optS = sq.remove()).isPresent()) {
            System.out.println("While: " + optS.get());
        }

        System.out.println();

        Queue<String> iq = new Queue<>();
        Stream.of("a", "b", "c", "d").forEach(iq::add);
        for (String s : iq) {
            System.out.println("Iterator: " + s);
        }

    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        head.previous.next = newNode;
        newNode.previous = head.previous;

        head.previous = newNode;
        newNode.next = head;
    }

    public Optional<T> remove() {
        if (head.next.isHeadNode) {
            return Optional.empty();
        }
        Node<T> toRemove = head.next;

        head.next = toRemove.next;
        head.next.previous = head;

        return Optional.of(toRemove.value);
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private static class Node<T> {
        T value;
        Node<T> previous;
        Node<T> next;
        boolean isHeadNode = false;

        Node(T value) {
            this.value = value;
        }
    }

    private class QueueIterator implements Iterator<T> {
        private Node<T> current;

        QueueIterator() {
            current = head.next;
        }

        @Override
        public boolean hasNext() {
            return !(current.next.isHeadNode);
        }

        @Override
        public T next() {
            current = current.next;
            if (current.isHeadNode) {
                throw new NoSuchElementException();
            }
            return current.value;
        }
    }
}
