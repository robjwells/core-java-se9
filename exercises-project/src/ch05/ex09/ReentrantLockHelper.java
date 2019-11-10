package ch05.ex09;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHelper implements AutoCloseable {
    private final ReentrantLock lock;
    public ReentrantLockHelper(ReentrantLock lock) {
        this.lock = lock;
        lock.lock();
        System.out.println("ReentrantLockHelper: Lock acquired.");
    }

    @Override
    public void close() {
        lock.unlock();
        System.out.println("ReentrantLockHelper: Lock released.");
    }
}
